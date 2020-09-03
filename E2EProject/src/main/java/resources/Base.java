 package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Base {

	public WebDriver driver;
	public Properties prop =  new Properties();
	
	public WebDriver initializeDriver() throws IOException {
		
		
		
		//Properties prop =  new Properties();
		
		prop =  new Properties();
		
		//Below can be used to get rid of hard coded file path
		//System.getProperty("user.dir");
		
		FileInputStream fis =  new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\resources\\data.properties");
		//FileInputStream fis =  new FileInputStream("E:\\Automation\\E2EProject\\src\\main\\java\\resources\\data.properties");
		
		prop.load(fis);
		
		//to pass browser info to maven - mvn test -Dbrowser=chrome
		
		String browserName = System.getProperty("browser");
		//String browserName = prop.getProperty("browser");
		
		System.out.println(browserName);
		
		//String url = prop.getProperty("url");
		//System.out.println(url);
		
		if (browserName.contains("chrome")) {
			
			//execute in chrome
			System.setProperty("webdriver.chrome.driver","C:\\automation\\chromedriver.exe");
			
			//to run headless execution create an object of class ChromeOptions
			
			ChromeOptions options = new ChromeOptions();
			
			if(browserName.contains("headless")) {
				
				options.addArguments("headless");
			
			}
			driver = new ChromeDriver(options);
			
			//driver = new ChromeDriver();
			
			
		}
			
		else if (browserName.equals("firefox")) {
			//execute in firefox
			driver = new FirefoxDriver();
		}
		else if (browserName.equals("ie")) {
			//execute in IE
			driver = new FirefoxDriver();
			
		}
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
		
	}

	
	public void getScreenShotPath(String testCaseName,WebDriver driver) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source =  ts.getScreenshotAs(OutputType.FILE);
		String destinationFile = System.getProperty("user.dir")+"\\reports\\" +testCaseName+".png";
		FileUtils.copyFile(source,new File(destinationFile));
	}
	
	
}

package Academy;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.Base;

public class HomePage extends Base {
	
	public WebDriver driver;
	
	@BeforeTest
	public void initialize() throws IOException {
//		initializeDriver id = new initializeDriver();
		
		
			driver = initializeDriver();
			driver.get(prop.getProperty("url"));
	}
	
	
	@Test(dataProvider = "getData")	
	public void basePageNavigation(String username,String password) throws IOException {
		
			
		driver.get(prop.getProperty("url"));
		
		LandingPage lp = new LandingPage(driver);
		lp.getLogin().click();
		
		LoginPage logp = new LoginPage(driver);
		
		logp.GetEmail().sendKeys(username);
		logp.GetPassword().sendKeys(password);
		logp.GetLoginButton().click();
		System.out.println(username);
		
	}
	
	@AfterTest
	public void terardown() {
	driver.close();
		
	}
	
	@DataProvider
	public Object[][] getData() {
		//Row stands for how many different data types test should run
		Object[][] data = new Object[2][2];
		data[0][0] = "nonrestricteduser@ab.com";
		data[0][1] = "123";
	//	data[0][2] = "non restricted user";
		
		data[1][0] = "restricteduser@ab.com";
		data[1][1] = "1234";
		//data[1][2] = "restricted user";
		
		return data;
		
		
	}

	


}



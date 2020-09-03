package Academy;

import org.testng.annotations.Test;



import org.testng.annotations.Test;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.Base;

public class ValidateHomePageTitle extends Base {
	
	public WebDriver driver;
	public static Logger log = LogManager.getLogger(Base.class.getName());
	
	@BeforeTest
	public void initialize() throws IOException {
//		initializeDriver id = new initializeDriver();
		
		
			driver = initializeDriver();
			log.info("driver is initialized");
			
			driver.get(prop.getProperty("url"));
			log.info("navigated to home page");
	}

	
	
	@Test	
	public void basePageNavigation() throws IOException {
		
	//	initializeDriver id = new initializeDriver();
		
		
		
		//driver.get("Http://qaclickacademy.com");
		
		LandingPage lp = new LandingPage(driver);
		lp.getTitle().getText();
		
		//compare the test from the browser with actual value = FEATURED COURSES
		//Assert.assertEquals(lp.getTitle().getText(), "Featured courses");
		//Assert.assertEquals(lp.getTitle().getText(), "Featured courses");
		Assert.assertEquals(lp.getTitle().getText(), "FEATURED COURSES123");
		log.info("title compared");
		
	}
	
	@AfterTest
	public void terardown() {
	driver.close();
		
	}
}
	
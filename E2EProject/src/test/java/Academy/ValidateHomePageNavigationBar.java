package Academy;

import org.testng.annotations.Test;
import org.testng.annotations.Test;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.Base;

public class ValidateHomePageNavigationBar extends Base {
	public WebDriver driver;
	
	@BeforeTest
	public void initialize() throws IOException {
//		initializeDriver id = new initializeDriver();
		
		
			driver = initializeDriver();
			driver.get(prop.getProperty("url"));
	}
	
	@Test	
	public void basePageNavigation() throws IOException {
		
	
		
		//driver.get("Http://qaclickacademy.com");
		
		LandingPage lp = new LandingPage(driver);
		lp.getNavigationBar();
		
		//compare the test from the browser with actual value = FEATURED COURSES
		//Assert.assertEquals(lp.getTitle().getText(), "Featured courses");
		//Assert.assertEquals(lp.getTitle().getText(), "Featured courses");
		 Assert.assertTrue(lp.getNavigationBar().isDisplayed());
		
	}
	
	@AfterTest
	public void terardown() {
	driver.close();
		
	}
}
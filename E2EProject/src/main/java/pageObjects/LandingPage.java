package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LandingPage {
	
	public WebDriver driver;
	
	By signin=By.cssSelector("a[href*='sign_in']");
	
	By title=By.xpath("//h2[contains(text(),'Featured Courses')]");
	
	By navigationbar=By.cssSelector("div [class*='navbar-right']");
	
	
	
	public LandingPage(WebDriver driver2) {
		// TODO Auto-generated constructor stub
		this.driver = driver2;
		
	}


	public WebElement getLogin() {
		
		return driver.findElement(signin);
	}
	
	public WebElement getTitle() {
		
		return driver.findElement(title);
		
	}
	
	public WebElement getNavigationBar() {
		
		return driver.findElement(navigationbar);
		
	}
}

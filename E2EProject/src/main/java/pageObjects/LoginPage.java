package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
	
	public WebDriver driver;
	
	By emailid=By.id("user_email");
	By password=By.xpath("//input[@type='password']");
	By loginbtn=By.cssSelector("input[class*='login-button']");
	


	//or use page factory
	//@FindBy(CssSelector = "//*[@id='login1']")
	//WebElement signin;
	
	
	public LoginPage(WebDriver driver2) {
		// TODO Auto-generated constructor stub
		this.driver = driver2;
		
	}


	public WebElement GetEmail() {
		
		return driver.findElement(emailid);
	}
	
	public WebElement GetPassword() {
		
		 return driver.findElement(password);
		
	}
	
	public WebElement GetLoginButton() {
		
		 return driver.findElement(loginbtn);
		
	}
}

package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {
	
	public WebDriver driver;
	
	//By logIn = By.xpath("//button[contains(text(),'Login')]");
	//By logIn = By.cssSelector("a[href*='sign in']");
	By logIn = By.xpath("//span[contains(text(),'Login')]");
	By title = By.xpath("//h2[contains(text(),'Featured Courses')]");
	By NavBar = By.xpath("//header/div[2]");
	
	public LandingPage(WebDriver driver) {
		this.driver=driver;
	}

	public LogInPage getLogIn() {
		driver.findElement(logIn).click();
		LogInPage lp = new LogInPage(driver);
		return lp;
	}
	
	public WebElement getTitle() {
		return driver.findElement(title);
	}
	
	public WebElement validateNavBar() {
		return driver.findElement(NavBar);
	}
}

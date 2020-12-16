package Java_Selenium;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.LandingPage;

import resources.base;

public class ValidateTitle extends base{
	public WebDriver driver;
	public static Logger log =LogManager.getLogger(base.class.getName());
	@BeforeTest
	
	public void initizliation() throws IOException {
		driver = initializeDriver();
		driver.get(prop.getProperty("url"));
	}

	@Test
	
	public void basePageNavegation() throws IOException {
		LandingPage L = new LandingPage(driver);
		Assert.assertEquals(L.getTitle().getText(), "FEATURED COURSES1");
		driver.close();	
	}
	
	@AfterTest
	public void teardown() {
		driver.close();
	}


}

package Java_Selenium;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.model.Log;

import pageObjects.LandingPage;
import pageObjects.LogInPage;
import resources.base;

public class HomePage extends base{
	public WebDriver driver;
	@BeforeTest
	
	public void initizliation() throws IOException {
		driver = initializeDriver();
		
	}

	@Test (dataProvider="getData")
	
	public void basePageNavegation(String Username, String Password, String text) throws IOException {
		driver.get(prop.getProperty("url"));
		LandingPage L = new LandingPage(driver);
		LogInPage lp = new LogInPage(driver);
		lp.getEmail().sendKeys("abc@click.com");;
		lp.getPassword().sendKeys("trythis");

		//lp.getLogin();
	}
	
	@DataProvider
	public Object[][] getData() {
		Object[][] data = new Object[2][3];
		
		data[0][0] = "nonrestricteduser@click.com";
		data[0][1] = "trythis";
		data[0][2] = "No Restriction";
		
		data[0][0] = "restricteduser@click.com";
		data[0][1] = "tryfail";
		data[0][2] = "Restriction";
				
		return data;			
	}
	
	@AfterTest
	public void teardown() {
		driver.close();
	}

}

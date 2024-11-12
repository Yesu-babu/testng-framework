package testcase;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BaseTest;
import utilities.ReadXLData;

public class MyFirstTestFW extends BaseTest{
	
	@Test(dataProviderClass=ReadXLData.class,dataProvider="bvtdata")
	public static void LoginTest(String username, String password) throws InterruptedException{
		
	 driver.findElement(By.linkText(loc.getProperty("signin_link"))).click();
     driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	 driver.findElement(By.id(loc.getProperty("email_field"))).sendKeys(username);
	 driver.findElement(By.xpath(loc.getProperty("next_button"))).click();
	 Thread.sleep(4000);
	 driver.findElement(By.xpath(loc.getProperty("pwd_field"))).sendKeys(password);
	 Thread.sleep(4000);
	driver.findElement(By.xpath(loc.getProperty("login_next_button"))).click();
	
	 Thread.sleep(8000);
	 System.out.println("Login successful");

	}
	 
	
	


}

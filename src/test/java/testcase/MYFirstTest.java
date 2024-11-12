package testcase;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MYFirstTest {

	
	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(options);
		//EdgeOptions edgeOptions = new EdgeOptions().merge(chromeOptions);
       // driver = new EdgeDriver(edgeOptions);
		
		//WebDriverManager.chromedriver().setup();
		//WebDriver driver = new ChromeDriver(options);
		
		 // WebDriverWait wait = new WebDriverWait(driver, 10);
		 driver.get("https://www.zoho.com/");
		 String title=driver.getTitle();
		 System.out.println(title);
		 driver.manage().window().maximize();
		 driver.findElement(By.linkText("Sign In")).click();
	     driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		 driver.findElement(By.xpath("//input[@id='login_id']")).sendKeys("yesubabuerapani@gmail.com");

	       //driver.quit();


	}

}
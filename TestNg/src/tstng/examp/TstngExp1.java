package tstng.examp;



import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import org.testng.annotations.Test;

import net.bytebuddy.implementation.bind.annotation.BindingPriority;

public class TstngExp1 {
	static WebDriver driver;
	
	@BeforeClass
	private void beforeclass() {
System.setProperty("webdriver.chrome.driver","C:\\Users\\Ranjeith\\eclipse-workspace\\TestNg\\lib\\chromedriver.exe");
 driver=new ChromeDriver();
 driver.get("https://www.facebook.com/");
	}
	
	
	@BeforeMethod
	private void beforemethod() {
Date start =new Date();
System.out.println(start);
	}
	
	
	@AfterClass
	private void afterclass() throws InterruptedException {
		Thread.sleep(50000);
driver.quit();
	}
	
	
	@AfterMethod
	private void aftermethod() {
		Date end =new Date();
		System.out.println(end);
	}

	@Test
	private void test1() {
WebElement uname = driver.findElement(By.id("email"));
	}
	
}

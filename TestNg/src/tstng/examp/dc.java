package tstng.examp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class dc {
public static void main(String[] args) {
	System.setProperty("webdriver.chrome.driver","D:\\STUDIES\\testing softwares\\chromedriver_win32\\chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	driver.get("https://www.facebook.com/");
	WebElement unmae=driver.findElement(By.name("email"));
	unmae.sendKeys("ranjeith");
	WebElement pass=driver.findElement(By.name("pass"));
	pass.sendKeys("pass");
	WebElement btnclk= driver.findElement(By.name("login"));
	btnclk.click();
	
	
}
}

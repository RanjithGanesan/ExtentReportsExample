package ExtentReportsExample;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportCode {

	WebDriver driver;
	ExtentReports extentReports;
	ExtentSparkReporter spark;
	ExtentTest testCase;

	@BeforeSuite
	public void lanunchBrowser() {
		System.setProperty("webdriver.chrome.driver", "D:\\STUDIES\\testing softwares\\chromedriver_win32\\chromedriver.exe");
		extentReports=new ExtentReports();
		spark=new ExtentSparkReporter("ExtentReport");
		extentReports.attachReporter(spark);
		driver=new ChromeDriver();
	}

	@Test
	public void openGoogle() throws IOException {
		testCase=extentReports.createTest("Verifying Google TItle");
		driver.get("https://www.google.co.in");
		String title=driver.getTitle();
		testCase.info("Actual Title is: "+ title);
		testCase.info("Expected title is: " + "Google");
		if(title.equals("Google")) {
			System.out.println("Pass");
			testCase.log(Status.PASS, "Actual and Expected title are equal");
		}else {
			System.out.println("Fail");
			testCase.log(Status.FAIL, "Actual and Expected title are not equal");
			TakesScreenshot screenshot=(TakesScreenshot) driver;
			File sourceFile=screenshot.getScreenshotAs(OutputType.FILE);
			File destinationFile=new File("google.png");
			FileHandler.copy(sourceFile, destinationFile);
			testCase.addScreenCaptureFromPath("google.png");
		}
	}

	@Test
	public void openBing() throws IOException {
		testCase=extentReports.createTest("Verifying BIng TItle");
		driver.get("https://www.bing.com");
		String title=driver.getTitle();
		testCase.info("Actual Title is: "+ title);
		testCase.info("Expected title is: " + "Bing");
		if(title.equals("bing")) {
			testCase.log(Status.PASS, "Actual and Expected title are equal");
		}else {
			testCase.log(Status.FAIL, "Actual and Expected title are not equal");
			TakesScreenshot screenshot=(TakesScreenshot) driver;
			File sourceFile=screenshot.getScreenshotAs(OutputType.FILE);
			File destinationFile=new File("bing.png");
			FileHandler.copy(sourceFile, destinationFile);
			testCase.addScreenCaptureFromPath("bing.png");
		}
	}

	@Test
	public void openWikipedia() throws IOException {
		testCase=extentReports.createTest("Verifying Wikipedia Title");
		driver.get("https://www.bing.com");
		String title=driver.getTitle();
		testCase.info("Actual Title is: "+ title);
		testCase.info("Expected title is: " + "Wikipedia");
		if(title.equals("Wikipedia")) {
			System.out.println("Pass");
			testCase.log(Status.PASS, "Actual and Expected title are equal");
		}else {
			System.out.println("Fail");
			testCase.log(Status.FAIL, "Actual and Expected title are not equal");
			TakesScreenshot screenshot=(TakesScreenshot) driver;
			File sourceFile=screenshot.getScreenshotAs(OutputType.FILE);
			File destinationFile=new File("wiki.png");
			FileHandler.copy(sourceFile, destinationFile);
			testCase.addScreenCaptureFromPath("wiki.png");
		}
	}

	@AfterSuite
	public void closeBrowser() {
		driver.close();
		extentReports.flush();
	}


}

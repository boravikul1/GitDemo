package com.seleniumautomation.mavenproject;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReporter;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class AllLinksTest {
	
	ExtentReports extent;
	
	@BeforeTest
	public void extentReports()
	{
		String path = System.getProperty("user.dir")+"\\reports\\index.html";
		System.out.println(path);
		ExtentHtmlReporter reporter = new ExtentHtmlReporter(path);
		reporter.config().setReportName("Web Automation");
		reporter.config().setDocumentTitle("Test Results");
				
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Vikul Bora");
	}
	
	@Test
	public void linkTestRespCode() throws MalformedURLException, IOException
	{
		String screenshotPath = System.getProperty("user.dir")+"\\screenshots\\test.jpg";
		ExtentTest test = extent.createTest("Initial Demo");
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\borav\\drivers\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
		test.addScreenCaptureFromPath(screenshotPath);
		WebElement footerDriver = driver.findElement(By.id("gf-BIG"));
		List<WebElement> links =  footerDriver.findElements(By.tagName("a"));
		//SoftAssert a = new SoftAssert();
		for(WebElement link : links)
		{
			String url = link.getAttribute("href");
			//System.out.println(url);
			HttpURLConnection conn = (HttpURLConnection)new URL(url).openConnection();
			conn.setRequestMethod("HEAD");
			conn.connect();
			int respCode = conn.getResponseCode();
			System.out.println(respCode);
			//a.assertTrue(respCode < 400, "The Link with Text "+link.getText()+" is broken");
			extent.flush();
		}
		//a.assertAll();
		driver.close();

}
}

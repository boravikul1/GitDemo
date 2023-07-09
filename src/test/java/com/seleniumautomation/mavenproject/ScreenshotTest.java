package com.seleniumautomation.mavenproject;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class ScreenshotTest {

	@Test
	public void takeScreenshot() throws IOException
	{
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\borav\\drivers\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
		TakesScreenshot scrShot =((TakesScreenshot)driver);
		File scrFile = scrShot.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile, new File("C://Users//borav//Documents//Screenshot.png"));
		driver.close();
	}
	
}

package com.seleniumautomation.mavenproject;

import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BrowserTest {
	
	//WebDriver driver = new FirefoxDriver();
	
	@Test
	public void initializeBrowser()
	{
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\borav\\drivers\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
		WebElement blinkingText = driver.findElement(By.className("blinkingText"));
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(blinkingText));
		System.out.println(driver.findElement(By.className("blinkingText")).getText());
		driver.close();
	}

}

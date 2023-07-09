package com.seleniumautomation.mavenproject;

import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class ActionTest {
	
	@Test
	public void initializeBrowser() throws InterruptedException
	{
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\borav\\drivers\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();
		Actions a = new Actions(driver);
		WebElement searchBox = driver.findElement(By.xpath("//input[@title='Search']"));
		a.moveToElement(searchBox).click().keyDown(Keys.SHIFT).sendKeys("hello");
		
		Thread.sleep(2000);
		driver.close();
	}

}

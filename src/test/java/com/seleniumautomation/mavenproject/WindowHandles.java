package com.seleniumautomation.mavenproject;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WindowHandles {

	@Test
	public void initializeBrowser() throws InterruptedException
	{
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\borav\\drivers\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://rahulshettyacademy.com/loginpagePractise/#");
		driver.manage().window().maximize();
		driver.findElement(By.className("blinkingText")).click();
		Thread.sleep(2000);
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> it = windows.iterator();
		String parentId = it.next();
		String childId = it.next();
		driver.switchTo().window(parentId);
		Thread.sleep(2000);
		System.out.println("This is main window");
		System.out.println(driver.getTitle());
		driver.switchTo().window(childId);
		System.out.println("This is Child window");
		System.out.println(driver.getTitle());
		driver.close();
		driver.switchTo().window(parentId);
		driver.close();
	}
}

package com.seleniumautomation.mavenproject;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class LinksTest {
	
	@Test
	public void testlinks()
	{
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\borav\\drivers\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
		WebElement headerDriver = driver.findElement(By.xpath("//body/header"));
		WebElement footerDriver = driver.findElement(By.id("gf-BIG"));
		List<WebElement> linkCount = driver.findElements(By.tagName("a"));
		List<WebElement> linkCountHeader = headerDriver.findElements(By.tagName("a"));
		List<WebElement> linkCountFooter = footerDriver.findElements(By.tagName("a"));
		System.out.println("Link Count is : "+linkCount.size());
		System.out.println("Link Count is : "+linkCountHeader.size());
		System.out.println("Link Count is : "+linkCountFooter.size());
		driver.close();
	}

}

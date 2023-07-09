package com.seleniumautomation.mavenproject;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class FramesTest {

	
	@Test
	public void initializeBrowser() throws InterruptedException
	{
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\borav\\drivers\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://jqueryui.com/droppable/");
		driver.manage().window().maximize();
		WebElement frame =  driver.findElement(By.xpath("//iframe[@class='demo-frame']"));
		driver.switchTo().frame(frame);
		WebElement draggable = driver.findElement(By.id("draggable"));
		WebElement droppable = driver.findElement(By.id("droppable"));
		Actions a = new Actions(driver);
		a.dragAndDrop(draggable, droppable).build().perform();
		Thread.sleep(2000);
		driver.close();
	}
}

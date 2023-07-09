package com.seleniumautomation.mavenproject;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class FileUpload {
	
	@Test
	public void fileUpload() throws InterruptedException, IOException
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\borav\\eclipse-workspace\\E2EProject\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://smallpdf.com/pdf-to-jpg");
		driver.manage().window().maximize();
		driver.findElement(By.cssSelector("button[class*='hrcxSS']")).click();
		Thread.sleep(3000);
		//Call AutoIT script
		Runtime.getRuntime().exec("C:\\Users\\borav\\OneDrive - Aristocrat Gaming\\Documents\\AutoIT\\FileUpload.exe");
		Thread.sleep(3000);
		driver.close();
		
		
	}

}

package com.seleniumautomation.mavenproject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class WindowAuth {
	
	@Test
	public void windowAuthentication() throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\borav\\eclipse-workspace\\E2EProject\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://admin:admin@the-internet.herokuapp.com/");
		driver.manage().window().maximize();
		driver.findElement(By.linkText("Basic Auth")).click();
		String actualMessage = driver.findElement(By.tagName("h3")).getText().trim();
		String expectedMessage = "Basic Auth";
		System.out.println(actualMessage);
		System.out.println(expectedMessage);
		if(actualMessage.equalsIgnoreCase(expectedMessage))
			System.out.println("Entered Basic Auth");
		else
			System.out.println("Authentication Failed");
		Thread.sleep(3000);
		driver.close();
		
		
		
	}

}

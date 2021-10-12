package org.task;

import java.awt.AWTException;
import java.awt.Robot;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;


@Test

public class Demosite {
	public Demosite() throws Throwable {
		
		System.setProperty("webdriver.chrome.driver","E:\\Photon Workspace\\SampleTestNg\\Driver\\chromedriver94.exe");
	
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://www.agoda.com/en-in/");
		
		Actions a=new Actions(driver);
		WebElement destination=driver.findElement(By.xpath("//input[@aria-label='Enter a destination or property']"));
		Robot r=new Robot();
		destination.sendKeys("Orlando (FL)");
		a.contextClick(destination).perform();
		
		
		
		
	}

}

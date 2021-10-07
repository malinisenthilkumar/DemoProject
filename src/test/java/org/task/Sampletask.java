package org.task;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Sampletask {

	@Test
	  public void demoproject() {
		System.setProperty("webdriver.chrome.driver","E:\\Photon Workspace\\SampleTestNg\\Driver\\chromedriver94.exe");
		
		WebDriver driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("https://www.flipkart.com/");
		
		WebElement alert=driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']"));
		alert.click();
		
		WebElement search=driver.findElement(By.xpath("//input[@type='text']"));
		search.sendKeys("iphone");
		
		WebElement btnclick=driver.findElement(By.xpath("//button[@type='submit']"));
		btnclick.click();
		
	   WebElement name=driver.findElement(By.xpath("//div[text()='APPLE iPhone 12 Mini (White, 64 GB)']"));
	   System.out.println("iphone price:" +name);
	
	//List<WebElement>iphone=driver.findElements(By.xpath("//div[@class='_4rR01T']"));
	//for(WebElement e:iphone) {
//	String priceTxt=e.getText().substring(1).replace(",","");
	//System.out.println(e.getText());				
	//int i=Integer.parseInt(priceTxt);
		//System.out.println(i);

}
}

	



package org.task;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import org.apache.poi.poifs.filesystem.Entry;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;



public class Amazon {
	

	@Test

	public void Amazon(){
	System.setProperty("webdriver.chrome.driver", "E:\\Photon Workspace\\SampleTestNg\\Driver\\chromedriver94.exe");
	
	WebDriver driver=new ChromeDriver();
	
	driver.get("https://www.amazon.in/");
	
	WebElement search=driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
	search.sendKeys("fridge");
	
	WebElement Loginbtn=driver.findElement(By.xpath("//input[@id='nav-search-submit-button']"));
	Loginbtn.click();
	
    List<WebElement>product=driver.findElements(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']"));
	for(WebElement e:product) {
		System.out.println(e.getText());
	}
	List<WebElement>price=driver.findElements(By.xpath("//span[@class='a-price-whole']"));
	for(WebElement a:price) {
		System.out.println(a.getText().replace(",",""));

	
	
	
	}
}
	}

	

	


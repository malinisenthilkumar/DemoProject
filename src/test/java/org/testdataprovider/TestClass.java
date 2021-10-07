package org.testdataprovider;

import java.util.Date;

import org.basic.Baseclass;
import org.excel.ExcelTestNG;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class TestClass extends Baseclass{
//	public static void main(String[]args) {
//		browserLaunch("Chrome");
//		driver.get("http://en-gb.facebook.com/");
//		WebElement txtusername=findElement("id","email");
//		fillTextBox(txtusername,"malini");
//		
//		driver.navigate().refresh();
//		fillTextBox(txtusername,"senthil");
//		
//		WebElement txtpassword=findElement("id","pass");
//		fillTextBox(txtpassword,"765434");
//		
//		WebElement btnLogin=findElement("name","login");
//		btnLogin.click();
		
		
		
		
@BeforeClass
private void beforeclass() {
	browserLaunch("Chrome");
}
@AfterClass
private void afterclass() {
	quitbrowser();
}
@BeforeMethod
private void beforeMethod() {
	Date d=new Date();
	System.out.println("Start Time:"+d);
}
@AfterMethod
private void afterMethod() {
	Date d=new Date();
	System.out.println("End Time:"+d);
}
@Test(dataProvider = "login",dataProviderClass=DemoDataprovider.class)
public void Login(String user, String pwd) {
	browserLaunch("Chrome");
	LaunchTheUrl("http://en-gb.facebook.com/");
	Pom p = new Pom();
	fillTextBox(p.getTxtUserName(), user);
	fillTextBox(p.getTxtPassword(), pwd);
	}
	}



 package org.basic;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.jsoup.helper.DataUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Baseclass {

public static WebDriver driver;

public static void browserLaunch(String browsername) {

	if (browsername.equals("Chrome")) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	} else if (browsername.equals("Firefox")) {
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
	} else {
		WebDriverManager.iedriver().setup();
		driver = new InternetExplorerDriver();
		}
	}

public void	 impliciwait(long sec) {
	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
}
public static void LaunchTheUrl(String Url) {
	driver.get(Url);
	driver.manage().window().maximize();
}

public static void fillTextBox(WebElement e, String value) {
	e.sendKeys(value);
}
public static String getTheTitle() {
	String title = driver.getTitle();
	System.out.println(title);
	return title;
}
//Url lanuch
public static String getTheUrl() {
	String Url = driver.getCurrentUrl();
	System.out.println(Url);
	return Url;
}
//button click
public static void clickTheButtton(WebElement a) {
	a.click();
}
//quite browser
public static void quitbrowser() {
	driver.quit();
}
//JavaScript
public static void jssendKeys(WebElement e,String input) {
	JavascriptExecutor js=(JavascriptExecutor)driver;
	js.executeScript("arguments[0].SetAttribute('value,'input')",e);
}
//ScreenShot
public static void Screenshot(String image) throws IOException{
	TakesScreenshot tk=(TakesScreenshot)driver;
	File src=tk.getScreenshotAs(OutputType.FILE);
	File des=new File("C:\\Users\\Hp\\eclipse-workspace\\MavenProject\\ScreenShot\\"+image+".png");
	FileUtils.copyFile(src,des);
}
//WindowsHandling
public static void Windowhandling() {
	String parentId=driver.getWindowHandle();
	Set<String>allId=driver.getWindowHandles();
	for(String eachId:allId) {
		if(!parentId.equals(eachId)) {
			driver.switchTo().window(eachId);
		}}
	}
//Find Element	
	public static WebElement findElement(String locatorType,String value) {
		WebElement element=null;
		if(locatorType.equals("id")) {
			element=driver.findElement(By.id(value));
		}
		else if(locatorType.equals("name")){
			element=driver.findElement(By.name(value));
		}
		else if(locatorType.equals("xpath")){
			element=driver.findElement(By.xpath(value));
		}
		return element;
	}
//Actions class	
	public static void moveToElement(WebElement e) {
		Actions a=new Actions(driver);
		a.moveToElement(e).perform();
	}
	public static void dragAndDrop(WebElement src,WebElement des) {
		Actions a=new Actions(driver);
		a.dragAndDrop(src, des).perform();
	}
//Select class	
	public static void SelectByIndex(WebElement element,int index,String method,String txt) {
		Select s=new Select(element);
		s.selectByIndex(index);
		if(method=="Text") {
			s.selectByVisibleText(txt);
		}
		else if(method=="value") {
			s.selectByValue(txt);
		}
		else {
			s.selectByIndex(index);
		}
		
	}
	
//excel reading
	public static void excelread(String path,String sheetname,int rowNum,int cellNum,WebElement w)throws Throwable {
		
	File f=new File(path);
	FileInputStream st = new FileInputStream(f);
    Workbook wb = new XSSFWorkbook(st);
    Sheet s = wb.getSheet(sheetname);
    Row row = s.getRow(rowNum);
    Cell cell = row.getCell(cellNum);
	int Type = cell.getCellType();
	if(Type==1) {
		String value=cell.getStringCellValue();
		w.sendKeys(value);
	}
	else if(DateUtil.isCellDateFormatted(cell)) {
		Date date=cell.getDateCellValue();
		SimpleDateFormat S=new SimpleDateFormat("dd-mm-yy");
		String value=S.format(date);
		w.sendKeys(value);
	}else {
		double d=cell.getNumericCellValue();
		long l=(long)d;
		String value=String.valueOf(1);
		w.sendKeys(value);
	}
			}
	}
	

	
	
	

package org.excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ExcelTestNG {
	@Test(dataProvider="login")
	public void test1(String user,String pass) {
		System.out.println(user);
		System.out.println(pass);
	}
	@DataProvider(name = "login")
	public Object[][] getData() throws Throwable {
		return data();
	}

	public Object[][] data() throws Throwable {
		File f=new File("E:\\Photon Workspace\\SampleTestNg\\src\\test\\resources\\SampleinTestNGExcel.xlsx");
		FileInputStream fis=new FileInputStream(f);
		Workbook bk=new XSSFWorkbook(fis);
		
		Sheet sheet=bk.getSheet("Task");
		int rc=sheet.getPhysicalNumberOfRows();
		
		Row r=sheet.getRow(0);	
		int cc=r.getPhysicalNumberOfCells();
		
		Object data[][]=new Object[rc][cc];
		
		String value=null;
		
		for(int i=0;i<rc;i++) {	
			Row row=sheet.getRow(i);
		
		for(int j=0;j<cc;j++) {
			Cell cell=row.getCell(j);
			int type=cell.getCellType();
		
			if(type==1) {
				 value=cell.getStringCellValue();
			}
			else {
				double d=cell.getNumericCellValue();
				long l=(long)d;
				value=String.valueOf(1);
			}
			data[i][j]=value;
						
			}
	}
	return data;
}
}

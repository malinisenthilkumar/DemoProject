package org.excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Mtest {
	public Object details() throws Throwable {
		File f=new File("E:\\Photon Workspace\\SampleTestNg\\src\\test\\resources\\SampleinTestNGExcel.xlsx");
		
		FileInputStream fis=new FileInputStream(f);
		
		Workbook wb=new XSSFWorkbook(fis);
		
		Sheet sheet=wb.getSheet("Task");
		int rc=sheet.getPhysicalNumberOfRows();

		
		Row r=sheet.getRow(0);
	    int cc=r.getPhysicalNumberOfCells();
	  
        Object details[][]=new Object[rc][cc];
		
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
	    		Long l=(long)d;
	    		value=String.valueOf(1);
	    		
	    		
	    	}
			details[i][j]=value;

	    		
	    	}

			}
	return details;

	}}

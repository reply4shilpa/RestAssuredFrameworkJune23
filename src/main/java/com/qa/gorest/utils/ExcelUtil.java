package com.qa.gorest.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class ExcelUtil {
	private static final String TEST_DATA_SHEET_PATH="";
	
	public static void getTestData(String sheetName) {
		
		Object data[][]=null;
		
		try {
			FileInputStream ip=new FileInputStream(TEST_DATA_SHEET_PATH);
		book=	WorkbookFactory.create(ip);
		sheet= book.getSheet(sheetName);
		data= new Object[sheet.getLastRowNumber()][sheet.getRow(0).getLastCellNum()];
		for(int i=0; i<sheet.getLastRowNumber();i++) {
			
			for(int j=0; j<sheet.getRow(0).getLastCellNum();j++) {
				
				data[i][j]=sheet.getRow(i+1).getCell(j).toString();
				
			}
			
		}
		
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}return data;
		
	}
	

}

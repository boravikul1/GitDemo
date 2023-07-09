package com.seleniumautomation.mavenproject;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelSheetTest {
	
	public static void readData() throws IOException
	{
		FileInputStream fis = new FileInputStream("C://Users//borav//eclipse-workspace//mavenproject//TestData//LoginTestData.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		int sheets = wb.getNumberOfSheets();
		System.out.println(sheets);
		ArrayList<String> username = new ArrayList<String>();
		ArrayList<String> password = new ArrayList<String>();
		for(int i=0;i<sheets;i++)
		{
			String sheetName = wb.getSheetAt(i).getSheetName();
			if (sheetName.equalsIgnoreCase("Sheet1")) {
			
				System.out.println(sheetName);
				XSSFSheet sheet = wb.getSheetAt(i);
				Iterator<Row> rowIterator = sheet.iterator();
				while(rowIterator.hasNext())
				{
				Row row = rowIterator.next();
				Iterator<Cell> cell = row.iterator();
				while(cell.hasNext())
				{	
					Cell value = cell.next();
					System.out.println(value.getStringCellValue());
					username.add(value.getStringCellValue());
				}
				System.out.println();
				
			}
				System.out.println(username);
			}
		}
		
	}
	
	public static void main(String[] args) throws IOException
	{
		readData();
	}

}

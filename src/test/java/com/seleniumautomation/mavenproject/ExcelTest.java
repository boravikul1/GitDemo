package com.seleniumautomation.mavenproject;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.google.common.collect.Table.Cell;

public class ExcelTest {

	public static void main(String[] args) throws IOException
	{
		FileInputStream fis = new FileInputStream("C://Users//borav//eclipse-workspace//mavenproject//TestData//TestData.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		
		int sheets = workbook.getNumberOfSheets();
		System.out.println(sheets);
		
		for(int i=0;i<sheets;i++)
		{
			String sheetName = workbook.getSheetAt(i).getSheetName();
			System.out.println(sheetName);
			if(sheetName.equalsIgnoreCase("Sheet1"))
			{
				XSSFSheet sheet=workbook.getSheetAt(i);
				Iterator<Row> row = sheet.iterator();
				Row firstRow = row.next();
				Iterator<org.apache.poi.ss.usermodel.Cell> ce = firstRow.cellIterator();//row is the collection of cells
				int k=0;
				int column;
				while(ce.hasNext())
				{
					org.apache.poi.ss.usermodel.Cell value = ce.next();
					if(value.getStringCellValue().equalsIgnoreCase("Data2"))
					{
						column = k;
						System.out.println(column);
					}
					k++;
				}
				
			}
			
		}
	}
}
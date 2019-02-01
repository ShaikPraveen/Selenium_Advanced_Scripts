package com.apachepoi.excel.operations;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Reading_Data 
{
	public static void main(String[] args) throws IOException 
	{
		FileInputStream fis=new FileInputStream("C:\\Users\\Manohar\\Desktop\\Sample.xlsx");
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		XSSFSheet ws=wb.getSheet("STU_DATA");
		int rc=ws.getLastRowNum();
		XSSFRow row;
		XSSFCell cell1,cell2,cell3,cell4;
		String sf,sl,sg,sadd;
		
		for (int i = 0; i<=rc; i++)
		{
			row=ws.getRow(i);
			cell1=row.getCell(0);
			cell2=row.getCell(1);
			cell3=row.getCell(2);
			cell4=row.getCell(3);
			
			
			sf=cell1.getStringCellValue();
			sl=cell2.getStringCellValue();
			sg=cell3.getStringCellValue();
			sadd=cell4.getStringCellValue();
			
			
			System.out.println(sf +" - "+sl +" -"+sg+" - "+sadd);
			wb.close();
			fis.close();	
		}	
	}
}

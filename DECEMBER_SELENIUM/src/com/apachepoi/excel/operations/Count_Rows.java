package com.apachepoi.excel.operations;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Count_Rows 
{
	public static void main(String[] args) throws IOException 
	{
		FileInputStream fis=new FileInputStream("C:\\Users\\Manohar\\Desktop\\Sample.xlsx");
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		XSSFSheet ws=wb.getSheet("EMP_DATA");
		int rc=ws.getLastRowNum();
		System.out.println("TOTAL NUMBER OF ROWS ARE "+rc);
		wb.close();
		fis.close();
	}
}

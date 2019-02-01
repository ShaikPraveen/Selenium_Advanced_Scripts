package com.handling.ExcelOperations;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Reading_Data
{
	//Video Link :: https://www.youtube.com/watch?v=8DaPdlhDpBc&list=PLUDwpEzHYYLs6G9WOfFxiH5zMfgNxgmSV&index=10
	
	public static void main(String[] args) throws IOException
	{
	    FileInputStream fis =new FileInputStream("E:\\Praveen_Automation\\TestData.xlsx");
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		XSSFSheet ws=wb.getSheet("EMP_DETAILS"); //Providing Sheet Name
		//XSSFSheet ws=wb.getSheetAt(1);//Providing sheet index, index starts from zero
		
		//1. COUNT NUMBER OF ROWS
		int rc=ws.getLastRowNum();
		System.out.println("NUMBER OF ROWS PRESENT IN EMP DETAILS SHEET IS  "+rc);
		
		//2. COUNT NUMBER OF COLUMNS
		int cc=ws.getRow(0).getLastCellNum();
		System.out.println("NUMBER OF COLUMNS PRESENT IN EMP DETAILS SHEET IS "+cc);
		
		//3. READ DATA FROM EXCEL SHEET
		for (int i = 0; i < rc; i++) 
		{
			XSSFRow currentrow = ws.getRow(i);//Read all rows
			
			for (int j = 0; j < cc; j++)
			{
				String value=currentrow.getCell(j).toString();//Read all column values
				System.out.print("  "+value);	
			}
			System.out.println();
		}
		
		//Note:- getStringCellValue()  => Will return String  values in Excel Sheet
		//       getNumericCellValue() => Will return Numeric values in Excel Sheet
		//       getBooleanCellValue() => Will return Boolean values in Excel Sheet
		
		
  //What is the use of toString() Method?
  //Ans :-  I want read all the Data which ever data it is, i don't care any Data type
  //        we will use  "toString()" generic method. Which will be read all kinds of data like string or Numeric or Boolean
	
		
	 
	}

		
	}

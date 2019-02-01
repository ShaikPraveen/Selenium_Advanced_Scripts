package com.apachepoi.excel.operations;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Writing_Data 
{
	public static void main(String[] args) throws IOException
	{
		FileInputStream fis=new FileInputStream("C:\\Users\\Manohar\\Desktop\\Sample.xlsx");
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		XSSFSheet ws=wb.getSheet("STU_DATA");
		XSSFRow row=ws.getRow(1);
		XSSFCell cell=row.createCell(4);
		cell.setCellValue("PASS");
		
		row=ws.getRow(2);
		XSSFCell cell1=row.createCell(4);
		cell1.setCellValue("FAIL");
		
		
		row=ws.getRow(3);
		XSSFCell cel2=row.createCell(4);
		cel2.setCellValue("PASS");
		
		row=ws.getRow(4);
		XSSFCell cel3=row.createCell(4);
		cel3.setCellValue("FAIL");
		
		row=ws.getRow(5);
		XSSFCell cel4=row.createCell(4);
		cel4.setCellValue("PASS");
		
		FileOutputStream fo=new FileOutputStream("C:\\Users\\Manohar\\Desktop\\Sample.xlsx");
		wb.write(fo);
		wb.close();
		fis.close();
		fo.close();
	}

}

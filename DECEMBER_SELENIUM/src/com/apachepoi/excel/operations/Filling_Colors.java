package com.apachepoi.excel.operations;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Filling_Colors 
{
	public static void main(String[] args) throws IOException {
		
		FileInputStream fis=new FileInputStream("C:\\Users\\Manohar\\Desktop\\Sample.xlsx");
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		XSSFSheet ws=wb.getSheet("STU_DATA");
		
		XSSFRow row1,row2,row3,row4,row5;
		XSSFCell cell1,cell2,cell3,cell4,cell5;
		
		 row1=ws.getRow(1);
		 row2=ws.getRow(2);
		 row3=ws.getRow(3);
		 row4=ws.getRow(4);
		 row5=ws.getRow(5);
	
		 cell1=row1.getCell(5);
		 cell2=row2.getCell(5);
		 cell3=row3.getCell(5);
		 cell4=row4.getCell(5);
		 cell5=row5.getCell(5);
		 
		 CellStyle style=wb.createCellStyle();
		 style.setFillForegroundColor(IndexedColors.GREEN.getIndex());
		 //style.setFillPattern(CellStyle.SOLID_FOREGROUND);
		 cell1.setCellStyle(style);
		 
		 
		 FileOutputStream fo=new FileOutputStream("C:\\Users\\Manohar\\Desktop\\Sample.xlsx");
		 wb.write(fo);
		 wb.close();
		 fis.close();
		 fo.close();
	}

}

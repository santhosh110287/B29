//02-03-2022
//how to read data from excel file?
//In order to handle excel file, we need two dependency poi and poi-ooxml
//poi-poor obfuscation implementation(obfuscation means abstraction, its fancy name thatsit given by company apache. It is famous for Tomcat server 
//poi-ooxml---
//Apache POI Common » 5.2.0( We can get this in mvnrepositories
//Apache POI API Based On OPC and OOXML Schemas » 5.2.0
//open the excel file
//goto sheet
//goto cell and get the value
//close excel file
package day34;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Demo4 {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		//Open the Excel file
		//			FileInputStream fis=new FileInputStream("./data/book1.xlsx");
		//			WorkbookFactory.create(fis);
		//we can optimize above two line into one line
		Workbook wb = WorkbookFactory.create(new FileInputStream("./Data/Book1.xlsx"));//path and name is also not case sensitive
		//goto sheet1 and goto 1st row 1st col and get the value using tostring() method alsos
//		String v = wb.getSheet("sheet1").getRow(0).getCell(0).toString();
//		System.out.println(v);
		
//		String A1 = wb.getSheet("sheet2").getRow(0).getCell(0).getStringCellValue();
//		System.out.println(A1);
//		
//		double A2 = wb.getSheet("sheet2").getRow(0).getCell(1).getNumericCellValue();	//since it is number, so return type should be double			
//		System.out.println(A2);
		
		
		//to find the data type of excel cell 
		CellType type = wb.getSheet("sheet2").getRow(0).getCell(1).getCellType();
		System.out.println(type);
		
//		//Irrespective of datatype, tostring() method will work..becz cell may contain value or string or boolean..becz of this we can use tostring() 
		String A1a = wb.getSheet("sheet2").getRow(0).getCell(0).toString();
		System.out.println(A1a);
		
		//to find the data type of excel cell 
		CellType type1 = wb.getSheet("sheet2").getRow(0).getCell(0).getCellType();
		System.out.println(type1);
		
		String A2a = wb.getSheet("sheet2").getRow(0).getCell(1).toString();
		System.out.println(A2a);
		
		String A3a = wb.getSheet("sheet2").getRow(0).getCell(2).toString();
		System.out.println(A3a);
		
		//close excel file
		wb.close();
	}
}

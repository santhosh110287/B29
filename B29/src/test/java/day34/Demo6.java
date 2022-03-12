//02-03-2022
//Write data into excel sheet
package day34;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Demo6 {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		Workbook wb = WorkbookFactory.create(new FileInputStream("./Data/Book1.xlsx"));//path and name is also not case sensitive
		wb.getSheet("sheet1").getRow(0).getCell(0).setCellValue("Santhosh");//setCellValue is an example for method overloading
		wb.getSheet("sheet1").getRow(0).createCell(3).setCellValue("nivi");
		wb.getSheet("sheet1").createRow(3).createCell(3).setCellValue("nivi");
		//If we want to retrieve any empty cell then we will get Nullpointerexception
		//so to create a cell, we can use createcell() method
		wb.write(new FileOutputStream("./data/book2.xlsx"));
		//If we given same path then it becomes save
		//If we given different path then it becomes saveAs
	
		wb.close();
	}
}

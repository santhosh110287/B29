//day 35
//To read each coloumn value and row value in the excel sheet
//03-03-2022

package day34;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Demo9 {
	public static void main(String[] args) throws FileNotFoundException, IOException {
		//To map coloum header with rowheader we can use LinkedHashMap,key and value pair
		LinkedHashMap<String, String> map=new LinkedHashMap<String, String>();
		
		//If There is an excel file, there is a data,
		//Create an excel file
		Workbook wb=WorkbookFactory.create(new FileInputStream("./Data/Book3.xlsx"));
	    int	cc=wb.getSheet("sheet3").getRow(0).getLastCellNum();//cc is coloumn count
	    System.out.println(cc);
		
		//To print all, use for loop
		for (int i = 0; i < cc; i++) {
			String k = wb.getSheet("sheet3").getRow(0).getCell(i).toString();
			String v = wb.getSheet("sheet3").getRow(2).getCell(i).toString();
			map.put(k, v);
		}
		wb.close();
		System.out.println(map);
		System.out.println(map.get("Username"));//It should be case sensitive

	}
}

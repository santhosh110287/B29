//day 35
//03-03-2022
//To read each coloumn value and row value in the excel sheet
//We have included this whole program as a method in Excel.java file


package day34;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Demo10 {
	public static String getData(String path,String sheet,int r,String colName) 
	{
		//To map coloum header with rowheader we can use LinkedHashMap,key and value pair
		LinkedHashMap<String, String> map=new LinkedHashMap<String, String>();

		try {
			//If There is an excel file, there is a data,
			//Create an excel file
			Workbook wb=WorkbookFactory.create(new FileInputStream(path));
			int	cc=wb.getSheet(sheet).getRow(0).getLastCellNum();//cc is coloumn count
			System.out.println(cc);

			//To print all, use for loop
			for (int i = 0; i < cc; i++) {
				String k = wb.getSheet(sheet).getRow(0).getCell(i).toString();
				String v = wb.getSheet(sheet).getRow(r).getCell(i).toString();
				map.put(k, v);
			}
			wb.close();
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		return map.get(colName);

	}
}

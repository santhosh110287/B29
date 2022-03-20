//03-03-2022


//This code is also common for any project, hence it is generic method.
//we can use this for any excel file(any row and any coloumn), 
//If we write any method which is not specific to project then we will call as generic method
package generic;

import java.io.FileInputStream;
import java.util.LinkedHashMap;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excel {
	//when do we go for method overloading:
	//If we want to perform similar task(job) then we can go for method overloading
	//here purpose is to get the data.
	public static String getData(String path,String sheet,int row, int colIndex) {
		String value="";
		try {
			Workbook wb=WorkbookFactory.create(new FileInputStream(path));
			value=wb.getSheet(sheet).getRow(row).getCell(colIndex).toString();
			wb.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return value;
	}

	public static String getData(String path,String sheet,int row,String colName) 
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
			//If the cell is blank in excel it will go to catch block.
			for (int i = 0; i < cc; i++) {
				String k = wb.getSheet(sheet).getRow(0).getCell(i).toString();
				String v="";
				try {
					v = wb.getSheet(sheet).getRow(row).getCell(i).toString();
				}
				catch (Exception e) 
				{
					
				}
				map.put(k, v);
			}
			wb.close();
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		return map.get(colName);
	}

//09-03-2022
	public static int getRowCount(String path,String sheet) {
		int rc=0;
		try {
			Workbook wb=WorkbookFactory.create(new FileInputStream(path));
			rc=wb.getSheet(sheet).getLastRowNum();
			wb.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return rc;
	}

}


//day 35
//03-03-2022

package day34;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Properties;

public class Demo8 {
	public static void main(String[] args) throws FileNotFoundException, IOException {
		LinkedHashMap<String, String> map=new LinkedHashMap<String, String>();
		map.put("City", "Delhi");
		map.put("Name", "Bhanu");
		String v = map.get("Name");
		
		System.out.println(v);
	}
}

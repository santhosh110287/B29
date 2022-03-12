//day 35
//03-03-2022

package day34;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Demo7 {
	public static void main(String[] args) throws FileNotFoundException, IOException {
		Properties p =new Properties();
		//To read a content from Properties file..which is preseent in config.properties
		p.load(new FileInputStream("./config.properties"));
		String v = p.getProperty("URL");
		System.out.println(v);
	}
}

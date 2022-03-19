//03-03-2022
//This package will do
//Before the method: Open the browser, enter URL, and doing some other settings, 
//After method will do: browser will close
//We can use this whole code to any type of program hence it is called as generic method.. It is common for anything
//If we write any method which is not specific to project then we will call as generic method
/*
 * Create Generic package
 * Write BaseTest.java
 * Create script package
 * Write Test1.java
 * run Test1.java
 * write config.properties under the poject
 * Update BaseTest.java
 * Autowidening: Converting small datatype to higher data type.
 */
package generic;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest implements IAutomation{

	public WebDriverWait wait;
	public WebDriver driver;//declared, this is global driver
	//public static final String config_path="./config.properties";

	static {
		WebDriverManager.chromedriver().setup();
	}

	@BeforeMethod
	public void openApp() {

		String url = getValue("URL");//We can call the getApp() method 
		//		String ito = getValue("ITO");
		//		int i=Long.parseLong(ito);
		//we can optimize above two line into
		long ito = Long.parseLong(getValue("ITO"));
		long eto = Long.parseLong(getValue("ETO"));


		//WebDriver driver=new ChromeDriver();//this driver is only applicable to openApp(). In orderto access this in close App() also we can use this as public
		driver=new ChromeDriver();
		//driver.get("http://www.google.com");//this driver is local 
		//If i want to open some other website, just we can modify URL in the file.
		driver.get(url);//this driver is local 
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(ito));
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(eto));
	}

	@AfterMethod
	public void closeApp() {

		driver.close();
	}
	
	public static String getValue(String key) {

		String value="";
		Properties p =new Properties();
		try {
			//To read a content from Properties file..which is present in config.properties
			p.load(new FileInputStream(CONFIG_PATH));
			value = p.getProperty(key);
		}
		catch(Exception e) {

		}
		return value;
	}
}

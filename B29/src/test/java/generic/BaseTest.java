//03-03-2022
//07-03-2022
//09-03-2022
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
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest implements IAutomation{

	public WebDriverWait wait;
	public WebDriver driver;//declared, this is global driver
	//public static final String config_path="./config.properties";
	//public String remoteAddr="http://localhost:4444";

	static {
		WebDriverManager.chromedriver().setup();
	}
	@Parameters({"grid","remoteAddr","browserName"})//Run parallely
	@BeforeMethod
	public void openApp(@Optional("") String grid,@Optional("") String remoteAddr,@Optional("") String browserName) throws MalformedURLException {

		String appURL = getValue("URL");//We can call the getApp() method 
		//		String ito = getValue("ITO");
		//		int i=Long.parseLong(ito);
		//we can optimize above two line into
		long ito = Long.parseLong(getValue("ITO"));
		long eto = Long.parseLong(getValue("ETO"));
		
		if(grid.equals(""))
		{
			//Run the script using Grid or in local system browser
			grid=getValue("GRID");
		}
		
		if(remoteAddr.equals(""))
		{
			remoteAddr=getValue("REMOTE");
		}
		
		if(browserName.equals(""))
		{
			browserName=getValue("BROWSER");
		}
		
		//browserName=getValue("BROWSER");

		if(grid.equalsIgnoreCase("YES"))
		{
			Reporter.log("Opening "+browserName+" in remote system",true);
			URL gridURL=new URL(remoteAddr);

			if(browserName.equalsIgnoreCase("chrome"))
			{
				Reporter.log("Opening Chrome in Remote system",true);
				driver=new RemoteWebDriver(gridURL,new ChromeOptions());
			}
			else
			{
				Reporter.log("Opening Firefox in Remote system",true);
				driver=new RemoteWebDriver(gridURL,new FirefoxOptions());
			}
		}
		else
		{
			if(browserName.equalsIgnoreCase("chrome"))
			{
				Reporter.log("Opening Chrome in local system",true);
				WebDriverManager.chromedriver().setup();
				driver=new ChromeDriver();
			}
			else
			{
				Reporter.log("Opening Firefox in local system",true);
				WebDriverManager.firefoxdriver().setup();
				driver=new FirefoxDriver();
			}
		}

		//WebDriver driver=new ChromeDriver();//this driver is only applicable to openApp(). In orderto access this in close App() also we can use this as public
		//driver=new ChromeDriver();
		//driver.get("http://www.google.com");//this driver is local 
		//If i want to open some other website, just we can modify URL in the file.
		driver.get(appURL);//this driver is local 
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

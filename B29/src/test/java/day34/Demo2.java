//02-03-2022
package day34;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Demo2 {
//	static
//	{
//		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
//
//	}
	
	@Test 
	public void testA() {
		//Previously we have used system.setProperty for set a path to driver, but in this manually we should download and keep it.
		//instead of that, we can use below line
		//setup() means: download the .exe file and set the path..
		//no need to download exe file and set a path
		WebDriverManager.chromedriver().setup();//webdrivermanager in pom.xml this will automatically download and update .exe file
		WebDriverManager.chromedriver().getBrowserPath();
		//WebDriverManager.chromedriver().browserVersion("97").setup();//This line tells specific version of the browser
		WebDriver driver=new ChromeDriver();
		driver.get("http://www.google.com");
		driver.close();
	}
}

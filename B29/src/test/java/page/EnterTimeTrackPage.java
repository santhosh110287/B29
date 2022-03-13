//07-03-2022
package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

public class EnterTimeTrackPage {
	public WebDriver driver;

	public EnterTimeTrackPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public boolean verifyTitle(WebDriverWait wait,String expected) {
		try {
			wait.until(ExpectedConditions.titleContains(expected));
			Reporter.log("Title is matching",true);
			return true;
		}
		catch(Exception e)
		{
			Reporter.log("Title is not matching",true);
			return false;
		}
	}

	public boolean verifyUrl(WebDriverWait wait,String expected) {
		try {
			wait.until(ExpectedConditions.urlContains(expected));
			Reporter.log("url is matching",true);
			return true;
		}
		catch(Exception e)
		{
			Reporter.log("url is not matching",true);
			return false;
		}	

	}
}
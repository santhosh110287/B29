//07-03-2022
package generic;
import org.openqa.selenium.WebElement;
//How to decide method is static or non static
//By default method should be static, static means keep only one copy,
//If any method uses non static variable of a class then such method should be declared as non-static
//If any method doesnt uses variable of a class then such method should be declared as static
//usage of static becz It avoid multiple copies
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

public class WebGeneric {
	
	public static boolean verifyTitle(WebDriverWait wait,String expected) {
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

	public static boolean verifyUrl(WebDriverWait wait,String expected) {
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
	public static boolean verifyElementDisplayed(WebDriverWait wait,WebElement element) {
		try {
			wait.until(ExpectedConditions.visibilityOf(element));
			Reporter.log("element is displayed",true);
			return true;
		}
		catch(Exception e)
		{
			Reporter.log("element is displayed",true);
			return false;
		}

	}
}
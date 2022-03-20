//03-03-2022
//04-03-2022
package page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import generic.WebGeneric;

public class LoginPage {
	//declaration
	@FindBy(id="username")
	private WebElement unTB;
	
	@FindBy(name="pwd")
	private WebElement pwTB;	
	
	@FindBy(xpath="//div[.='Login ']")
	private WebElement loginBTN;
	
	//09-03-2022
	@FindBy(xpath="//span[contains(.,'invalid')]")
	private WebElement errMsg;
	//09-03-2022
	
	
	//initialization
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	//Utilization
	public void setUserName(String un) {
		unTB.sendKeys(un);
	}
	
	public void setPassword(String pw) {
		pwTB.sendKeys(pw);
	}
	
	public void clickLoginButtion() {
		loginBTN.click();
	}

	public boolean verifyErrMsgIsDisplayed(WebDriverWait wait) {
		return WebGeneric.verifyElementDisplayed(wait, errMsg);
	}
}

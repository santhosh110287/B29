//09-03-2022
//DDT(Data driven testing): Using Excel or using data provider
//Testing the application with multiple set
//Created Testcase-2 
package script;

import java.util.function.Supplier;
import org.testng.Assert;
import org.testng.annotations.Test;
import generic.BaseTest;
import generic.Excel;
import page.LoginPage;

public class InvalidLogin extends BaseTest {
	@Test(priority=2)
	public void testInvalidLogin() throws InterruptedException {
		int rc=Excel.getRowCount(XL_PATH, "InvalidLogin");
		for (int i = 1; i <=rc; i++) {
			//		get data from excel file
			String un=Excel.getData(XL_PATH, "InvalidLogin", i, "Username");
			String pw=Excel.getData(XL_PATH, "InvalidLogin", i, "Password");
			String failMsg=Excel.getData(XL_PATH, "InvalidLogin", i, "FailMsg");
						
			//		1.Enter invalid user name(abcd)
			LoginPage l=new LoginPage(driver);
			l.setUserName(un);
			
			//		2.Enterr invalid password(xyz)
			l.setPassword(pw);
			Thread.sleep(1000);
			
			//		3.Click on login button
			l.clickLoginButtion();
			
			//		4.Verify that error msg is displayed
			boolean result = l.verifyErrMsgIsDisplayed(wait);
			Assert.assertTrue(result,failMsg);
			//Assert.assertTrue(result);
			Thread.sleep(1000);
		}

	}
}

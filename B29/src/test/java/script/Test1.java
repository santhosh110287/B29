//03-03-2022


//04-03-2022

//Here we will have multiple test
//How do we run multiple test in a single shot
//using TestNg
//how to create TestNg
//right click on Test1.java, go to TestNG, convert to testng, and click on finish, then we will get one testng.xml
//The job of pom.xml is to download and update the jar file. 
//The job of testng.xml is to run multiple tests.. first update and run it..
//instead of running these two xml file seperately, we can use one plugin
// plugin name is surefire plugin.. advantage of this, when we run pom file, it will update jar file and trigger testng.xml file.

/*
 * Create Generic package
 * Write BaseTest.java
 * Create script package
 * Write Test1.java
 * run Test1.java
 */
package script;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import generic.BaseTest;
import generic.Excel;
import page.EnterTimeTrackPage;
import page.LoginPage;

public class Test1 extends BaseTest{
	@Test
	public void testA() {
		LoginPage l=new LoginPage(driver);
		l.setUserName("admin");
		l.setPassword("manager");
		l.clickLoginButtion();
		//
		//		String v=getValue("URL");
		//		Reporter.log(v,true);
		//		
		//		String title=driver.getTitle();
		//		Reporter.log(title,true);
		//		
		//		String v1=Excel.getData("./Data/Book3.xlsx", "sheet1", 0, 0);
		//		Reporter.log(v1,true);
		//		
		//		String v2=Excel.getData("./Data/Book3.xlsx", "sheet3", 1, "Username");
		//		Reporter.log(v2,true);

		EnterTimeTrackPage e=new EnterTimeTrackPage(driver);
		boolean result = e.verifyHomePageIsDisplayed(wait, "Logout");
		//Assert.assertEquals(result, true);
		Assert.assertTrue(result);//this is same as above
	}

}

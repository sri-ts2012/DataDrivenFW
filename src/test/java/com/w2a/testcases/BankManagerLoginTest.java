package com.w2a.testcases;

import org.openqa.selenium.By;
import org.testng.Assert;
import static org.testng.Assert.assertTrue;
import org.testng.annotations.Test;

import com.w2a.base.TestBase;

public class BankManagerLoginTest extends TestBase {
	
	@Test
	public void loginAsBankManager() throws Exception
	{
		log.info("inside loginbankmanager test");
		driver.findElement(By.cssSelector(or.getProperty("bmlBtn"))).click();
		Thread.sleep(3000);
	/*Assert.assertTrue(isElementPresent(By.cssSelector(or.getProperty("addCustBtn.css"))),"Login not successful");
		
		log.info("login successful");
	*/
	
		try{

			Assert.assertTrue( isElementPresent(By.cssSelector(or.getProperty("addCustBtn.css"))));

			}catch(Throwable t){



			log.error(t.getMessage());
		//	System.out.println(t.getMessage());it is expected true but found false

			Assert.fail("Login not sucessfull");//prints in the report

			}
	
	}

}
/*Define bmlbtn.css in OR Properties

and then in BankManager test just use click("bmlbtn.csss") don't use WebDriver functionality

OR Properties

bmlbtn.css="css path";

BankManager test

click("bmlbtn.css")*/

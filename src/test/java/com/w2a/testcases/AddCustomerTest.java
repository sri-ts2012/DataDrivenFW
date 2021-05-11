package com.w2a.testcases;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.w2a.base.TestBase;

public class AddCustomerTest extends TestBase {
	
	@Test(dataProvider="getData")
	public void addCustomer(String firstName, String lastName,String postCode,String alertText) throws Exception{
		
		driver.findElement(By.cssSelector(or.getProperty("addCustBtn.css"))).click();
		driver.findElement(By.cssSelector(or.getProperty("firstName"))).sendKeys(firstName);
		System.out.println("enetered fname");
		driver.findElement(By.cssSelector(or.getProperty("lastName"))).sendKeys(lastName);
		System.out.println("enetered lastname");
		driver.findElement(By.cssSelector(or.getProperty("postCode"))).sendKeys(postCode);
		System.out.println("enetered postcode");
		driver.findElement(By.xpath(or.getProperty("addCustomerSubmitBtn"))).click();
		Reporter.log("clicked the button");
		
		Alert alert=wait.until(ExpectedConditions.alertIsPresent());
		Assert.assertTrue(alert.getText().contains(alertText));
		alert.accept();
		Thread.sleep(3000);
		
	}
	@DataProvider
	public Object[][] getData(){
		String sheetName="AddCustomerTest";
		int rows=excel.getRowCount(sheetName);
		int cols=excel.getColumnCount(sheetName);
		Object[][] data=new Object[rows-1][cols];//removing the header
			for(int rowNum=2;rowNum<=rows;rowNum++) //since rownnum starts with 1 and col starts with0
				//so from 2 because wodont want the header to store in the data array
			{
				for(int colNum=0;colNum<cols;colNum++)
				{
					//data[0][0] 2 row 0 column data will be stored in this
					data[rowNum-2][colNum]=excel.getCellData(sheetName, colNum, rowNum);
				}
				
			}
				
			return data;
	}

}

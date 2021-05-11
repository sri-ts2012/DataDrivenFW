package com.w2a.listeners;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;
import com.w2a.base.TestBase;
import com.w2a.utilities.TestUtil;

public class CustomListeners extends TestBase implements ITestListener  {

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailure(ITestResult result) {
		//System.setProperty("org.uncommons.reportng.escape-output","false");
		
			String methodName = result.getName().toString().trim();
		
		
		System.setProperty("org.uncommons.reportng.escape-output","false");
		try {
			TestUtil.captureScreenshot(methodName);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Reporter.log("Capturing screenshot");
		//Reporter.log("<a href=\"C:\\Users\\bindu\\Desktop\\Untitled.png\" target=\"_blank\">Screenshot Link</a>");
		Reporter.log("<a href="+TestUtil.screenshotName+" target=\"_blank\">Screenshot Link</a>");
		
		//this will be added in the report
			Reporter.log("<br>");	//line
			Reporter.log("<a href="+TestUtil.screenshotName+" target=\"_blank\"><img height=200 width=200 src="+TestUtil.screenshotName+"</a>");//thumbnail
		System.out.println(result);
		System.out.println("on Test fail:  "+result.getName());
	}
		
	
		


	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}
	
}
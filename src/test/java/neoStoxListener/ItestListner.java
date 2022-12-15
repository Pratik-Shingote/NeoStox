package neoStoxListener;

import java.io.IOException;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import neoStoxBase.BrowserSetup;
import neoStoxUtility.neoStoxUtilityClass;


public class ItestListner extends BrowserSetup implements ITestListener
{
	
	public void onTestSuccess(ITestResult result)
	{
		Reporter.log("Validating "+result.getName()+" , TC is passed...", true);
		try {
			neoStoxUtilityClass.screenshot(driver, result.getName());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Reporter.log("Taking "+result.getName()+" screenshot", true);
	}
	
	public void onTestFailure(ITestResult result) 
	{
		Reporter.log("Validating User ID, TC is failed...", true);
		try {
			neoStoxUtilityClass.screenshot(driver, result.getName());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Reporter.log("Taking "+result.getName()+" screenshot", true);
	}
}

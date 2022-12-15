package neoStoxBase;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import neoStoxUtility.neoStoxUtilityClass;

public class BrowserSetup 
{
	protected static WebDriver driver;
	public void browserLaunch() throws IOException
	{
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(neoStoxUtilityClass.propertyFileRead("url"));
		Reporter.log("launching URL", true);
		//driver.manage().deleteAllCookies();
		neoStoxUtilityClass.implicitWait(driver, 2000);
		
	}
	
}

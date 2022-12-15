package neoStoxUtility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.testng.Reporter;

public class neoStoxUtilityClass 
{
	public static String propertyFileRead(String key) throws IOException
	{
		Properties pro=new Properties();
		FileInputStream myFile=new FileInputStream("D:\\eclipse\\workspace\\neoStox\\neoStoxProperty.properties");
		pro.load(myFile);
		String value = pro.getProperty(key);
		Reporter.log("Reading "+key+" from Property File", true);
		return value;
	}
	
	public static void screenshot(WebDriver driver,String TCID) throws IOException
	{
		File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File dest= new File("D:\\Selenium\\Screenshot\\TC"+TCID+".jpg");
		FileHandler.copy(source, dest);
	}
	
	public static void scroll(WebDriver driver,WebElement element)
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView()", element);
	}
	
	public static void implicitWait(WebDriver driver,int millis)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(millis));
		Reporter.log("Wait for "+millis+" ms", true);
	}
}

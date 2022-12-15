package neoStoxPOMClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class SignPageNeoStox 
{
	//@FindBy(xpath = "(//a[text()='Sign In'])[1]")private WebElement signInButton;
	@FindBy(xpath = "(//input[@type='number'])[1]")private WebElement mobNo;
	@FindBy(xpath = "(//a[text()='Sign In'])[2]")private WebElement signInButton2;
	
	public SignPageNeoStox(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
//	public void signIn(WebDriver driver)
//	{
//		signInButton.click();
//		Reporter.log("clicking on signIn", true);
//		CommonMethods.implicitWait(driver, 1000);
//	}
	
	public void enterMobNo(String no)
	{
		mobNo.sendKeys(no);
	}
	
	public void signBtn2(WebDriver driver)
	{
		signInButton2.click();
		Reporter.log("clicking on signIn", true);
	}
}

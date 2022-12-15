package neoStoxPOMClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class EnterAccessPinNeoStox 
{
	@FindBy(xpath = "//input[@id='txt_accesspin']")private WebElement accessPin;
	@FindBy(xpath = "//a[@id='lnk_submitaccesspin']")private WebElement submitButton;
	
	public EnterAccessPinNeoStox(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void enterAccessPin(String pin)
	{
		accessPin.sendKeys(pin);
		Reporter.log("Sending Access Pin", true);
	}
	
	public void clickOnSubmit(WebDriver driver) throws InterruptedException
	{
		Thread.sleep(1000);
		submitButton.click();
		Reporter.log("clicking submit", true);
	}
	
	
}

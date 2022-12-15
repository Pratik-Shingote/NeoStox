package neoStoxPOMClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class HomePageNeoStox 
{
	@FindBy(xpath = "(//a[text()='Close'])[5]")private WebElement close2;
	@FindBy(xpath = "(//button[@type='button'])[22]")private WebElement close;
	@FindBy(id = "lbl_username")private WebElement userID;
	@FindBy(xpath = "(//span[@class='righttopmenu1'])[2]")private WebElement balance;
	@FindBy(xpath = "//a[@id='lnk_logout']")private WebElement logoutBtn;
	
	public HomePageNeoStox(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
//	public void clickHiddenDivOk()
//	{
//		ok.click();
//	}
	
	public void clickHiddenDivClose() throws InterruptedException
	{
//		WebDriverWait w=new WebDriverWait(driver, Duration.ofMillis(5000));
//		w.until(ExpectedConditions.visibilityOf(close));
		Thread.sleep(1000);
		close.click();
		Thread.sleep(1000);
//		WebDriverWait w2=new WebDriverWait(driver, Duration.ofMillis(5000));
//		w2.until(ExpectedConditions.visibilityOf(close2));
		close2.click();
		
	}
	
	public String validateUserID()
	{
		String actualID = userID.getText();
		Reporter.log("Validating user ID",true);
		return actualID;
	}
	
	public String getAcBalance()
	{
		
		String actualbal = balance.getText();
		Reporter.log("Current Account Balance is : "+actualbal,true);
		return actualbal;
	}
	
	public void clickLogOut(WebDriver driver)
	{
		Actions a=new Actions(driver);
		a.moveToElement(userID).perform();
		logoutBtn.click();
		Reporter.log("logging out...", true);
	}
	
	
}

package neoStoxTestClasses;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import neoStoxBase.BrowserSetup;
import neoStoxPOMClasses.EnterAccessPinNeoStox;
import neoStoxPOMClasses.HomePageNeoStox;
import neoStoxPOMClasses.SignPageNeoStox;
import neoStoxPOMClasses.StartPageNeoStox;
import neoStoxUtility.neoStoxUtilityClass;
@Listeners(neoStoxListener.ItestListner.class)
public class validateBalAndAccID extends BrowserSetup
{
	StartPageNeoStox startPage;
	EnterAccessPinNeoStox pin;
	SignPageNeoStox signIn;
	HomePageNeoStox home;
	
	  @BeforeClass
	  public void launchBrowser() throws IOException 
	  {
		 browserLaunch();
		 startPage=new StartPageNeoStox(driver);
		 signIn=new SignPageNeoStox(driver);
		 pin=new EnterAccessPinNeoStox(driver);
		 home=new HomePageNeoStox(driver);
	  }
	
	  @BeforeMethod
	  public void loginToNeoStox() throws IOException, InterruptedException 
	  {
		  startPage.clickONSignInButton(driver);
		  neoStoxUtilityClass.implicitWait(driver,1000);
		  signIn.enterMobNo(neoStoxUtilityClass.propertyFileRead("mobNum"));
		  signIn.signBtn2(driver);
		  pin.enterAccessPin(neoStoxUtilityClass.propertyFileRead("password"));
		  pin.clickOnSubmit(driver);
		  neoStoxUtilityClass.implicitWait(driver,5000);
	  }
	
	  @Test(priority = -1)
	  public void validatesAcID() throws IOException, InterruptedException 
	  {		  
		  Thread.sleep(2000);
		  home.clickHiddenDivClose();
		  Assert.assertEquals(home.validateUserID(), neoStoxUtilityClass.propertyFileRead("expAccName"),"Act & Exp not matching, TC is Failed");
		  neoStoxUtilityClass.implicitWait(driver, 1000);
	  }
	  
	  @Test
	  public void validatesAcBalance()
	  {
		  neoStoxUtilityClass.implicitWait(driver, 1000);
		  Assert.assertNotNull(home.getAcBalance(),"TC failed Unable to fetchbaccount Balance");
	  }
  
	  @AfterMethod
	  public void logoutFromNeostox() 
	  {
		  home.clickLogOut(driver);
		  neoStoxUtilityClass.implicitWait(driver, 1000);
	  }

	  @AfterClass
	  public void closeBrowser() 
	  {
		  driver.close();
	  }

}

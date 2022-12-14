package neostox_TestNG;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import neostox_Base_Class.Base;
import neostox_POM_Classes.NeoStoxHomePage;
import neostox_POM_Classes.NeoStoxPasswordPage;
import neostox_POM_Classes.NeostoxLoginPage;
import utility.Utility;

public class ValidateNeoStoxUserName extends Base 
{
 NeostoxLoginPage login;
 NeoStoxPasswordPage pass;
 NeoStoxHomePage home;
 
 @BeforeClass
 public void launchNeoStox() throws InterruptedException
 {
	 launchBrowser(); //from base class
	 Utility.wait(driver, 1000);
	 login=new NeostoxLoginPage(driver);
	 pass=new NeoStoxPasswordPage(driver);
	 home=new NeoStoxHomePage(driver);
	 Utility.wait(driver, 1000);
	 
 }
 
 @BeforeMethod
 public void logintoNeoStox() throws EncryptedDocumentException, IOException, InterruptedException
 {   
	  login.neostoxSignInpage();
	  Utility.wait(driver, 2000);
	  login.sendMobileNum(driver, Utility.readDataFromExcel(0, 0));
	  login.clickOnSignInButton(driver);
	  Utility.wait(driver, 1000);
	  pass.enterPassword(driver, Utility.readDataFromExcel(0, 1));
	  Thread.sleep(2500);
	  pass.clickOnSubmitButton(driver);
	  Thread.sleep(6500);
	  home.handlepopup();
	  Utility.wait(driver, 1000);
	 
 }
  @Test (priority = -1)
  public void validateUsername() throws EncryptedDocumentException, IOException 
  {
	  Assert.assertEquals(home.getUserName(), Utility.readDataFromExcel(0, 2));
  }
  @Test
  public void validateAccountBalance()
  {
	  Assert.assertNotNull(home.getAccountBalance(), "Account balance is null so TC is failed");
  }
  
  @AfterMethod
  public void logoutfromNeostox()
  {
	  home.clickingonLogout(driver);
  }
  @AfterClass
  public void closingBrowser()
  {
	  driver.close();
  }
  
  
  
  
  
  
  
}

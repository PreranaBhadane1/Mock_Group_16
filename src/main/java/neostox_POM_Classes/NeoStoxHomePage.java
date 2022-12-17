package neostox_POM_Classes;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import utility.Utility;

public class NeoStoxHomePage
{

	
	@FindBy(xpath = "(//a[text()='OK'])[2]")private WebElement okButton;
	@FindBy(xpath = "(//a[text()='Close'])[5]")private WebElement closeButton;
	@FindBy(xpath = "//span[@id='lbl_username']")private WebElement username;
	@FindBy(xpath = "//span[text()='Logout']")private WebElement logoutButton;
	@FindBy(xpath = "//span[@id='lbl_curbalancetop']")private WebElement accountBalance;
	
	public NeoStoxHomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	public void handlepopup() throws InterruptedException
	{
		if (okButton.isDisplayed())
		{
			Thread.sleep(1000);
			okButton.click();
			Reporter.log("Handeling popup", true);
			Reporter.log("clicking on ok button of popup", true);
			closeButton.click();
			Reporter.log("clicking on close button of popup ", true);
			
			
		}
		else 
		{
			Reporter.log("there is no popup", true);
			Thread.sleep(1000);
			
		}
	}
	public String getUserName()
	{
		String actualusername = username.getText();
		Reporter.log("getting actual username ", true);
		return actualusername;
		
	}
	public void clickingonLogout(WebDriver driver)
	{
		username.click();
		Utility.wait(driver, 1000);
		logoutButton.click();
	}
	public String getAccountBalance()
	{
		String actualAccBalance = accountBalance.getText();
		Reporter.log("getting actual account balance ", true);
		return actualAccBalance;
	}
	
	
	
	
	
	
}

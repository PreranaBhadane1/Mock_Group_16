package neostox_POM_Classes;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import utility.Utility;

public class NeostoxLoginPage 
{
    @FindBy(xpath = "(//a[text()='Sign In'])[1]")private WebElement signInpage;
	@FindBy(id = "MainContent_signinsignup_txt_mobilenumber")private WebElement mobileNumFeild;
	@FindBy(xpath = "(//a[text()='Sign In'])[2]")private WebElement signInButton;
	public void neostoxSignInpage()
	{
		signInpage.click();
	}
	
	public  NeostoxLoginPage(WebDriver driver) 
	{
		PageFactory.initElements(driver,this);
	}
	
	public void sendMobileNum(WebDriver driver , String mobNum)
	{
		Utility.wait(driver, 1000);
		mobileNumFeild.sendKeys(mobNum);
		Reporter.log("Entering mobile Number", true);
	}
	public void clickOnSignInButton(WebDriver driver)
	{
		Utility.wait(driver, 1000);
		signInButton.click();
		Reporter.log("Clicking on Sign In Button", true);
	}
}

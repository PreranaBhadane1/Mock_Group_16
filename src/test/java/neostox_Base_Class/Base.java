package neostox_Base_Class;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;

public class Base 
{
    protected WebDriver driver;
	public void launchBrowser() throws InterruptedException 
	{
		System.setProperty("webdriver.chrome.driver","C:\\Users\\prera\\Documents\\16 july files\\chromedriver.exe");
		 
		 driver=new ChromeDriver();
		 driver.manage().window().maximize();
		 Thread.sleep(1000);
		 
		 driver.get("https://neostox.com/");
		 Reporter.log("Launching browser",true);
		 Thread.sleep(1000);
		 

	}

}

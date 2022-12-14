package utility;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.Reporter;

public class Utility 
{
    
	// Commonly used method 
	
	// screenshot, wait ,scrolling ,excel reading
	
	public static String readDataFromExcel(int row,int cell) throws EncryptedDocumentException, IOException
	{
		File myfile=new File("C:\\Users\\prera\\Documents\\16 july files\\sheet1.xlsx");
		String value = WorkbookFactory.create(myfile).getSheet("sheet1").getRow(row).getCell(cell).getStringCellValue();
		Reporter.log("Reading data from excel", true);
		
		return value;
		
	}
   public static void takeScreenshot(WebDriver driver, String screenShotName) throws IOException
   {
	  File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	  File dest=new File("C:\\Users\\prera\\Documents\\Screenshot\\"+screenShotName+".png");
	  FileHandler.copy(src, dest);
	  Reporter.log("Taking screenshot", true);
	  
	  
   }
   public static void wait (WebDriver driver, int waitTime)
   {
	   driver.manage().timeouts().implicitlyWait(Duration.ofMillis(waitTime));
	   Reporter.log("Waiting for"+waitTime+"ms",true);
   }


}


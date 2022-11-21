package Util;


import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;
import teststeps.testBase;


/*===============================================================
	This is a class file for all types of utility Methods such as 
	click, sendkeys, etc.,
	===============================================================*/

public class testUtil {

	public static WebElement driver;
	public static boolean status;
	public static String Basepath;
	public static String SScreenshotdirpath;
	public static int time_seconds=90;

	/*=================================================================

 						Utility Methods 

	==================================================================*/

	public static void waitUntilElementClickable(WebElement elementToBeLoaded, int time_seconds, String elementName)
	{
		try {
			Thread.sleep(1000);
			WebDriverWait ww = new WebDriverWait(testBase.driver, time_seconds);

			ww.until(ExpectedConditions.elementToBeClickable(elementToBeLoaded));

			status = true;

		} catch (Exception e) {

			System.out.println("Step Failed: Loading has NOT succeeded for the Element: "+elementName);
			status = false;
		}

	}

	public static void waitUntilElementLoads(WebElement elementToBeLoaded, int time_seconds, String elementName)
	{
		status = false;
		try {

			WebDriverWait ww = new WebDriverWait(testBase.driver, time_seconds);
			JavascriptExecutor js = ((JavascriptExecutor)testBase.driver);

			try {
				js.executeScript("arguments[0].scrollIntoView(true);", elementToBeLoaded);

			}catch (Exception e) {
				// TODO: handle exception
			}

			ww.until(ExpectedConditions.visibilityOf(elementToBeLoaded));
			status = true;
		} catch (Exception e) {

			e.printStackTrace();
			System.out.println("Step Failed: Loading has NOT succeeded for the Element: "+elementName);
			status = false;
		}

	}

	public static boolean Click(WebElement elementClick, String elementName)
	{
		status = false;
		try {
			Thread.sleep(1000);
			waitUntilElementClickable(elementClick, time_seconds, elementName);
			JavascriptExecutor js = ((JavascriptExecutor)driver);

			try {
				js.executeScript("arguments[0].scrollIntoView(true);", elementName);
				js.executeScript("arguments[0].style.border = '3px solid red'", elementClick);

			}catch (Exception e) {
				// TODO: handle exception
			}
			GetScreenshot();
			elementClick.click();
			status = true;
			System.out.println("Step Passed: Clicked on the Element: "+elementName);
		} catch (Exception e) {
			System.out.println("Step Failed: NOT Clicked on the Element: "+elementName);
			status = false;
		}
		return status;
	}

	public static boolean SendKeys(WebElement elementForSendingData, String valueToBeSent, String elementName)
	{
		status = false;
		try {
			Thread.sleep(1000);
			waitUntilElementLoads(elementForSendingData, time_seconds, elementName);
			elementForSendingData.sendKeys(valueToBeSent);
			JavascriptExecutor js = ((JavascriptExecutor)driver);
			try {
				js.executeScript("arguments[0].scrollIntoView(true);", elementForSendingData);
				js.executeScript("arguments[0].sytle.backgroundColor= 'Lightcoral'", elementForSendingData);

			}catch (Exception e) {
				// TODO: handle exception
			}
			GetScreenshot();
			System.out.println("Step Passed: Entered the data '"+valueToBeSent+"'"+" in the Input box : "+elementName);
			status = true;
		} catch (Exception e) {

			e.printStackTrace();
			System.out.println("Step Failed: NOT Entered the data '"+valueToBeSent+"'"+" in the Input box : "+elementName);
			status = false;
		}
		return status;
	}

	public static boolean IsObjectPresent(WebElement elementToBePresent, String elementName) throws IOException
	{
		status = false;
		try {
			waitUntilElementLoads(elementToBePresent, time_seconds, elementName);
			JavascriptExecutor js = ((JavascriptExecutor)testBase.driver);
			try {
				js.executeScript("arguments[0].scrollIntoView(true);", elementToBePresent);				
			}catch (Exception e) {
				// TODO: handle exception
			}
			GetScreenshot();
			elementToBePresent.isDisplayed();
			System.out.println("Step Passed: WebElement is displayed: "+elementName);
			status = true;

		} catch (Exception e) {

			// e.printStackTrace();
			System.out.println("Step Failed: WebElement is NOT displayed: "+elementName);
			status = false;

		}
		GetScreenshot();
		return status;
	}

	public static String GetText(WebElement element, String elementName) throws IOException
	{
		status = false;
		String sElementValue ="";
		try {
			Thread.sleep(1000);
			waitUntilElementLoads(element, time_seconds, elementName);
			JavascriptExecutor js = ((JavascriptExecutor)testBase.driver);
			try {
				js.executeScript("arguments[0].scrollIntoView(true);", element);				
			}catch (Exception e) {
				// TODO: handle exception
			}
			GetScreenshot();
			sElementValue = element.getText();
			if(!(sElementValue.length()==0)) {
				System.out.println("Step Passed: Value of the WebElement "+elementName+" is "+sElementValue);
				status = true;
			}
		} catch (Exception e) {

			System.out.println("Step Failed: Value of the WebElement "+elementName+" is missing ");
			status = false;

		}

		return sElementValue;
	}

	public static void GetScreenshot() throws IOException
	{
		TakesScreenshot ts = ((TakesScreenshot)testBase.driver);
		String path = System.getProperty("user.dir");
		String Basepathsc = path+"/Screenshots/";
		Calendar cal = Calendar.getInstance();    
		File Dir = new File(Basepathsc);
		Dir.mkdir();
		int year = cal.get(Calendar.YEAR);
		Dir = new File(Basepathsc+"/"+year);
		Dir.mkdir();
		int month = cal.get(Calendar.MONTH);
		Dir = new File(Basepathsc+"/"+year+"/"+(month+1));
		Dir.mkdir();
		int day = cal.get(Calendar.DATE);
		Dir = new File(Basepathsc+"/"+year+"/"+(month+1)+"/"+day);
		Dir.mkdir();
		Dir = new File(Basepathsc+"/"+year+"/"+(month+1)+"/"+day);
		Dir.mkdir();
		SScreenshotdirpath = Dir.getAbsolutePath();
		Date sDate = new Date();
		String sScreenshotFilename = sDate.getHours()+"_"+sDate.getMinutes()+"_"+sDate.getDate();
		String sScreenshotFilepath = SScreenshotdirpath+"/"+sScreenshotFilename+".png";
		File source = ts.getScreenshotAs(OutputType.FILE);
		File destination = new File(sScreenshotFilepath);
		Files.copy(source, destination);

	}

}

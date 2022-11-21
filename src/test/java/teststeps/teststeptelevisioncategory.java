package teststeps;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.testng.asserts.SoftAssert;
import pages.pagehome;
import pages.pagetelevisioncategory;


public class teststeptelevisioncategory extends testBase{

	@SuppressWarnings("unused")
	public teststeptelevisioncategory() {
		pagehome pageHome = new pagehome(driver);
		pagetelevisioncategory pagetelevisioncategory = new pagetelevisioncategory(driver);
	}

	public static boolean validation;

	public void verifyaboutthissection() throws InterruptedException, IOException
	{
		SoftAssert valassert = new SoftAssert();
		
		pagehome.clickOnhamburgermenu();
		pagehome.clickOnelectronicscategory();
		pagehome.clickOntelevisionscategory();
		pagehome.clickOnSamsungfilter();
		pagetelevisioncategory.clickOnsortBy();
		pagetelevisioncategory.clickOnhightolow();
		pagetelevisioncategory.clickOnresult();	
		Set<String> winid = driver.getWindowHandles();
        Iterator<String> iter = winid.iterator();
        iter.next();

        String tab = iter.next();
        driver.switchTo().window(tab);
        System.out.println(driver.getTitle());
        
        pagetelevisioncategory.clickOnaboutthisitem();
		String text = pagetelevisioncategory.getaboutthisitemTxt();
		System.out.println("About this item section:   "+ '\n' +"\033[0;1m" +text);
		validation = pagetelevisioncategory.verifyaboutthisitem();
		valassert.assertTrue(validation, "About this item section");
		valassert.assertAll();
	}






}
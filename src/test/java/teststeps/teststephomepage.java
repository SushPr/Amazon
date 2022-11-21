package teststeps;

import java.io.IOException;

import org.testng.asserts.SoftAssert;
import pages.pagehome;


public class teststephomepage extends testBase{

	@SuppressWarnings("unused")
	public teststephomepage() {
		pagehome PageHome = new pagehome(driver);
	}

	public void navigatetoappURL() throws InterruptedException, IOException
	{
		SoftAssert sfassert = new SoftAssert();
		driver.get("https://www.amazon.in/");
		String url  =driver.getCurrentUrl();
		sfassert.assertEquals(url, "https://www.amazon.in/", "URL");
		sfassert.assertAll();
	}





}
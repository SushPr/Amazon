package pages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import Util.testUtil;
import teststeps.testBase;

public class pagetelevisioncategory extends testBase{

	public pagetelevisioncategory(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//*[text()='Brands']/following::ul/li/span/a/span[text()='Samsung']")
	public static WebElement samsungfilter;

	@FindBy(xpath = "//*[@id='a-autoid-0-announce']/span[text()='Sort by:']")
	public static WebElement sortBy;

	@FindBy(xpath = "//a[text()='Price: High to Low']")
	public static WebElement hightolow;

	@FindBy(xpath = "//div[@cel_widget_id='MAIN-SEARCH_RESULTS-2']/div/div")
	public static WebElement result;

	@FindBy(xpath = "//*[@id='feature-bullets']/h1")
	public static WebElement aboutthisitem;

	@FindBy(xpath = "//*[@id='feature-bullets']/ul")
	public static WebElement aboutthisitemTxt;


	/*************************************************************
	
	 *************************************************************/


	public static boolean clickOnSamsungfilter() {
		return testUtil.Click(samsungfilter, "Click on Samsung Brand Filter");
	}

	public static boolean clickOnsortBy() {
		return testUtil.Click(sortBy, "Click on sortBy");
	}

	public static boolean clickOnhightolow() {
		return testUtil.Click(hightolow, "Click on hightolow");
	}

	public static boolean clickOnresult() {
		return testUtil.Click(result, "Click on result");
	}

	public static boolean clickOnaboutthisitem() {
		return testUtil.Click(aboutthisitem, "Click on aboutthisitem");
	}

	public static String getaboutthisitemTxt() throws IOException {
		return testUtil.GetText(aboutthisitemTxt, "Get aboutthisitemTxt");
	}

	public static  boolean verifyaboutthisitem() throws IOException {
		return testUtil.IsObjectPresent(aboutthisitem, "Verify About this Item");
	}







}

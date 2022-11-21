package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import Util.testUtil;
import teststeps.testBase;

public class pagehome extends testBase{

	public pagehome(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "nav-hamburger-menu")
	public static WebElement hamburgermenu;

	@FindBy(xpath = "//div[contains(text(),'TV, Appliances, Electronics')]")
	public static WebElement electronicscategory;

	@FindBy(xpath = "//a[contains(text(),'Televisions')]")
	public static WebElement televisionscategory;

	@FindBy(xpath = "//*[text()='Brands']/following::ul/li/span/a/span[text()='Samsung']")
	public static WebElement samsungfilter;


	/*************************************************************

	 *************************************************************/


	public static boolean clickOnhamburgermenu() {
		return testUtil.Click(hamburgermenu, "Click on Hamburger menu");
	}

	public static boolean clickOnelectronicscategory() {
		return testUtil.Click(electronicscategory, "Click on Electronics Category");
	}

	public static boolean clickOntelevisionscategory() {
		return testUtil.Click(televisionscategory, "Click on televisionscategory");
	}

	public static boolean clickOnSamsungfilter() {
		return testUtil.Click(samsungfilter, "Click on Samsung Brand Filter");
	}


}

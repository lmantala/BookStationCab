package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import base.Base;

public class CabListingPage extends Base{

	
	public CabListingPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
}

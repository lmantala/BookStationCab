package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.Base;

public class CabListingPage extends Base{

	
	@FindBy(xpath = "//div[@class=\"appendBottom30\"]//label[text()=\"SUV\"]")
	WebElement byChkSUV;

	@FindBy(xpath = "//div[@id=\"List\"]//div[contains(@class,\"cabBookDetails\")]/div/div[2]/div//p[1]")
	List<WebElement> listOfSUBs;
	
	public CabListingPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public Integer findLowestPricedSUVCab() {
		byChkSUV.click();
		Integer maxPrice = 0;
			
		for(int i=0; i<listOfSUBs.size();i++) {
			 if (Integer.valueOf(listOfSUBs.get(i).getText().replace("\u20B9", " ").replace(",", "").trim()) > maxPrice)
				 maxPrice = Integer.valueOf(listOfSUBs.get(i).getText().replace("\u20B9", " ").replace(",", "").trim());
		}
		return maxPrice;
	}
}

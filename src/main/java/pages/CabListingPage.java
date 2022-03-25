package pages;

import java.util.ArrayList;
import java.util.Collections;
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
	List<WebElement> listOfSUVs;
	
	public CabListingPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void findandVerifyLowestPricedSUVCab() throws InterruptedException {
		byChkSUV.click();
		Thread.sleep(5000);
		Integer temp = 0;
		ArrayList<Integer> arrOfPrice = new ArrayList<Integer>();
		
		for(int i=0 ; i<listOfSUVs.size() ; i++) {
			arrOfPrice.add(Integer.valueOf(listOfSUVs.get(i).getText().replace("\u20B9", " ").replace(",", "").trim()));
		}
		
		System.out.println("Lowst Cab price form Delhi to Manali is : " + Collections.min(arrOfPrice));
	}
}

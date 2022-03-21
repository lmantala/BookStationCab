package pages;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import base.Base;
import utils.Waits;

public class GiftCardPage extends Base{

	Waits wait = new Waits();
	
	@FindBy(xpath = "//div[@class=\"gc__main\"]//div[2]/div[3]/ul/li[3]")
	WebElement byEleCorpGiftCard;
	
	@FindBy(xpath = "//input[@name=\"senderName\"]")
	WebElement byTxtSenderName;
	
	@FindBy(xpath = "//input[@name=\"senderMobileNo\"]")
	WebElement byTxtSendersMobile;
	
	@FindBy(xpath = "//input[@name=\"senderEmailId\"]")
	WebElement byTxtSendersMail;
	
	@FindBy(xpath = "//button[text()=\"BUY NOW\"]")
	WebElement byBtnBuyNow;
	
	@FindBy(xpath = "//p[text()=\"Please enter a valid Email id.\"]")
	WebElement byLblEmailInvalid;
	
	@FindBy(xpath = "//ul[@class=\"choosFrom__list\"]//span[text()=\"Gift Cards\"]")
	WebElement byBtnGiftCard;
	
	public GiftCardPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void validateBuyingGiftCard() throws InterruptedException {
		byBtnGiftCard.click();
		
		//Get handles of the windows
        String mainWindowHandle = driver.getWindowHandle();
        Set<String> allWindowHandles = driver.getWindowHandles();
        Iterator<String> iterator = allWindowHandles.iterator();

        // Here we will check if child window has other child windows and will fetch the heading of the child window
        while (iterator.hasNext()) {
            String ChildWindow = iterator.next();
                if (!mainWindowHandle.equalsIgnoreCase(ChildWindow)) {
                driver.switchTo().window(ChildWindow);
                scrollToView(byEleCorpGiftCard);
                Thread.sleep(2000);
                byEleCorpGiftCard.click();
                byTxtSenderName.sendKeys("Sakshi");
                byTxtSendersMobile.sendKeys("9876543210");
                byTxtSendersMail.sendKeys("abc@abc");
                byBtnBuyNow.click();
                wait.waitUntilVisibilityOf(byLblEmailInvalid, driver);
                Assert.assertEquals(byLblEmailInvalid.getText(), "Please enter a valid Email id.");
                System.out.println(byLblEmailInvalid.getText());
            }
        }
		
	}
	
}

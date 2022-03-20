package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.Base;

public class DashboardPage extends Base{
	
	public DashboardPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//div[@id=\"SW\"]//li[@data-cy=\"menu_Cabs\"]/a")
	WebElement byMenuCabs;
	
	@FindBy(id = "fromCity")
	WebElement byFromCity;
	
	@FindBy(xpath = "//input[@placeholder='From']")
	WebElement byTxtFromCity;
	
	@FindBy(id = "toCity")
	WebElement byToCity;
	
	@FindBy(xpath = "//input[@placeholder='To']")
	WebElement byTxtToCity;

	@FindBy(xpath = "//div[@class=\"csw_inner\"]//div[@class=\"csw_inputBox dates  \"]")
	WebElement bySelectDepDate;
	
	@FindBy(xpath = "//div[@class='csw_inner']//div[@class='csw_inputBox timePicker  ']")
	WebElement bySelectTime;
	
	@FindBy(xpath = "//a[@class=\"primaryBtn font24 latoBold widgetSearchBtn\"]")
	WebElement byBtnSearch;
	
	@FindBy(xpath = "/html/body/div[1]/div/div[2]/div/main/div[9]/span")
	WebElement byAdBanner;
	
	@FindBy(xpath = "/html/body/div")
	WebElement byAdBanner1;
	
	String byDepDatePicker = "//div[@class='DayPicker-Day' and text()='day']";
		
	public WebElement selectDepDay (String day) {
		return driver.findElement(By.xpath(byDepDatePicker.replace("day", day)));
	}
	
	public void removeAds() {
		byAdBanner1.click();
		byAdBanner.click();
	}
	
	public void searchCab(String from, String to, String day, String time) throws InterruptedException {
		
		byMenuCabs.click();
		
		byFromCity.click();
		byTxtFromCity.sendKeys("Delhi");
		Thread.sleep(3000);	
		byTxtFromCity.sendKeys(Keys.ARROW_DOWN);
		byTxtFromCity.sendKeys(Keys.ENTER);
		
		
//		byToCity.click();
		byTxtToCity.sendKeys("Manali");
		Thread.sleep(3000);
		byTxtToCity.sendKeys(Keys.ARROW_DOWN);
		byTxtToCity.sendKeys(Keys.ENTER);
		
//		bySelectDepDate.click();
		selectDepDay(day).click();
		
//		byBtnSearch.click();
		driver.findElement(By.xpath("//ul[@class=\"timeDropDown blackText\"]//li[3]")).click();
		
		byBtnSearch.click();
		
//	    driver.findElement(By.xpath("//div[@class=\"appendBottom30\"]//label[text()=\"SUV\"]")).click();
//	    driver.findElement(By.xpath("//div[@id=\"List\"]//div[contains(@class,\"cabBookDetails\")]/div/div[2]/div//p[1]")).click();
	}
}

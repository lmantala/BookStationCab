package pages;

import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import base.Base;
import utils.Waits;

public class DashboardPage extends Base{
	
	public DashboardPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//div[@id=\"SW\"]//li[@data-cy=\"menu_Cabs\"]/a")
	WebElement byMenuCabs;
	
	@FindBy(xpath = "//*[@id=\"SW\"]/div[1]/div[2]/div/div/nav/ul/li[2]/a/span[2]")
	WebElement byMenuHotels;
	
	@FindBy(id = "guest")
	WebElement bySelGuests;
	
	@FindBy(xpath = "//ul[@data-cy=\"adultCount\"]/li")
	List<WebElement> byListOfAdultNo;
	
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
	
	@FindBy(xpath = "//nav/ul/li/a/span[2]")
	List<WebElement> byListOfMenus;
	
	String byDepDatePicker = "//div[@class='DayPicker-Day' and text()='day']";
	String byLocationSuggetions = "(//div[contains(@class,\"autoSuggestPlugin\")]//span[contains(text(),\"location\")])[1]";
	
	Waits wait = new Waits();
	
	
//	Menu Items
	String menus[] = {
			"Flights",
			"Hotels",
			"Homestays",
			"Holiday Packages",
			"Trains",
			"Buses",
			"Cabs",
			"Visa",
			"Charter Flights",
			"Activities"
	};
	
	public WebElement selectLocation(String location) {
		return driver.findElement(By.xpath(byLocationSuggetions.replace("location", location)));
	}
	
	public WebElement selectDepDay (String day) {
		return driver.findElement(By.xpath(byDepDatePicker.replace("day", day)));
	}
	
	public void removeAds() {
		try {
			byAdBanner1.click();
			byAdBanner.click();
			System.out.println("Ads removed");
		} catch (Exception e) {
		}
		
	}
	
	public void fetchAndVerifyAdultNumbersFromHotels() {
		
		List<Integer> listOfAdultNumbers = new ArrayList<Integer>();
		byMenuHotels.click();
		bySelGuests.click();
		for(int i=0 ;i<byListOfAdultNo.size(); i++) {
			listOfAdultNumbers.add(Integer.valueOf(byListOfAdultNo.get(i).getText()));
		}
		
		System.out.println("Numbers of Adult persons are : " + Arrays.toString(listOfAdultNumbers.toArray()));
	}
	
	
	
	public void verifyListOfMenus() {
		for(int i=0 ; i<byListOfMenus.size() ; i++) {
			Assert.assertEquals(byListOfMenus.get(i).getText().equals(menus[i]), true,
					"Expected Menu : "+ menus[i] +" But found : " + byListOfMenus.get(i).getText());
		}
		System.out.println("Verified all menu items");
	}
	
	public void verifyPageTitle() {
		Assert.assertEquals(driver.getTitle().contains("MakeMyTrip"), true);
		System.out.println("Validated Page Title");
	}
	
	public void searchCab(String from, String to, String day, String time) throws InterruptedException {
		
		byMenuCabs.click();
		Thread.sleep(2000);
		byFromCity.click();
		byTxtFromCity.sendKeys("Delhi");
		wait.untillVisibilityOfElementLocatedBy(By.xpath(byLocationSuggetions.replace("location", "Delhi")), driver);
		selectLocation("Delhi").click();
		
		
		byTxtToCity.sendKeys("Manali");
		wait.untillVisibilityOfElementLocatedBy(By.xpath(byLocationSuggetions.replace("location", "Manali")), driver);
		selectLocation("Manali").click();;
		
		selectDepDay(day).click();
		
		driver.findElement(By.xpath("//ul[@class=\"timeDropDown blackText\"]//li[3]")).click();
		
		byBtnSearch.click();
		
	}	
}

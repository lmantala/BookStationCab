package base;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.beust.jcommander.Parameter;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.CabListingPage;
import pages.DashboardPage;
import pages.GiftCardPage;

public class Base {

	public WebDriver driver;
	public DashboardPage dashboardpage;
	public CabListingPage cabListingPage;
	public GiftCardPage giftCardPage;
	
	public void scrollToView(WebElement element) {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
	}
	
	public static void capture(WebDriver driver, String name) {
		Date date = new Date();
		String currentDate = date.toString().replace(" ", "-").replace(":", "-");
		File ss = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(ss, new File("target/screenshot/"+name+"-"+currentDate+".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	@BeforeMethod
	public void setup() {
		if (System.getProperty("browser").equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			}
		else if(System.getProperty("browser").equals("firefox")) {
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
			}
		else if(System.getProperty("browser").equals("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		
		dashboardpage = new DashboardPage(driver);
		cabListingPage = new CabListingPage(driver);
		giftCardPage = new GiftCardPage(driver);
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("http://www.makemytrip.com/");
	
	}
	
	@AfterMethod
	public void results() {
		driver.quit();
	}
	
	@AfterSuite
	public void tearUp() {
		
	}
}

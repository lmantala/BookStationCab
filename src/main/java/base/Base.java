package base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {

	public WebDriver driver;
	
	@BeforeSuite
	public void setup() {
		String browser="chrome";
		
		if (browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			}
		else if(browser.equals("firefox")) {
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
			}
		else if(browser.equals("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	driver.get("http://www.makemytrip.com/");
	
	}
	
	@AfterSuite
	public void tearUp() {
		driver.quit();
	}
}

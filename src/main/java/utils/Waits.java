package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Waits {

	public void waitUntilVisibilityOf(WebElement ele, WebDriver driver) {
		new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(ele));
	}
	
	public void untillVisibilityOfElementLocatedBy(By locator, WebDriver driver) {
		new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	
	public void waitUntilInvisibilityOf(WebElement ele, WebDriver driver) {
		new WebDriverWait(driver, 20).until(ExpectedConditions.invisibilityOf(ele));
	}
	
}

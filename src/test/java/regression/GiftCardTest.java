package base;

import org.testng.annotations.Test;

import pages.DashboardPage;
import pages.GiftCardPage;

public class GiftCardTest extends Base{
	
	GiftCardPage giftCardPage;
	DashboardPage dashboardPage;
	
	@Test
	public void Test2() throws Exception {
		try {
			giftCardPage = new GiftCardPage(driver);
			dashboardPage = new DashboardPage(driver);
			
			dashboardPage.removeAds();
			giftCardPage.validateBuyingGiftCard();
		} catch (Exception e) {
			capture(driver, new Object(){}.getClass().getEnclosingMethod().getName());
			throw new Exception(e.getMessage());
		}
		
	}
	
}

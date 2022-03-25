package regression;

import org.testng.annotations.Test;
import base.Base;


public class Regression extends Base {

	@Test
	public void Validate_Lowest_Cab_Price() throws Exception {
		try {
			dashboardpage.removeAds();
			dashboardpage.searchCab("Delhi", "Manali", "1", "12:15");
			cabListingPage.findandVerifyLowestPricedSUVCab();
		} catch (Exception e) {
			capture(driver, new Object(){}.getClass().getEnclosingMethod().getName());
			throw new Exception(e.getMessage());
		}
		
	}
	
	@Test
	public void Validate_Numbers_Of_Adult_Persons() throws Exception {
		try {
			dashboardpage.removeAds();
			dashboardpage.fetchAndVerifyAdultNumbersFromHotels();
		} catch (Exception e) {
			capture(driver, new Object(){}.getClass().getEnclosingMethod().getName());
			throw new Exception(e.getMessage());
		}
		
	}
	
	@Test
	public void Velidate_Incorrect_Email_Message() throws Exception {
		try {
			dashboardpage.removeAds();
			giftCardPage.validateBuyingGiftCard();
		} catch (Exception e) {
			capture(driver, new Object(){}.getClass().getEnclosingMethod().getName());
			throw new Exception(e.getMessage());
		}
		
	}
	
	
}

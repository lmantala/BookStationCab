package base;

import org.testng.ITestResult;
import org.testng.annotations.Test;

import pages.CabListingPage;
import pages.DashboardPage;

public class CabTest extends Base {

	public DashboardPage dashboardpage;
	public CabListingPage cabListingPage;
	@Test
	public void Test1() throws Exception {
		try {
			dashboardpage = new DashboardPage(driver);
			cabListingPage = new CabListingPage(driver);
			
			dashboardpage.removeAds();
			dashboardpage.searchCab("Delhi", "Manali", "1", "12:15");
			System.out.println("Lowset price of SUV is " + cabListingPage.findLowestPricedSUVCab());
		} catch (Exception e) {
			capture(driver, new Object(){}.getClass().getEnclosingMethod().getName());
			throw new Exception(e.getMessage());
		}
		
	}
	
	
}

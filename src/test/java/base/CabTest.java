package base;

import org.testng.annotations.Test;

import pages.DashboardPage;

public class CabTest extends Base {

	public DashboardPage dashboardpage;

	@Test
	public void Test1() throws Exception {

		dashboardpage = new DashboardPage(driver);
		dashboardpage.removeAds();
		dashboardpage.searchCab("Delhi", "Manali", "1", "12:15");

	}
}

package smoke;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.Base;

public class Smoke extends Base{
	
	@Test
	public void smoke() throws Exception {
		try {
			dashboardpage.verifyPageTitle();
			dashboardpage.verifyListOfMenus();
		} catch (Exception e) {
			capture(driver, new Object(){}.getClass().getEnclosingMethod().getName());
			throw new Exception(e.getMessage());
		}
		
	}
}

package com.Goibibo_IPT;

import org.testng.Assert;
import org.testng.annotations.Test;

public class flightSelect extends BaseClass2{

	public static pomGoibibo g;
	
	@Test(priority = 1)
	public static void browserLaunch() {
		browserLaunch("chrome");
		maximize();
		g = new pomGoibibo(driver);
				
	}
	
	@Test(dependsOnMethods = "browserLaunch")
	public void timing() throws Exception {
		implicitWait(10);
		getUrl("https://www.goibibo.com/flights/air-MAA-IXM-20230604--4-0-0-E-D/");
		Thread.sleep(10000);
		String actual = getTitle();
		String expected = "Book Cheap Flights, Air Tickets, Hotels, Bus & Holiday Package at Goibibo";
		Assert.assertEquals(actual, expected);
		click(g.getSixtotwelvepm());
	}
	
	@Test(dependsOnMethods = "timing")
	public static void fare() {
		
		implicitWait(10);	
		isDisplay(g.getViewfares());
		click(g.getViewfares());
		isDisplay(g.getFamilyfare());
		click(g.getFamilyfare());
	
	}
}

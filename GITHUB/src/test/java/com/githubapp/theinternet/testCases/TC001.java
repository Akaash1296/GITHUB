package com.githubapp.theinternet.testCases;

import org.testng.annotations.Test;

import com.githubapp.theinternet.base.BaseTests;
import com.githubapp.theinternet.pages.HomePage;

public class TC001 extends BaseTests {
  @Test
  public void clickForExplore() throws InterruptedException {
	  HomePage h = new HomePage(driver);
	  h.clickExplore();
	  sleep(3000);
  }
  
	public void sleep(long millis) {
		try {
			Thread.sleep(millis);
		}
		catch(InterruptedException e) {
			e.printStackTrace();
		}
	}
}

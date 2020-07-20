package com.githubapp.theinternet.testCases;

import org.testng.annotations.Test;

import com.githubapp.theinternet.base.BaseTests;
import com.githubapp.theinternet.pages.HomePage;

public class TC002 extends BaseTests {
  @Test
  public void clickForRepositories() throws InterruptedException {
	  HomePage h = new HomePage(driver);
	  h.clickSearchText();
	  sleep(1000);
	  h.clickRepositories();
	  sleep(1000);
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

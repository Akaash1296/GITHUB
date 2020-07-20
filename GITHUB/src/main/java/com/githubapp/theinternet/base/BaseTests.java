package com.githubapp.theinternet.base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.githubapp.theinternet.pages.HomePage;
import com.githubapp.theinternet.pages.LoginPage;

public class BaseTests implements IAutoConstants {
	public WebDriver driver;
	@Parameters({"browser", "ito"})
    @BeforeClass
    public void openApp(@Optional(LOCAL_KEY)String browser, @Optional(LOCAL_ITO)String ito) {
		if(browser.equalsIgnoreCase("chrome")) {
			System.setProperty(CHROME_KEY, CHROME_VALUE);
	    	driver = new ChromeDriver();
	    	long time = Long.parseLong(ito);
	    	driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
	    	Dimension d = new Dimension(1100, 900);
	    	driver.manage().window().setSize(d);
	    	String url = AutoUtils.getValue(CONFIG_PATH, "URL");
	    	driver.get(url);

			}    	    	
    }
	
	@BeforeMethod
	public void signIn() {
		LoginPage login = new LoginPage(driver);
		login.enterUserName();
		login.enterPassword();
		login.clickSignIn();
	}
	
	@AfterMethod
	public void signOut(ITestResult result) {
		int status = result.getStatus();
		if (status==1) {
			Reporter.log(result.getName()+"::"+"PASSED", true);
		}
		else {
			Reporter.log(result.getName()+"::"+"Failed", true);
			AutoUtils.getPhoto(driver, result.getName());
		}	
		HomePage h = new HomePage(driver);
		sleep(2000);
		h.clickLogOut();
	}
	
	@AfterClass
	public void CloseApp() {
		driver.quit();
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

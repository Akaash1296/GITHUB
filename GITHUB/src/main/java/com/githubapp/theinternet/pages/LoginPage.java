package com.githubapp.theinternet.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	@FindBy(name="login")
	private WebElement userName;
	
	@FindBy(name="password")
	private WebElement pwd;
	
	@FindBy(name="commit")
	private WebElement signIn;
	
	public void clickSignIn() {
		signIn.click();
	}
	
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void enterUserName() {
		userName.sendKeys("Akaash1296");
	}
	
	public void enterWrongUserName() {
		userName.sendKeys("akaash9612");
	}
	
	public void enterPassword() {
		pwd.sendKeys("YantraTest@15");
	}
	
	public void enterWrongPassword() {
		pwd.sendKeys("Yantratest@15");
	}
}

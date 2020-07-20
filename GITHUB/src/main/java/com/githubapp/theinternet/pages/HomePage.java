package com.githubapp.theinternet.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	@FindBy(xpath="(//a[@class='js-selected-navigation-item Header-link py-lg-3  mr-0 mr-lg-3 py-2 border-top border-lg-top-0 border-white-fade-15'])[3]")
	private WebElement explore;
	
	
	@FindBy(xpath="//input[@type='text']")
	private WebElement searchText;
	
	@FindBy(xpath="(//div[@class='jump-to-suggestion-name js-jump-to-suggestion-name flex-auto overflow-hidden text-left no-wrap css-truncate css-truncate-target'])[4]")
	private WebElement repositories;
	
	@FindBy(xpath="(//summary[@class='Header-link'])[2]")
	private WebElement imgIcon;
	
	@FindBy(xpath="//button[@class='dropdown-item dropdown-signout']")
	private WebElement logOut;
	
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver,  this);
	}
	public void clickExplore() {
		explore.click();
	}
	
	public void clickSearchText() {
		searchText.click();
	}
	
	public void clickRepositories() {
		repositories.click();
	}
	
	public void clickLogOut() {
		imgIcon.click();
		logOut.click();
	}
	
	
}

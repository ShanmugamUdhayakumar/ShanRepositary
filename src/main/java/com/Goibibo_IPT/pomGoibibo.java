package com.Goibibo_IPT;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class pomGoibibo {
	
	
	public static WebDriver driver;
		
	
	@FindBy(xpath = "//span[@class='black']") private WebElement sixam;
	
	@FindBy(xpath = "//span[text()='6AM - 12PM']") private WebElement sixtotwelvepm;
	
	@FindBy(xpath = "//span[text()='12PM - 6PM']") private WebElement twelvetosixpm;
	
	@FindBy(xpath = "//span[text()='After 6PM']") private WebElement aftersixpm;
	
	@FindBy(xpath = "(//button[text()='VIEW FARES'])[2]") private WebElement viewfares;
	
	@FindBy(xpath = "(//input[@type='button'])[3]") private WebElement familyfare;

	public static WebDriver getDriver() {
		return driver;
	}

	public WebElement getSixam() {
		return sixam;	
	}

	public WebElement getTwelvetosixpm() {
		return twelvetosixpm;
	}

	public WebElement getSixtotwelvepm() {
		return sixtotwelvepm;
	}

	public WebElement getAftersixpm() {
		return aftersixpm;
	}

	public WebElement getViewfares() {
		return viewfares;
	}

	public WebElement getFamilyfare() {
		return familyfare;
	}
	
	
	public pomGoibibo(WebDriver driver1) {
	driver=driver1;
	PageFactory.initElements(driver, this);	
	}
}

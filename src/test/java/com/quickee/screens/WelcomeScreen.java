package com.quickee.screens;

import org.openqa.selenium.support.PageFactory;

import com.quickee.driver.SharedDriver;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSFindBy;

public class WelcomeScreen extends SharedDriver {
	
	public String quickeeTitle = "Welcome!";
	
	@iOSFindBy(xpath="//XCUIElementTypeStaticText[@name=\"Welcome!\"]")
	private MobileElement ScreenTitle;
	
	@iOSFindBy(id="Welcome to Quickee!")
	private MobileElement Screenheading;
	
	@iOSFindBy(id="Facebook")
	private MobileElement Facebookbutton;
	
	@iOSFindBy(id="Sign Up with Phone Number")
	private MobileElement SignUpWithPhone;
	
	@iOSFindBy(id="Email Address")
	private MobileElement Emailbutton;
	
	@iOSFindBy(id="Back Icon")
	private MobileElement Backbutton;
	
	public WelcomeScreen() { PageFactory.initElements(new AppiumFieldDecorator(getAppiumDriver()), this); }
	

	public MobileElement getScreenTitle(){ return ScreenTitle; }
	public MobileElement getScreenheading(){ return Screenheading; }
	public MobileElement getSignUp(){ return SignUpWithPhone; }
	public MobileElement getFacebooklink(){ return Facebookbutton; }
	public MobileElement getEmaillink(){ return Emailbutton; }
	public MobileElement getbackbutton(){ return Backbutton; }
	
		
	public void isCorrectAppTitleDisplayed(){
		
		isCorrectMessageDisplayed(ScreenTitle, quickeeTitle);}
	
	public void tapOnEmailbutton() {
		click(Emailbutton);
	}
	

}

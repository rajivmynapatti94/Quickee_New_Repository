package com.quickee.screens;

import org.openqa.selenium.support.PageFactory;
import com.quickee.driver.SharedDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.*;

public class GetStartedScreen extends SharedDriver{
	
	public String quickeeTitle = "Quickee";
	
	@iOSFindBy(id="icon-login")
	private MobileElement appIcon;
	
	@iOSFindBy(id="Quickee_Text")
	private MobileElement appTitle;
	
	@iOSFindBy(id="Give instant feedback anywhere, anytime.")
	private MobileElement appSlogan;
	
	@iOSFindBy(id="Get Started")
	private MobileElement startScreen;
	
	@iOSFindBy(id="What’s Quickee’s purpose?")
	private MobileElement what_Quickee_Response_link;
	
	@iOSFindBy(id="Login")
	private MobileElement login;
	
	
	public GetStartedScreen() { PageFactory.initElements(new AppiumFieldDecorator(getAppiumDriver()), this); }
	
	public MobileElement getAppIcon(){ return appIcon; }
	public MobileElement getAppTitle(){ return appTitle; }
	public MobileElement getAppSlogan(){ return appSlogan; }
	public MobileElement getStartedScreen(){ return startScreen; }
	public MobileElement getQuickeeResponseLink(){ return what_Quickee_Response_link; }
	public MobileElement getLoginLink(){ return login; }
	
	public void isAppIconDisplayed(){
		isElementVisible(appIcon);
	}
	
	public void isCorrectAppTitleDisplayed(){
		
		isCorrectMessageDisplayed(appTitle, quickeeTitle);
	}
	
	public void goToLoginScreen(){
		click(login);
	}
	
	public void goToGetStratedScreen(){
		click(startScreen);
	}
	
	public void goToQuickee_Response_screen(){
		click(what_Quickee_Response_link);
	}
	
}
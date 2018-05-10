package com.quickee.screens;

import org.openqa.selenium.support.PageFactory;

import com.quickee.driver.SharedDriver;
import com.quickee.driver.SharedDriver.Direction;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSFindBy;

public class Post_A_QuickeeScreen extends SharedDriver {
	
	@iOSFindBy(xpath="//*[@name=\"Post a Quickee\"]")
	private MobileElement ScreenTitle;
	
	@iOSFindBy(xpath="//*[@name=\"username normal\"]")
	private MobileElement QuickeeWithUsername;
	
	@iOSFindBy(xpath="//*[@name=\"anonymously normal\"]")
	private MobileElement QuickeeWithAnonymousname;
	
	@iOSFindBy(id="Next")
	private MobileElement NextButton;
	
	@iOSFindBy(id="Disney Store")
	private MobileElement storeName;
	
	
	public Post_A_QuickeeScreen() {
		PageFactory.initElements(new AppiumFieldDecorator(getAppiumDriver()), this);
	}

	
	public MobileElement QuickeeWithUserName(){return QuickeeWithUsername;}
	public MobileElement QuickeeWithAnonymousName(){return QuickeeWithAnonymousname;}
	public MobileElement TapNextbutton(){return NextButton;}
	public MobileElement Storename(){return storeName;}
	
	public void postAnomously(){
		click(QuickeeWithAnonymousname);
	}
	
	public void postWithUsername(){
		click (QuickeeWithUsername);
		}
	
	public void tapNext(){
		click(NextButton);
	}
	public void selectStore(){
		
		//driver.fi
		swipeUntilElementDisplayed(storeName,Direction.DOWN);
		storeName.click();
		
	}
	
}

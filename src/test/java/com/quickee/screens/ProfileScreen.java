package com.quickee.screens;

import org.openqa.selenium.support.PageFactory;

import com.quickee.driver.SharedDriver;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSFindBy;

public class ProfileScreen extends SharedDriver{
	
	@iOSFindBy(id="settings icon")
	private MobileElement settings;
	
	public ProfileScreen(){
		
		PageFactory.initElements(new AppiumFieldDecorator(getAppiumDriver()), this);
	}
	
	public MobileElement goToSettingsIcon(){ return settings; }
	
	public void clickOnSettingsIcon(){
		
		click(settings);
		
	}
	
}

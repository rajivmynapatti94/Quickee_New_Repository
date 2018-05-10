package com.quickee.screens;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import com.quickee.driver.SharedDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSFindBy;

public class LatestQuickeesScreen extends SharedDriver{
	
	private enum page {Latest_Quickees}
	
	@iOSFindBy(id="icon bell")
	private MobileElement notificationIcon;

	@iOSFindBy(id="TabBarItem_Selected_AccessibilityLabel")
	private MobileElement  quickee_Friends ;

	@iOSFindBy(xpath="(//XCUIElementTypeOther[@name=\"TabBarItem_AccessibilityLabel\"])[1]")
	private MobileElement feeds;

	@iOSFindBy(xpath="(//XCUIElementTypeOther[@name=\"TabBarItem_AccessibilityLabel\"])[2]")
	private MobileElement addNew;

	@iOSFindBy(xpath="(//XCUIElementTypeOther[@name=\"TabBarItem_AccessibilityLabel\"])[3]")
	private MobileElement search;

	@iOSFindBy(xpath="(//XCUIElementTypeOther[@name=\"TabBarItem_AccessibilityLabel\"])[4]")
	
	private MobileElement profile;
	
	@iOSFindBy(xpath="//*[@name=\"Latest Quickees\"]")
	private MobileElement latestQuickeeTitle;
	
	public LatestQuickeesScreen() {
		PageFactory.initElements(new AppiumFieldDecorator(getAppiumDriver()), this);
	}
	
	public MobileElement notificationIconBell(){ return notificationIcon; }
	public MobileElement getFeeds(){ return feeds; }
	public MobileElement getQuickee_Friends(){ return quickee_Friends; }
	public MobileElement addNewPost(){ return addNew; }
	public MobileElement searchPost(){ return search; }
	public MobileElement getProfile(){ return profile; }
	
	public void isLatestQuickeesPageDisplayed(){
		
		isCorrectMessageDisplayed(latestQuickeeTitle, getPage(page.Latest_Quickees.toString()));
	}

	public void clickProfileTab(){
		click(profile);
		
	}
	
	public void tapPostTab(){
		click(addNew);
		
	}

}

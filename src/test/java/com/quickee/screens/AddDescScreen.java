package com.quickee.screens;

import org.openqa.selenium.support.PageFactory;

import com.quickee.driver.SharedDriver;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSFindBy;

public class AddDescScreen extends SharedDriver{
	
	public String quickeeTitle = "Post a Quickee";
	
	
	@iOSFindBy(xpath="*//[@name=\"Post a Quickee\"]")
	private MobileElement appTitle;
	
	@iOSFindBy(id="Back Icon")
	private MobileElement backButton;
	
	@iOSFindBy(id="Placeholder-camera")
	private MobileElement placeholderCamera;
	
	@iOSFindBy(xpath="//XCUIElementTypeButton[@name=\"Next\"]")
	private MobileElement nextButton;
	
	@iOSFindBy(id="giphy icon normal")
	private MobileElement giphyIcon;
	
	@iOSFindBy(id="camera icon")
	private MobileElement cameraIcon;
	
	@iOSFindBy(xpath="//*[@value=\"Add a strong headline to your Quickee\"]")
	private MobileElement headlineTextField;
	
	@iOSFindBy(xpath="//XCUIElementTypeApplication[@name=\"Quickee\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeCollectionView/XCUIElementTypeCell/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeTextView"
)
	private MobileElement addDescription;
	
	

	public AddDescScreen(){
		PageFactory.initElements(new AppiumFieldDecorator(getAppiumDriver()), this);
	}
public MobileElement addHeadline(){return headlineTextField;}
public MobileElement addDesc(){return addDescription;}
	
public void isCorrectAppTitleDisplayed(){
		
		isCorrectMessageDisplayed(appTitle, quickeeTitle);
}

public void enterHeadlineAndDescption(){
	sendKeys("Testing", headlineTextField);
	sendKeys("This text is for testing purpose", addDescription);
}
	public void clickCamera(){
		click(cameraIcon);
		
	}
}

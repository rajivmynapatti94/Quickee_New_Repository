package com.quickee.screens;

import org.openqa.selenium.support.PageFactory;

import com.quickee.driver.SharedDriver;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSFindBy;

public class SettingsScreen extends SharedDriver {
	
	private enum page {Settings}
	
	@iOSFindBy(id="Change Profile Picture")
	private MobileElement profilePicture;
	
	@iOSFindBy(xpath="//*[@name=\"Use Gallery\"]")
	private MobileElement gallery;
	
	@iOSFindBy(xpath="//*[@name=\"Moments\"]")
	private MobileElement moments;
	
	@iOSFindBy(id="Photo, Landscape, August 09, 2012, 12:22 AM")
	private MobileElement picture;
	
	@iOSFindBy(id="Done")
	private MobileElement doneLink;
	
	@iOSFindBy(id="Log Out")
	private MobileElement logOut;
	
	public SettingsScreen(){
		
		PageFactory.initElements(new AppiumFieldDecorator(getAppiumDriver()), this);
	}
	
	public MobileElement changePicture(){ return profilePicture; }
	public MobileElement useGallery(){ return gallery; }
	public MobileElement momentSection(){ return moments; } 
	public MobileElement choosePicture(){ return picture; }
	public MobileElement donePicture(){ return doneLink; }
	public MobileElement logOutTab(){ return logOut; }
	
	public void selectProfilePictureUsingGallery(){
		click(profilePicture); 
		click(gallery);
		WaitforAlert();
		click(moments);
		click(picture);
		click(doneLink);
	}
	
	
	public void logOutUser(){
		click(logOut);
	}

	public void selectGalleryforImage(){
		click(gallery);
		click(moments);
		click(picture);
		click(doneLink);
		
	}
}

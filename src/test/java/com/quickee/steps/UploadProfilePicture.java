package com.quickee.steps;

import com.quickee.screens.GetStartedScreen;
import com.quickee.screens.LatestQuickeesScreen;
import com.quickee.screens.LoginScreen;
import com.quickee.screens.ProfileScreen;
import com.quickee.screens.SettingsScreen;
import cucumber.api.java.en.And;

public class UploadProfilePicture extends SettingsScreen{
	
	GetStartedScreen getstartedScreen = new GetStartedScreen();
	LoginScreen loginScreen = new LoginScreen();
	LatestQuickeesScreen latestQuickeesScreen = new LatestQuickeesScreen();
	ProfileScreen profileScreen = new ProfileScreen();
	
	@And("^Upload Profile picture with the help of gallery section$")
	public void selectProfilePictureWithGallery(){
		
		selectProfilePictureUsingGallery();
		
	}
	
	

}

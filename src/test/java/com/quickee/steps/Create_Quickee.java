package com.quickee.steps;

import java.util.List;

import org.openqa.selenium.WebElement;

import com.quickee.screens.AddDescScreen;
import com.quickee.screens.GetStartedScreen;
import com.quickee.screens.LatestQuickeesScreen;
import com.quickee.screens.LoginScreen;
import com.quickee.screens.Post_A_QuickeeScreen;
import com.quickee.screens.ProfileScreen;
import com.quickee.screens.SettingsScreen;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import io.appium.java_client.MobileElement;

public class Create_Quickee extends LoginScreen {
	
	GetStartedScreen getstartedScreen = new GetStartedScreen();
	LatestQuickeesScreen latestQuickeesScreen = new LatestQuickeesScreen();
	ProfileScreen profileScreen = new ProfileScreen();
	SettingsScreen settingScreen = new SettingsScreen();
	Post_A_QuickeeScreen postQuickee = new Post_A_QuickeeScreen();
	AddDescScreen QuickeeDesc= new AddDescScreen();
	
	
	
	
	@And("^Click on addnew link from Latest Quickees Screen$")
	public void click_on_addnew_link_from_Latest_Quickees_Screen() throws Throwable {
		latestQuickeesScreen.tapPostTab();
	}

	@And("^Click on Anonymously icon from QuickeeTypeScreen$")
	public void click_on_Anonymously_icon_from_QuickeeTypeScreen() throws Throwable {
	    postQuickee.postAnomously();
	  
	//To handle the toggle button in Post a Quickee screen we use the below    
	
	    /*    List<WebElement> Toggle=driver.findElementsByTagName("XCUIElementTypeSwitch");
	      Toggle.get(0).click();
	      Toggle.get(1).click();         */
	}

	@And("^Click on Next button$")
	public void click_on_Next_button() throws Throwable {
		postQuickee.tapNext();
	}

	@Then("^User will navigate to Map view screen$")
	public void user_will_navigate_to_Map_view_screen() throws Throwable {
	   
	//WE are getting a pop up  to allow location permissions very first time and we have to create a method to accept that alert popup
		
		System.out.println("User is navigated to Map_Screen");
	    
		//MethodSwipeUp(3000);
	    swipe(Direction.DOWN);
	    //swipe(Direction.UP);
	  // driver.quit();
	//   postQuickee.selectStore();
	
	//    QuickeeDesc.enterHeadlineAndDescption();
	//    QuickeeDesc.clickCamera();
	//    settingScreen.selectGalleryforImage();
	    
	    
	    //After entering the Headline and Description we will be landed to preview screen
	 //   postQuickee.tapNext();
	}
}

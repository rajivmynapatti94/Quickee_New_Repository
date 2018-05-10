package com.quickee.steps;

import java.net.MalformedURLException;

import org.openqa.selenium.Alert;

import com.quickee.driver.SharedDriver;
import com.quickee.screens.GetStartedScreen;
import com.quickee.screens.LatestQuickeesScreen;
import com.quickee.screens.LoginScreen;
import com.quickee.screens.WelcomeScreen;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class InvalidLoginStep extends LoginScreen {

	
	GetStartedScreen getstartedScreen = new GetStartedScreen();
	LatestQuickeesScreen latestQuickeesScreen = new LatestQuickeesScreen();
	WelcomeScreen WS=new WelcomeScreen(); 
	
	
	
	@Then("^Enter Invalid Email and Password and click on Sign In button$")
	public void enterInvalidEmailAndPassword() throws InterruptedException, MalformedURLException{
		
		enterInvalidEmail(getAutoTestInvalidEmailUsername());
		enterPassword(getAutoTestInvalidEmailPassword());
		clickSignInButton();
		log.debug("Entered user Email and Password and then tap on Sign button from Login screen");
	}
	
	/*@And ("^Application will prompt an alert message$")
	public void alertappear() {
		Alert alert = driver.switchTo().alert();
		
	}*/
	
	  @Then ("^Switch to alert pop up and get the text of the alert$")
		  public void getalerttext() {
		  Alert alert = driver.switchTo().alert();
			  String alertMessage= driver.switchTo().alert().getText();
			  System.out.println("Alert message in the pop up is "  +alertMessage);
		  }
	  
	  @Then ("^Tap on Ok button to accept and close the alert pop up$")
	  public void acceptalert() throws InterruptedException {
		  
		  Thread.sleep(2000);
		  
		 driver.switchTo().alert().accept();
		 
		 driver.quit();
	  }
}

package com.quickee.screens;

import org.openqa.selenium.support.PageFactory;
import com.quickee.driver.SharedDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSFindBy;


public class LoginScreen extends SharedDriver{
	
	private enum page {Welecome_Back}
	
	private String autoTestEmailUsername = "shivani.gor@indianic.com";
	private String autoTestEmailPassword = "test123";
	
	private String autoTestEmailUsername1 = "test2222@gmail.com";
	private String autoTestEmailPassword1= "test123";
	
	
	@iOSFindBy(id="Back Icon")
	private MobileElement backButton;
	
	@iOSFindBy(xpath="//*[@value=\"Email\"]")	
	private MobileElement email;
	
	@iOSFindBy(xpath="//*[@value=\"Password\"]")	
	private MobileElement password;
	
	@iOSFindBy(id="Eye Icon")
	private MobileElement viewPassword;
	
	@iOSFindBy(id="Forgot your password?")
	private MobileElement forgotPassword;
	
	@iOSFindBy(id="btnSignInLoginWithEmail")
	private MobileElement signInButton;
	
	@iOSFindBy(id="Facebook")
	public MobileElement fbLink;
	
	@iOSFindBy(id="Phone Number")
	private MobileElement phoneNumberLink;
	
	@iOSFindBy(xpath="//*[@name=\"Welcome Back!\"]")
	private MobileElement WelcomeText;
	
	@iOSFindBy(xpath="//*[@name=\"or Sign In with\"]")
	private MobileElement OtherText;

	public LoginScreen() { PageFactory.initElements(new AppiumFieldDecorator(getAppiumDriver()), this);	}
	
	public MobileElement getBackButton(){ return backButton; }
	public MobileElement getEmailAddress(){ return email; }
	public MobileElement getPassword(){ return password; }
	public MobileElement getViewPassword(){ return viewPassword; }
	public MobileElement getForgotPassword(){ return forgotPassword; }
	public MobileElement getSignInButton(){ return signInButton; }
	public MobileElement getFacebookLink(){ return fbLink; }
	public MobileElement getPhoneNumberLink(){ return phoneNumberLink; }
	public MobileElement getWelcomeText(){ return WelcomeText; }
	public MobileElement getOtherText() { return OtherText; }
	
	public String getAutoTestEmailUsername(){ return autoTestEmailUsername; }
	public String getAutoTestEmailPassword(){ return autoTestEmailPassword; }
	public String getAutoTestInvalidEmailUsername() {return autoTestEmailUsername1 ;}
	public String getAutoTestInvalidEmailPassword(){ return autoTestEmailPassword1; }
	
	public void isLoginPageDisplayed(){
		
		isCorrectMessageDisplayed(WelcomeText, getPage(page.Welecome_Back.toString()));
	}
	
	public void enterEmail(String emailAddress){
		
		sendKeys(emailAddress, email); 
		
	}
	
	public void enterPassword(String emailPassword){
		
		sendKeys(emailPassword, password); 
		
	}
	
	public void enterInvalidEmail(String emailAddress) {
		
		sendKeys(emailAddress, email);
	}
	
public void enterInvalidPassword(String emailPassword){
		
		sendKeys(emailPassword, password); 
		
	}
	
	
	public void clickSignInButton(){ 
		
		click(signInButton); 
		
	}

}

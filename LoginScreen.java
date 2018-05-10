package Screens.ios;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Base.ScreenBase;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.iOSFindBy;


public class LoginScreen extends ScreenBase {
	
public LoginScreen(IOSDriver driver){
		
		super(driver);
	}

@iOSFindBy(id="Back Icon")
public	WebElement backButton;
	
//@iOSFindBy(xpath="//XCUIElementTypeApplication[@name=\"Quickee\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther/XCUIElementTypeTextField")
@iOSFindBy(xpath="//*[@value=\"Email\"]")	
public	WebElement email;
	
//@iOSFindBy(xpath="//XCUIElementTypeApplication[@name=\"Quickee\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther/XCUIElementTypeSecureTextField")
@iOSFindBy(xpath="//*[@value=\"Password\"]")	
public	WebElement password;
	
@iOSFindBy(id="Eye Icon")
	public WebElement viewPassword;
	
@iOSFindBy(id="Forgot your password?")
	public	WebElement forgotPassword;
	
@iOSFindBy(id="Sign In")
	public	WebElement signInButton;
	
@iOSFindBy(id="Facebook")
	public	WebElement fbLink;
	
@iOSFindBy(id="Phone Number")
	public	WebElement phoneNumberLink;
	
@iOSFindBy(xpath="//*[@name=\"Welcome Back!\"]")
	public	WebElement WelcomeText;
	
@iOSFindBy(xpath="//*[@name=\"or Sign In with\"]")
	public	WebElement OtherText;

	
	public LoginScreen LoginWithValidCredentials(String uname, String pass) throws InterruptedException{
	
		Thread.sleep(5000);
		
	email.sendKeys(uname);
	
	password.sendKeys(pass);
	
	signInButton.click();
	
	System.out.println("User logged in successfully with valid UserCredentials");
	
	return this;
	}
	
	public LoginScreen LoginWithInvalidCredentials(String uname, String pass) throws InterruptedException{

		Thread.sleep(5000);
		
	email.sendKeys(uname);
	
	password.sendKeys(pass);
	
	signInButton.click();
	
	System.out.println("Waiting for Dialogs");
	
    WebDriverWait wait = new WebDriverWait(driver, 10);
    try {
        wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();
        
        System.out.println("Tap on Ok");
        
    } catch (Exception e) {
        System.err.println("no alert visible after 10 sec.");
    }
		
		
		return this;
	}
	
}

package com.quickee.driver;



import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.Assert;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServerHasNotBeenStartedLocallyException;

public class SharedDriver {

    private SharedCapabilities sharedCapabilities = new SharedCapabilities();
    private DesiredCapabilities capabilities = sharedCapabilities.getDesiredCapabilities();
    private SharedProperties sharedProperties = new SharedProperties();
   // private AppiumDriverLocalService appiumDriverLocalService;
    public enum Direction {RIGHT, LEFT, DOWN, UP}
    public static AppiumDriver driver;
    public static URL serverUrl;
    
    public static Logger log= Logger.getLogger("devpinoyLogger");

    public AppiumDriver getAppiumDriver() {
        try {
            if (driver==null) {
                switch (sharedProperties.getPlatformName().toLowerCase()) {
                    case "android":
                        driver = new AndroidDriver(serverUrl, capabilities);
                        break;
                    case "ios":
					try {
						serverUrl = new URL("http://127.0.0.1:4723/wd/hub");
					} catch (MalformedURLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
                        driver = new IOSDriver(serverUrl, capabilities);
                        
                        log.debug("Server and Capabilities has been initialize successfully.");
                        break;
                    default:
                        throw new IllegalArgumentException(sharedProperties.getPlatformName() + "is unsupported");
                }
            }

        } catch (AppiumServerHasNotBeenStartedLocallyException e) {
                throw new AppiumServerHasNotBeenStartedLocallyException("Appium server not started" +e.getMessage());
        }
        return driver;
    }

    public void click(MobileElement element) {
        waitUntilClickable(element).click();
    }

    public void clear(MobileElement element) {
        try{
            waitUntilClickable(element).clear();
        } catch (WebDriverException e){
            if (!showOnlyNumbers(element).equals("0")) //"0" is empty inside refined search
                throw new WebDriverException("Text: "+element.getText()+ "- Unable to clear textfield");
        }
    }

    public void sendKeys (String value, MobileElement element) {
        waitUntilVisible(element).sendKeys(value);
    }
    public void sendKeysCheckNumber (String value, MobileElement element) {
       boolean sameText = showOnlyNumbers(element).equals(value);
        if (!sameText){
            sendKeysClearText(value, element);
        }
    }
    public void sendKeysClearText (String value, MobileElement element) {
        clear(element);
        sendKeys(value, element);
    }
 
    public Boolean isElementDisplayed(MobileElement element) {
        boolean displayed;
        try{
            displayed=element.isDisplayed();
        } catch (org.openqa.selenium.NoSuchElementException e){
            displayed=false;
        }
        return displayed;
    }
    public void isElementVisible (MobileElement element) {
        Assert.assertTrue("Element Not Visible", waitUntilVisible(element).isDisplayed());
    }


    public boolean isElementEnabled(MobileElement element){
        if (isiOSDevice()){
            return waitUntilClickable(element).getText().equals("1");
        }else{
            return waitUntilClickable(element).getText().endsWith("ON");
        }
    }
    public boolean isElementDisabled(MobileElement element){
        if (isiOSDevice()){
            return waitUntilClickable(element).getText().equals("0");
        }else {
            return waitUntilClickable(element).getText().endsWith("OFF");
        }
    }

    public void isElementNotVisible (MobileElement element) {
        Assert.assertFalse(waitUntilVisible(element).isDisplayed());
    }
    public void isElementTextEmpty(MobileElement element){
        Assert.assertFalse(element.getText().isEmpty());
    }

    public void isElementClickable (MobileElement element){
        Assert.assertTrue("Element Not Clickable",waitUntilClickable(element).isDisplayed());
    }
    public void closeKeyboard () {
        if (!isiOSDevice()){ //`
            try{
                driver.hideKeyboard();
            } catch (Exception e){
                e.printStackTrace();
            }
        }
    }
    
    public void navigateBack()
    {
    	driver.navigate().back();
    }

    public MobileElement waitUntilClickable (MobileElement element){
        try {
            return (MobileElement) fluentWait().until(ExpectedConditions.elementToBeClickable(element));
        } catch (org.openqa.selenium.NoSuchElementException e){
            throw new org.openqa.selenium.NoSuchElementException(element+" Element Not Clickable After Wait...\n"+ e.getMessage());
        }
    }
    public MobileElement waitUntilVisible (MobileElement element) {
        try {
            return (MobileElement) fluentWait().until(ExpectedConditions.visibilityOf(element));
        }catch (org.openqa.selenium.NoSuchElementException e){
            throw new org.openqa.selenium.NoSuchElementException(element+" Element Not Visible After Wait...\n"+ e.getMessage());
        }
    }
    public MobileElement waitUntilVisiblePerformance (MobileElement element) {
        try {
            return (MobileElement) fluentWaitPerformanceCheck().until(ExpectedConditions.visibilityOf(element));
        }catch (org.openqa.selenium.NoSuchElementException e){
            throw new org.openqa.selenium.NoSuchElementException(element+" Element Not Visible After Wait..."+ e.getMessage());
        }
    }

   
    public String showOnlyNumbers (MobileElement element) {
        String elementText = element.getText().replaceAll("[^0-9]", ""); //Takes out everything besides numbers
        return elementText;
    }

    public void isNumberDisplayed(MobileElement element) {
        //String elementText = element.getText().replaceAll("[^0-9]", ""); //Takes out everything besides numbers
        Assert.assertTrue("No Number Shown",showOnlyNumbers(element).matches("\\d+")); //Checks to see if numbers exist
    }

    public boolean elementContains (MobileElement element, String value) {
        // Replaces enter keys with space key
        return (waitUntilVisible(element).getText().replaceAll("\n", " ").toLowerCase().contains(value));
    }

    public void isCorrectMessageDisplayed (MobileElement element, String value) {
        try {
            Assert.assertTrue(elementContains(element, value));
        }catch (AssertionError e){
            throw new AssertionError("Expected: '"+value+"' Actual: '"+element.getText().replaceAll("\n", " ").toLowerCase()+"'");
        }
    }

    public String getPage (String page) {
        page = page.replaceAll("_", " ").toLowerCase();
        return page;
    }

    public void performanceCheck (String title, MobileElement firstElement, MobileElement secondElement){
        //waitUntilVisible(firstElement);
        long startTime = System.currentTimeMillis();
        waitUntilVisiblePerformance(secondElement);
        long endTime = System.currentTimeMillis();
        double loadTime = endTime-startTime;

        savePerformanceChecks(title,loadTime);
    }

    public void savePerformanceChecks(String performanceTitle ,double data) {
        File file = new File("performance.txt");
        try{
            if(!file.exists()){
                System.out.println("Created file");
                file.createNewFile();
            }
            PrintWriter out = new PrintWriter(new FileWriter(file, true));
            out.append(getTimeDate()+" - "+performanceTitle+": " + data +" - "+ sharedProperties.getPlatformName()+ "\n");
            out.close();
        }catch(IOException e){
            System.out.println("Unable to store performance results" + e);
        }

    }

    public Boolean isRealDevice () {return Boolean.parseBoolean(sharedProperties.getRealDevice());}
    public Boolean isiOSDevice () {return sharedProperties.getPlatformName().toLowerCase().equals("ios");}
    public Boolean isAndroidDevice () {return sharedProperties.getPlatformName().toLowerCase().equals("android");}
    public Boolean isiOSSimulator () {return isiOSDevice()&!isRealDevice();}
    public String getTimeDate() {
        return new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(Calendar.getInstance().getTime());
    }
    public String getDate() {
        return new SimpleDateFormat("yyyy/MM/dd").format(Calendar.getInstance().getTime());
    }

    public void swipe(Direction direction) {
        System.out.println("Swipe :" + direction);
        //x is left, y is up
        TouchAction swipe = new TouchAction(driver);
        Dimension size = driver.manage().window().getSize();
        int startx;
        int endx;
        int endy;
        int starty;

        switch (direction) {

            case DOWN:
                startx = size.width / 3;
                endx = size.width / 3;
                starty = (int) (size.height * 0.80);
                endy = size.height/2;
              if (isiOSDevice()){ endy = (int) (endy = size.height / 2 - size.height);}

                swipe.press(startx,starty).waitAction(2000).moveTo(endx,endy).release().perform();
                forceWait(1000);
                break;

            case RIGHT:
                startx = (int) (size.width * 0.9);
                endx = (int) (size.width * 0.20);
                starty = size.height / 2;
                endy = size.height / 2;
                if (isiOSDevice()){ endx = (int) (size.width * 0.20 - size.width);}

                swipe.press(startx,starty).waitAction(2000).moveTo(endx,endy).release().perform();
                forceWait(1000);
                break;

            case UP:
                startx = size.width / 3;
                endx = size.width / 3;
                starty = (int) (size.height * 0.30);
                endy = size.height / 2;

                swipe.press(startx,starty).waitAction(2000).moveTo(endx,endy).release().perform();
                forceWait(1000);
                break;

            case LEFT:
                startx = (int) (size.width * 0.20);
                endx = (int) (size.width * 0.8);
                starty = size.height / 2;
                endy = size.height / 2;

                swipe.press(startx,starty).waitAction(2000).moveTo(endx,endy).release().perform();
                forceWait(1000);
                break;
        }
    }
    public void swipeUntilElementDisplayed(MobileElement element, Direction direction){
        int count= 0;
        Boolean elementPresent = false;

        while (!elementPresent){
            try {
                if (element.isDisplayed()==false){ //iOS
                    swipe(direction);
                } else {
                    elementPresent = true;
                }
            } catch (org.openqa.selenium.NoSuchElementException e){ //Android
                swipe(direction);
            }
            count++;
            if (count>=15){
                throw new NoSuchElementException(element+" Not found after swiping "+count+" times");
            }
        }
    }
    public void swipeElement(MobileElement element, MobileElement element2) {
        //x is left, y is up
        TouchAction swipe = new TouchAction(driver);
        //Dimension size = driver.manage().window().getSize();
        int startx;
        int endx;
        int endy;
        int starty;

        int startY = element.getLocation().getY();
        int startX = element.getLocation().getX();

        int endX = element2.getLocation().getX() + (element2.getSize().getWidth() / 2);
        int endY = element2.getLocation().getY() + (element2.getSize().getHeight() / 2);

        swipe.press(startX, startY).waitAction(2000).moveTo(endX, endY).release().perform();

    }
    
public void MethodSwipeUp(int durations){
		
		Dimension	size = driver.manage().window().getSize();
		int height=size.getHeight();
		int width=size.getWidth();
		 int startx= width/2;
		int starty=(int)(height * 0.80);
		
		int endy=(int)(height *0.10);
		
		driver.swipe(startx, starty, startx, endy, durations);
		
	}

    public void forceWait(int milSeconds){
        try {
            Thread.sleep(milSeconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public FluentWait fluentWait (){
        return new FluentWait(driver)
                .withTimeout(15, TimeUnit.SECONDS) //Increased to 15s as Apply for cards sometimes takes longer to load
                .pollingEvery(1, TimeUnit.SECONDS)
                .ignoring(org.openqa.selenium.NoSuchElementException.class, ElementNotVisibleException.class)
                .ignoring(StaleElementReferenceException.class ,org.openqa.selenium.TimeoutException.class);
    }
    public FluentWait fluentWaitPerformanceCheck (){
        return new FluentWait(driver)
                .withTimeout(30, TimeUnit.SECONDS)
                .pollingEvery(1, TimeUnit.SECONDS)
                .ignoring(org.openqa.selenium.NoSuchElementException.class, ElementNotVisibleException.class)
                .ignoring(StaleElementReferenceException.class ,org.openqa.selenium.TimeoutException.class);
    }
    
    public void WaitforAlert(){
    	WebDriverWait wait = new WebDriverWait(driver, 10);
	    try {
	        wait.until(ExpectedConditions.alertIsPresent());
	        driver.switchTo().alert().accept();
	        
	        System.out.println("Tap on Ok");
	        
	    } catch (Exception e) {
	        System.err.println("no alert visible after 10 sec.");
	    }
    	
    }
   

}
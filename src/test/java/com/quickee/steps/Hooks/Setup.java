package com.quickee.steps.Hooks;

import org.testng.annotations.AfterMethod;
import java.io.IOException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import com.quickee.driver.SharedDriver;
import cucumber.api.Scenario;
import cucumber.api.java.After;

public class Setup extends SharedDriver{

    
    @After
	public static void tearDown(Scenario scenario) throws IOException{
		
		WebDriver driver = SharedDriver.driver;
		//System.out.println(scenario.isFailed());
		if(scenario.isFailed()){
			
			byte[] screenshotBytes = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			scenario.embed(screenshotBytes, "image/png");
			
		}
		
		driver = null;
	
		
	}


}

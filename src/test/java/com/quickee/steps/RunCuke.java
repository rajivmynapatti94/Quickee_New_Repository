package com.quickee.steps;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import com.cucumber.listener.ExtentCucumberFormatter;

import Utils.MonitoringMail;
import Utils.TestConfig;
import Utils.TestUtils;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(plugin = {"json:target/RunCuke/cucumber.json", "pretty", "html:target/RunCuke/cucumber.html","com.cucumber.listener.ExtentCucumberFormatter"},
		features="src/test/resources/FeatureFiles", monochrome=false,
		tags={"@LoginwithInValidUser"}
		)

public class RunCuke extends AbstractTestNGCucumberTests{
	
	@BeforeClass
    public static void setup() {
        // Initiates the extent report and generates the output in the output/Run_<unique timestamp>/report.html file by default.
		SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyy_hhmmss");
		Date curDate = new Date();
		String strDate = sdf.format(curDate);
		//String fileName = System.getProperty("user.dir")+"/target/Extent_Reports/"+ strDate+".html";
		
		String fileName = System.getProperty("user.dir")+"/target/Extent_Reports/extent.html";
		
		File newFile = new File(fileName);
		ExtentCucumberFormatter.initiateExtentCucumberFormatter(newFile,true);
		//static report name
		//ExtentCucumberFormatter.initiateExtentCucumberFormatter(new File(System.getProperty("user.dir")+"\\ExtenReports\\extentreports.html"),false);
        // Loads the extent config xml to customize on the report.
        ExtentCucumberFormatter.loadConfig(new File("src/test/resources/ExtentConfig/ReportsConfig.xml"));

        // User can add the system information as follows
        ExtentCucumberFormatter.addSystemInfo("Browser Name", "Chrome");
        ExtentCucumberFormatter.addSystemInfo("Browser version", "v65.0");
        ExtentCucumberFormatter.addSystemInfo("Selenium version", "v3.11.0");

        // Also you can add system information using a hash map
        Map systemInfo = new HashMap();
        systemInfo.put("Cucumber version", "v1.2.3");
        systemInfo.put("Extent Cucumber Reporter version", "v1.1.0");
        ExtentCucumberFormatter.addSystemInfo(systemInfo);
    }
	
	@AfterClass
	public void sendmail() throws AddressException, MessagingException{
		
		TestUtils.zip();
		
		MonitoringMail mail = new MonitoringMail();
		
		mail.sendMail(TestConfig.server, TestConfig.from, TestConfig.to, TestConfig.subject, TestConfig.messageBody, TestConfig.attachmentPath, TestConfig.attachmentName);
		
		
	}
	
}

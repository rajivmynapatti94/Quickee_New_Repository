package com.quickee.driver;



import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.ios.IOSDriver;

public class SharedProperties {

    private String platformName;
    private String automationName;
    private String platformVersion;
    private String deviceName;
    private String appPath;
    private String avd;
    private String realDevice;
    private String iOSUuid;
    private String iosBundleID;
    private String appium_server_port;
    private String androidPropertiesFile = "android.properties";
    private String iosPropertiesFile = "ios.properties";
    

    public SharedProperties() {getLocalPropertiesFile();}

    private void getLocalPropertiesFile () {
        try {
            FileInputStream fileInput = new FileInputStream(new File(iosPropertiesFile));
            Properties prop = new Properties();
            prop.load(fileInput);

            //Get properties from local properties file
            platformName = prop.getProperty("appium.platformName");
            automationName = prop.getProperty("appium.automationName");
            platformVersion = prop.getProperty("appium.platformVersion");
            deviceName = prop.getProperty("appium.deviceName");
            appPath = prop.getProperty("appium.appPath");
            avd = prop.getProperty("appium.avd");
            realDevice = prop.getProperty("appium.realDevice");
            iOSUuid = prop.getProperty("appium.iosUuid");
            iosBundleID = prop.getProperty("appium.iosBundleID");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public String getPlatformName() {return platformName;}
    public String getAutomationName() {return automationName;}
    public String getPlatformVersion() {return platformVersion;}
    public String getDeviceName() {return deviceName;}
    public String getAppPath() {return appPath;}
    public String getAvd() {return avd;}
    public String getRealDevice() {return realDevice;}
    public String getIosUuid() {return iOSUuid;}
    public String getIosBundleID() {return iosBundleID;}

    

}
package com.ecom.base;


import com.ecom.utility.Reusable;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.screenrecording.CanRecordScreen;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class Base {
    public static AndroidDriver driver;


    FileInputStream fis;
    Properties prop;
   protected static String dateTime;

    public Base() {

        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }


    public AndroidDriver setCapability() throws MalformedURLException {
        try {
            prop = new Properties();
            try {
                fis = new FileInputStream("./src/main/resources/Configuration/app.properties");
                prop.load(fis);
            } catch (IOException e) {
                e.printStackTrace();
            }
             dateTime= Reusable.getDateTime();
            DesiredCapabilities cap = new DesiredCapabilities();
            cap.setCapability(MobileCapabilityType.DEVICE_NAME, prop.getProperty("deviceName"));
            cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, prop.getProperty("automationName"));
            cap.setCapability("appPackage", prop.getProperty("appPackagePath"));
            cap.setCapability("appActivity", prop.getProperty("appActivityPath"));

            //cap.setCapability(MobileCapabilityType.APP, System.getProperty("user.dir") + prop.getProperty("apkPath"));
            URL url = new URL(prop.getProperty("appUrl"));
            driver = new AndroidDriver<MobileElement>(url, cap);
            driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return driver;
    }


   public AndroidDriver getDriver(){
        return driver;

    }

    public static String getDateTime(ITestResult result){

        DateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
        Date date=new Date();
        System.out.println(dateFormat.format(date));
        return dateFormat.format(date);
    }

    public void waitForVisibility(MobileElement ele){
        WebDriverWait wait=new WebDriverWait(driver,60);
        wait.until(ExpectedConditions.visibilityOf(ele));

    }


    public void clickOnElement(MobileElement ele){
        waitForVisibility(ele);
        ele.click();
    }

    public void getAttribute(MobileElement ele,String txt){
        waitForVisibility(ele);
        ele.getAttribute(txt);
    }
    //@Test
   public void launchApplcation() throws MalformedURLException {
       driver= setCapability();
    }


}

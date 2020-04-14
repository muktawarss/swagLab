package com.ecom.utility;

import com.ecom.base.Base;
import org.openqa.selenium.WebElement;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Reusable extends Base {
   public static String getDateTime(){

       DateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
       Date date=new Date();
       System.out.println(dateFormat.format(date));
      return dateFormat.format(date);
    }

    public static WebElement scrollToElement(String text) {
        return driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"" + text + "\"))");

    }


    public static WebElement specificElemetscrollandClick(String text) {
        return driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0))" +
                ".scrollIntoView(new UiSelector().textContains(\"" + text + " \").instance(0));");
    }
}

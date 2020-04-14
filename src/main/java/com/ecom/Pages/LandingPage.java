package com.ecom.Pages;

import com.ecom.base.Base;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidBy;


public class LandingPage extends Base {
    @AndroidBy(xpath = "//*[@text='Staging']")
    private MobileElement stagingBtn;
    @AndroidBy(xpath = "//*[@text='Mobile No']")
    private MobileElement txtBxMob;
    @AndroidBy(xpath = "//*[@text='REQUEST OTP']")
    private MobileElement btnRequestotp;


    public LandingPage()
    {
        super();
    }


    public HandleOtpPage pressStagingBtn() {
        //stagingBtn.click();
        clickOnElement(stagingBtn);
        return new HandleOtpPage();
    }

}

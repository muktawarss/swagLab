package com.ecom.Pages;

import com.ecom.base.Base;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class SettingPage extends Base {

    @AndroidFindBy(xpath = "//*[@text='LOGOUT']")
    private MobileElement logoutBtn;

    @AndroidFindBy(accessibility = "test-ABOUT")
    private MobileElement aboutBtn;


    public LoginPage clickLogoutBtn() {
        logoutBtn.click();
        return new LoginPage();
    }

   public SettingPage pressAboutBtn(){
        aboutBtn.click();
        return this;

    }

}

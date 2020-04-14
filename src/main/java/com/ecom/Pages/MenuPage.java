package com.ecom.Pages;

import com.ecom.base.Base;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

import java.util.List;

public class MenuPage extends Base {
    @AndroidFindBy(accessibility = "test-Menu")
    public MobileElement settingBtn;
    @AndroidFindBy(accessibility = "test-Modal Selector Button")
    private MobileElement filterBtn;

    public SettingPage clickSettingBtn() {
        settingBtn.click();
        return new SettingPage();
    }

    public FilterPage pressFilterBtn() {
        filterBtn.click();
        return new FilterPage();

    }

}

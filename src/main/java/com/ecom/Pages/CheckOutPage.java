package com.ecom.Pages;

import com.ecom.base.Base;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class CheckOutPage extends Base {
    @AndroidFindBy(accessibility = "test-First Name")
    private MobileElement firstnameTxtFld;
    @AndroidFindBy(accessibility = "test-Last Name")
    private MobileElement lastNameTxtFld;
    @AndroidFindBy(accessibility = "test-Zip/Postal Code")
    private MobileElement pinCodeTxtFld;
    @AndroidFindBy(accessibility = "test-CANCEL")
    private MobileElement cancelBtn;
    @AndroidFindBy(accessibility = "test-CONTINUE")
    private MobileElement continueBtn;
    @AndroidFindBy(xpath = "//*[@text='Shipping Information:']")
    private MobileElement text;


    public CheckOutPage enterfirstName(String fname) {
        firstnameTxtFld.sendKeys(fname);
        return this;
    }

    public CheckOutPage enterlastName(String lname) {
        lastNameTxtFld.sendKeys(lname);
        return this;
    }

    public CheckOutPage enterPincode(String pin) {
        pinCodeTxtFld.sendKeys(pin);
        return this;
    }

    public CheckOutPage pressContinueBtn() {
        continueBtn.click();
        return this;
    }

    public CheckOutPage pressCancelBtn() {
        cancelBtn.click();
        return this;
    }

    public boolean isTextDisplay() {
        return text.isDisplayed();
    }
}

package com.ecom.Pages;

import com.ecom.base.Base;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class LoginPage extends Base {
    @AndroidFindBy(xpath = "//*[@content-desc='test-Username']")
    private MobileElement txtUserName;
    @AndroidFindBy(xpath = "//*[@content-desc='test-Password']")
    private MobileElement txtPassword;
    @AndroidFindBy(xpath = "//*[@content-desc='test-LOGIN']")
    public MobileElement btnLogin;
    @AndroidFindBy(xpath = "//*[@text='Username and password do not match any user in this service.']")
    MobileElement errTxt;


    public LoginPage() {
        super();
    }


    public LoginPage setUsername(String username) {
        txtUserName.clear();

        txtUserName.sendKeys(username);
        return this;
    }

    public LoginPage setPassword(String password) {
        txtPassword.clear();
        txtPassword.sendKeys(password);
        return this;
    }

    public ProductPage clickBtnLogin() {

        clickOnElement(btnLogin);
        return new ProductPage();
    }


    public ProductPage login(String uname, String pass) {
        setUsername(uname);
        setPassword(pass);
        return clickBtnLogin();
    }

    public String getErrTxt() {
        return errTxt.getAttribute("name");


    }
}

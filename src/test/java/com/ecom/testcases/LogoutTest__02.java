package com.ecom.testcases;

import com.ecom.Pages.*;
import com.ecom.base.Base;
import com.ecom.utility.TestData;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.net.MalformedURLException;

public class LogoutTest__02 extends Base {

    LoginPage loginPage;
    ProductPage productPage;
    ProductDetailPage productDetailPage;
    SettingPage settingPage;
    MenuPage menuPage;
    TestData testdata;
    InputStream datais;
    JSONObject loginuser;

    @BeforeClass
    public void beforeClass() throws IOException {
        testdata = new TestData("testData/loginUser.json");
    }

    @BeforeMethod
    public void beforeMethod(Method m) throws MalformedURLException {
        System.out.println("\n" + "****starting test:" + m.getName() + "**********");
        driver = setCapability();
        loginPage = new LoginPage();
        productPage = new ProductPage();
        productDetailPage = new ProductDetailPage();
        menuPage = new MenuPage();
        settingPage = new SettingPage();
    }

    @Test
    public void loginWithValidCredentials() {
        loginPage.login(testdata.loginuser.getJSONObject("validUser").getString("username"),
                testdata.loginuser.getJSONObject("validUser").getString("password"));
        menuPage.clickSettingBtn();
        settingPage.clickLogoutBtn();

    }

    }




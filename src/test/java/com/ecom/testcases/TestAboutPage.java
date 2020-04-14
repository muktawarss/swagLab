package com.ecom.testcases;

import com.ecom.Pages.*;
import com.ecom.base.Base;
import com.ecom.utility.ContextHandles;
import com.ecom.utility.TestData;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.util.Set;

public class TestAboutPage extends Base {
    LoginPage loginPage;
    MenuPage menuPage;
    ProductPage productPage;
    TestData testdata;
    FilterPage filterPage;
    SettingPage settingPage;
//    ContextHandles contextHandles;

    @BeforeClass
    public void beforeClase() throws IOException {
        testdata = new TestData("testData/loginUser.json");
    }

    @BeforeMethod
    public void beforeMethod(Method m) throws MalformedURLException {
        System.out.println("\n" + "****starting test:" + m.getName() + "**********");
        driver = setCapability();
        loginPage = new LoginPage();
        menuPage = new MenuPage();
        productPage=new ProductPage();
        filterPage = new FilterPage();
        settingPage=new SettingPage();



    }

    @Test
    public void addCartTest() {
        loginPage.login(testdata.loginuser.getJSONObject("validUser").getString("username"),
                testdata.loginuser.getJSONObject("validUser").getString("password"));
        menuPage.clickSettingBtn();
        settingPage.pressAboutBtn();
    Set<String> contextHandles=  driver.getContextHandles();

        for (String context:
             contextHandles) {
            System.out.println("ContextHandle >>"+context);
        }
   driver.context("WEBVIEW_com.swaglabsmobileapp");

        System.out.println(driver.getTitle());
        Assert.assertNotNull(driver.getTitle());





    }
}

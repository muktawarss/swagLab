package com.ecom.testcases;

import com.ecom.Pages.*;
import com.ecom.base.Base;
import com.ecom.utility.TestData;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.net.MalformedURLException;

public class FilterTest extends Base {
    LoginPage loginPage;
    MenuPage menuPage;
    TestData testdata;
    FilterPage filterPage;

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
        filterPage = new FilterPage();

    }

    @Test
    public void addCartTest() {
        loginPage.login(testdata.loginuser.getJSONObject("validUser").getString("username"),
                testdata.loginuser.getJSONObject("validUser").getString("password"));
        menuPage.pressFilterBtn();
        filterPage.getProductNamesorByZ_A();
        Assert.assertTrue(filterPage.isProductsorted());

    }
}
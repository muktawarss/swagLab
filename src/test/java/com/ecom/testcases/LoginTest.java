package com.ecom.testcases;

import com.ecom.Pages.LoginPage;
import com.ecom.Pages.MenuPage;
import com.ecom.Pages.ProductPage;
import com.ecom.Pages.SettingPage;
import com.ecom.base.Base;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.*;
import java.lang.reflect.Method;
import java.net.MalformedURLException;

public class LoginTest extends Base {
    LoginPage loginPage;
    ProductPage productPage;
    InputStream datais;
    JSONObject loginuser;

    @BeforeClass
    public void beforeClase() throws IOException {
        try {
            String dataFileName = "testData/loginUser.json";
            datais = getClass().getClassLoader().getResourceAsStream(dataFileName);
            JSONTokener tokener = new JSONTokener(datais);
            loginuser = new JSONObject(tokener);
        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            if (datais != null) {
                datais.close();
            }
        }
    }

    @BeforeMethod
    public void beforeMethod(Method m) throws MalformedURLException {
        System.out.println("\n" + "****starting test:" + m.getName() + "**********");
        driver = setCapability();
        loginPage = new LoginPage();
        productPage = new ProductPage();

    }

    @Test(priority = 1)
    public void loginWitnInvalidCredentials() {
        loginPage.setUsername(loginuser.getJSONObject("invalidUser").getString("username"));
        loginPage.setPassword(loginuser.getJSONObject("invalidUser").getString("password"));
        loginPage.clickBtnLogin();
        //System.out.println("Error Text>>"+loginPage.getErrTxt());
        Assert.assertEquals(loginPage.getErrTxt(), "Username and password do not match any user in this service.");

    }

    @Test(priority = 2)
    public void loginWithValidCredentials() {
        loginPage.setUsername(loginuser.getJSONObject("validUser").getString("username"));
        loginPage.setPassword(loginuser.getJSONObject("validUser").getString("password"));
        loginPage.clickBtnLogin();
        System.out.println(productPage.getTitle());
        Assert.assertTrue(productPage.getTitle().contains("PRODUCTS"));


    }

    @BeforeMethod
    public void afterMethod() {


    }


}

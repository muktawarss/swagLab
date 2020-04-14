package com.ecom.testcases;

import com.ecom.Pages.*;
import com.ecom.base.Base;
import com.ecom.utility.Reusable;
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

public class LogoutTest extends Base {

    LoginPage loginPage;
    ProductPage productPage;
    ProductDetailPage productDetailPage;
    SettingPage settingPage;
    MenuPage menuPage;
    InputStream datais;
    JSONObject loginuser;

    @BeforeClass
    public void beforeClass() throws IOException {
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
        productDetailPage = new ProductDetailPage();
        menuPage = new MenuPage();
        settingPage = new SettingPage();
    }

    @Test(priority = 1)
    public void loginWithValidCredentials() {
        /*loginPage.setUsername(loginuser.getJSONObject("validUser").getString("username"));
        loginPage.setPassword(loginuser.getJSONObject("validUser").getString("password"));
        loginPage.clickBtnLogin();
        menuPage.clickSettingBtn();
        settingPage.clickLogoutBtn();
*/
        loginPage.login(loginuser.getJSONObject("validUser").getString("username"),
                loginuser.getJSONObject("validUser").getString("password"));
        waitForVisibility(menuPage.settingBtn);
        menuPage.clickSettingBtn();
        settingPage.clickLogoutBtn();
        Assert.assertTrue(loginPage.btnLogin.isDisplayed(), "user unable to logout");
        System.out.println("user successfully logged out");



    }

    @BeforeMethod
    public void afterMethod() {


    }


}

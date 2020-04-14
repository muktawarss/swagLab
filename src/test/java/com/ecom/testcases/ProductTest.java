package com.ecom.testcases;

import com.ecom.Pages.LoginPage;
import com.ecom.Pages.ProductDetailPage;
import com.ecom.Pages.ProductPage;
import com.ecom.base.Base;
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

public class ProductTest extends Base {

    LoginPage loginPage;
    ProductPage productPage;
    ProductDetailPage productDetailPage;
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
    }

    @Test(priority = 1)
    public void loginWithValidCredentials() {
        loginPage.setUsername(loginuser.getJSONObject("validUser").getString("username"));
        loginPage.setPassword(loginuser.getJSONObject("validUser").getString("password"));
        loginPage.clickBtnLogin();
        //System.out.println("Price :>>" + productPage.getSLBPrice());
        String price = productPage.getSLBPrice();
        price = price.substring(1);
        double product_price = Double.parseDouble(price);
        Assert.assertEquals(product_price, 29.99);
        //System.out.println("Title:>>" + productPage.getSLBTitle());
        Assert.assertTrue(productPage.getSLBTitle().contains("Sauce Labs Backpack"));
        productPage.pressSLBTitle();
        productDetailPage.backBtn();



    }

    @BeforeMethod
    public void afterMethod() {


    }


}

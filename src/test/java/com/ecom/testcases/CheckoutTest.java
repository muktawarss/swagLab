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

public class CheckoutTest extends Base {
    LoginPage loginPage;
    ProductPage productPage;
    ProductDetailPage productDetailPage;
    AddToCartPage addToCartPage;
    CheckOutPage checkOutPage;
    InputStream datais;
    JSONObject loginuser;
    TestData testdata;

    @BeforeClass
    public void beforeClase() throws IOException {
        testdata = new TestData("testData/loginUser.json");
    }

    @BeforeMethod
    public void beforeMethod(Method m) throws MalformedURLException {
        System.out.println("\n" + "****starting test:" + m.getName() + "**********");
        driver = setCapability();
        loginPage = new LoginPage();
        productPage = new ProductPage();
        productDetailPage = new ProductDetailPage();
        addToCartPage = new AddToCartPage();
        checkOutPage = new CheckOutPage();

    }

    @Test
    public void addCartTest() {
        loginPage.login(testdata.loginuser.getJSONObject("validUser").getString("username"),
                testdata.loginuser.getJSONObject("validUser").getString("password"));
        productPage.getScrollToProduct();
        productDetailPage.pressAddToCart();
        productPage.pressCartBtn();
        addToCartPage.pressCheckoutBtn();
        checkOutPage.enterfirstName(testdata.loginuser.getJSONObject("userDetails").getString("firstname"));
        checkOutPage.enterlastName(testdata.loginuser.getJSONObject("userDetails").getString("lastname"));
        checkOutPage.enterPincode(testdata.loginuser.getJSONObject("userDetails").getString("pincode"));
        checkOutPage.pressContinueBtn();
        Assert.assertTrue(checkOutPage.isTextDisplay());

    }

}

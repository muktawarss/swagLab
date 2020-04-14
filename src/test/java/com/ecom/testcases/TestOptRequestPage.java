package com.ecom.testcases;

import com.ecom.Pages.LandingPage;
import com.ecom.base.Base;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

public class TestOptRequestPage extends Base {
    LandingPage landingPage;


    @BeforeClass
    public void beforeClass() throws MalformedURLException {
       driver= setCapability();
        landingPage=new LandingPage();

    }
    @Test
    public void testHandleOpt() throws InterruptedException {
        Thread.sleep(6000);
        landingPage.pressStagingBtn();
    }
}

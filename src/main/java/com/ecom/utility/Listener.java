package com.ecom.utility;

import com.ecom.base.Base;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.*;

public class Listener implements ITestListener {

    Base base= new Base();

    public void onTestStart(ITestResult result) {


    }

    public void onTestSuccess(ITestResult result) {
        System.out.println("******successfully executed:" + result.getName() + "*******");

    }

    public void onTestFailure(ITestResult result) {
        if (result.getThrowable() != null) {
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            result.getThrowable().printStackTrace(pw);
            System.out.println(sw.toString());
        }


        File src = base.getDriver().getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(src, new File("./Screenshot/" + base.getDateTime(result) + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void onTestSkipped(ITestResult iTestResult) {

    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    public void onStart(ITestContext iTestContext) {

    }

    @Override
    public void onFinish(ITestContext iTestContext) {

    }

    public void onFinish(ITestResult result) throws FileNotFoundException {

         }
}

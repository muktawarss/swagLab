package com.ecom.utility;

import com.ecom.base.Base;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.Dimension;

import java.awt.*;

public class ScrollUsingTouchAction extends Base {

    public static void scrollingUsingTouch(String direction, MobileElement ele) {

        Dimension dm = driver.manage().window().getSize();
        int x = dm.getWidth() / 2;
        int startY = 0;
        int endY = 0;

        switch (direction) {

            case "up":
                startY = (int) (dm.getHeight() * 0.8);
                endY = (int) (dm.getHeight() * 0.2);
                break;

            case "down":
                startY = (int) (dm.getHeight() * 0.2);
                endY = (int) (dm.getHeight() * 0.8);
                break;


        }


    }

}

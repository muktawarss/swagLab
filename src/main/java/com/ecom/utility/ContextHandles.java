package com.ecom.utility;

import com.ecom.base.Base;

import java.util.Set;

public class ContextHandles extends Base {
    public ContextHandles() {

        Set<String> contextNames = driver.getContextHandles();
        for (String contextName : contextNames) {
            System.out.println(contextName); //prints out something like NATIVE_APP \n WEBVIEW_1
        }
        driver.context((String) contextNames.toArray()[1]); // set context to WEBVIEW_1

    }
}

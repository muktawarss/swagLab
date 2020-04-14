package com.ecom.Pages;

import com.ecom.base.Base;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class AddToCartPage extends Base {

    @AndroidFindBy(accessibility = "test-CHECKOUT")
    private MobileElement checkOutBtn;
    @AndroidFindBy(accessibility = "test-CONTINUE SHOPPING")
    private MobileElement continueShoppingBtn;
    @AndroidFindBy(accessibility = "test-REMOVE")
    private MobileElement removeBtn;
    ;
    @AndroidFindBy(accessibility = "test-Description")
    private MobileElement productDesciption;


    public CheckOutPage pressCheckoutBtn() {
        checkOutBtn.click();
        return new CheckOutPage();
    }

    public ProductPage pressContinuewithShoppingBtn() {
        continueShoppingBtn.click();
        return new ProductPage();

    }

    public AddToCartPage removeProductfromCart() {
        removeBtn.click();
        return this;
    }


    public AddToCartPage getProductDescription() {
        productDesciption.getText();
        return new AddToCartPage();
    }

}


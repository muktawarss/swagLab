package com.ecom.Pages;

import com.ecom.base.Base;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

import java.util.List;

public class FilterPage extends Base {
    @AndroidFindBy(xpath = "//*[@text='Name (A to Z)']")
    private MobileElement sortByA_Z;
    @AndroidFindBy(xpath = "//*[@text='Name (Z to A)']")
    private MobileElement sortByZ_A;
    @AndroidFindBy(xpath = "//*[@text='Price (low to high)']")
    private MobileElement sortByPricelow_high;
    @AndroidFindBy(xpath = "//*[@text='Price (high to low)']")
    private MobileElement sortByhigh_lowPrice;
    @AndroidFindBy(accessibility = "test-Item title")
    private List<MobileElement> itemList;




    public ProductPage getProductNamesorByZ_A() {
        sortByZ_A.click();
        return new ProductPage();

    }

    public ProductPage getProductByPrice(){
        sortByhigh_lowPrice.click();
        return new ProductPage();
    }

    public boolean isProductsorted(){
        return itemList.get(0).isDisplayed();
    }
}

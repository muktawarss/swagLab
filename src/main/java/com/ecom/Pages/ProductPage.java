package com.ecom.Pages;

import com.ecom.base.Base;
import com.ecom.utility.Reusable;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class ProductPage extends Base {
    @AndroidFindBy(xpath = "//*[@text='PRODUCTS']")
    private MobileElement getTitle;

    @AndroidFindBy(xpath = "//*[@text='Sauce Labs Backpack']")
    private MobileElement SLBTitle;
    @AndroidFindBy(xpath = "//*[@content-desc='test-Price']")
    private MobileElement SLBPrice;
    @AndroidFindBy(accessibility = "test-Cart")
    private MobileElement cartBtn;

    public ProductPage() {

        super();
    }

    public String getTitle() {
        return getTitle.getText();
    }

    public String getSLBTitle() {
        return SLBTitle.getText();

    }


    public String getSLBPrice() {
        return SLBPrice.getText();
    }

    public ProductDetailPage pressSLBTitle() {
        SLBTitle.click();
        return new ProductDetailPage();
    }

    public ProductDetailPage getScrollToProduct() {
        Reusable.scrollToElement("Sauce Labs Onesie").click();
        return new ProductDetailPage();
    }

    public AddToCartPage pressCartBtn() {
        cartBtn.click();
        return new AddToCartPage();

    }

}

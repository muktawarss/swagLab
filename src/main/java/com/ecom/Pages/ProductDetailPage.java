package com.ecom.Pages;

import com.ecom.base.Base;
import com.ecom.utility.Reusable;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.testng.annotations.AfterMethod;

import java.util.List;

public class ProductDetailPage extends Base {
    @AndroidFindBy(xpath = "//*[@text='Sauce Labs Backpack']")
    private MobileElement productDetailTitle;
    @AndroidFindBy(xpath = "//*[@content-desc='test-BACK TO PRODUCTS']")
    private MobileElement productBackBtn;

    @AndroidFindBy(accessibility = "test-Item title")
    List<MobileElement> productlist;

    @AndroidFindBy(accessibility = "test-ADD TO CART")
    private MobileElement addToCartBtn;


    public ProductDetailPage() {

        super();
    }

    public String getTitleOfProduct() {
        return productDetailTitle.getText();
    }

    public ProductPage backBtn() {
        productBackBtn.click();
        return new ProductPage();
    }

    public List<MobileElement> getProductlist() {
        return productlist;

    }

    public AddToCartPage pressAddToCart() {

        Reusable.scrollToElement("ADD TO CART").click();
        return new AddToCartPage();
    }
}

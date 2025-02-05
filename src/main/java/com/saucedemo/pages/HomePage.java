package com.saucedemo.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class HomePage {

    Page page;

// Locator — — — -

    String productName_1 ="id=item_4_title_link";
    String cartIcon="//a[@data-test='shopping-cart-link']";

//initialize Page using constructor

    public HomePage(Page page) {

        this.page =page;}

//Method

    public String getProductName() {

        String productName = page.textContent(productName_1);

        return productName;}

    public  void addProductCart(String product_Name){

        String xpath = "//div[text()='" + product_Name + "']/ancestor::div[@class='inventory_item']//button";
        Locator addCary = page.locator(xpath);
        addCary.click();


    }


    public void clickCartIcon() {
        page.click(cartIcon);
    }
}



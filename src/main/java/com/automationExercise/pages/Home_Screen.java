package com.automationExercise.pages;

import com.microsoft.playwright.Page;

public class Home_Screen {

    Page page;
    String feature_items ="//div[@class='features_items']";
    String nav_bar="//div[contains(@class,'shop-menu pull-right')]";
    String login_Btn="//ul[@class='nav navbar-nav']/descendant::a[contains(.,'Login')]";

    public Home_Screen(Page page) {
        this.page = page;
    }



    public boolean verifyHomePageIsVisible(){

       return page.locator(feature_items).isVisible();

    }

    public boolean verifyNavBarIsVisible(){

        return page.locator(nav_bar).isVisible();

    }


    public void clickOnSignUpLogin(){
        page.locator(login_Btn).click();

    }


}

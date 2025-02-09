package com.nopCommerce.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class Register_Page {

    Page page;

    public Register_Page(Page page) {
        this.page = page;
    }

    public Register_Page maleGender() {
        page.locator("#gender-male").click();
        return this;


    }

    public Register_Page enterFirstName(){
        page.locator("#FirstName").fill("Hussam");
        return this;

    }

    public Register_Page lastName(){
        page.locator("#LastName").fill("Abd El Fattah");

        return this;
    }

    public Register_Page email(){
        page.locator("#Email").fill("user" + (int)(Math.random() * 10000) + "@example.com");
        return this;

    }


    public Register_Page selectDay(){

        Locator day = page.locator("//select[@name='DateOfBirthDay']");
        day.selectOption("3");
        return this;
    }

}

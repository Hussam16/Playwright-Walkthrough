package com.automationExercise.pages;

import com.microsoft.playwright.Page;

public class SignUp_Screen {

    Page page;

    String title="//div[@class='signup-form']/h2";
    String submitButton="//button[@data-qa='signup-button']";

    String enterAccTitle="//*[text()='Enter Account Information']";



    public SignUp_Screen(Page page) {
        this.page = page;
    }

    public  boolean validateSignUpTitleVisible(){

        return page.locator(title).isVisible();

    }

    public void enterUserName(String string){

        page.getByPlaceholder("Name").fill(string);

    }

    public void enterPassword(String string){

        page.locator("//input[@data-qa='signup-email']").fill(string);

    }

    public void clickSubmit(){

        page.locator(submitButton).click();

    }

    public boolean enterAccTitleVisible(){

        return page.locator(enterAccTitle).isVisible();

    }




}

package com.automationExercise.pages;

import com.microsoft.playwright.Page;

public class SignUp_Screen {

    Page page;

    String title = "//div[@class='signup-form']/h2";
    String submitButton = "//button[@data-qa='signup-button']";
    String enterAccTitle = "//*[text()='Enter Account Information']";


    public SignUp_Screen(Page page) {
        this.page = page;
    }

    public boolean validateSignUpTitleVisible() {

        return page.locator(title).isVisible();

    }

    public void enterUserName(String string) {

        page.getByPlaceholder("Name").fill(string);

    }

    public void enterPassword(String string) {

        page.locator("//input[@data-qa='signup-email']").fill(string);

    }

    public void clickSubmit() {

        page.locator(submitButton).click();

    }

    public boolean enterAccTitleVisible() {

        return page.locator(enterAccTitle).isVisible();

    }

    public SignUp_Screen clickMaleGender() {

        page.locator("#id_gender1").click();
        return this;
    }


    public SignUp_Screen enterAccountPassword(String s) {

        page.locator("#password").fill(s);

        return this;

    }

    public SignUp_Screen clickNewSettler() {
        page.locator("#newsletter").click();

        return this;

    }

    public SignUp_Screen clickLatestOffers() {
        page.locator("#optin").click();

        return this;

    }


    public SignUp_Screen enterFirstName(String hussam) {
        page.locator("#first_name").fill(hussam);
        return this;


    }

    public SignUp_Screen enterLastName(String abdElFattah) {

        page.locator("#last_name").fill(abdElFattah);
        return this;

    }

    public SignUp_Screen enterAddress() {

        page.locator("#address1").fill("21 Emtedad Ramsis 1");

        return this;
    }


    public SignUp_Screen selectCountry() {

        page.locator("#country").selectOption("Israel");

        return this;
    }

    public SignUp_Screen enterState() {
        page.locator("#state").fill("Randomdata");
        return this;

    }

    public SignUp_Screen enterCity() {
        page.locator("#city").fill("Randomdata");
        return this;

    }

    public SignUp_Screen enterZipcode() {
        page.locator("#zipcode").fill("238477");
        return this;
    }

    public SignUp_Screen enterMobile() {
        page.locator("#mobile_number").fill("01063113894");
        return this;
    }

    public void clickCreateAccountBtn() {
        page.locator("//button[@data-qa='create-account']").click();
    }

    public boolean isAccountCreatedVisible() {
        return page.locator("//h2[@data-qa='account-created']/b").isVisible();

    }
}

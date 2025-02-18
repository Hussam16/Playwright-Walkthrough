package com.automationExercise.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

import java.nio.file.Paths;

public class ContactUs_Screen {

    public ContactUs_Screen(Page page) {
        this.page = page;
    }

    Page page;


    public boolean getInTouchMessage() {

        return page.locator("//div[contains(@class,'contact-form')]/descendant::h2[@class='title text-center']").isVisible();
    }

    public void enterFormData(String username, String alreadyExistEmail, String alreadyExistEmail1, String alreadyExistEmail2) {

        page.locator("//input[@data-qa='name']").fill(username);
        page.locator("//input[@data-qa='email']").fill(alreadyExistEmail);
        page.locator("//input[@data-qa='subject']").fill(alreadyExistEmail1);
        page.locator("//textarea[@data-qa='message']").fill(alreadyExistEmail2);
    }

    public void uploadFile() {
        Locator chooseFileButton = page.locator("//input[@name='upload_file']");
        chooseFileButton.setInputFiles(Paths.get("src/test/resources/userData.json"));

    }

    public void clickSubmitButton() {
        page.locator("//input[@name='submit']").click();
        page.locator("//input[@name='submit']").click();
    }

    public boolean sucessMessage() {

        return page.locator("//div[@class='status alert alert-success']").isVisible();
    }

    public void clickHome() {
        page.locator("//a[@class='btn btn-success']").click();
    }
}

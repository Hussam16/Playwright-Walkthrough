package stepdefinitions;

import com.automationExercise.pages.Home_Screen;
import com.automationExercise.pages.SignUp_Screen;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class Automation_Excersie_StepDef {

    Playwright playwright = Playwright.create();
    Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(10));
    Page page = browser.newPage();
    Home_Screen homeScreen;
    SignUp_Screen signUpScreen;


    @Given("I open the browser and go to BaseUrl")
    public void iOpenTheBrowserAndGoToBaseUrl() {
        page.navigate("https://automationexercise.com/");
        homeScreen = new Home_Screen(page);
        signUpScreen= new SignUp_Screen(page);


        Assert.assertTrue("Not Visible", homeScreen.verifyHomePageIsVisible());
        Assert.assertTrue("Not Visible", homeScreen.verifyNavBarIsVisible());


    }

    @When("I click on {string}")
    public void iClickOn(String arg0) {
        homeScreen.clickOnSignUpLogin();
    }

    @Then("I should see ENTER ACCOUNT INFORMATION")
    public void iShouldSee() {

        Assert.assertTrue(signUpScreen.enterAccTitleVisible());
    }

    @When("I enter a name and email, then click {string}")
    public void iEnterANameAndEmailThenClick(String arg0) {
        signUpScreen.enterUserName(String.valueOf(System.currentTimeMillis())+"userName");
        signUpScreen.enterPassword(String.valueOf(System.currentTimeMillis())+"@xyz.com");
        signUpScreen.clickSubmit();

    }

    @When("I fill in the account and address details")
    public void iFillInTheAccountAndAddressDetails() {
    }

    @And("I select the newsletter and offers checkboxes")
    public void iSelectTheNewsletterAndOffersCheckboxes() {
    }

    @And("I click {string}")
    public void iClick(String arg0) {
    }

    @Then("I should see New User Signup!")
    public void iShouldSeeNewUserSignup() {
        Assert.assertTrue(signUpScreen.validateSignUpTitleVisible());
    }
}

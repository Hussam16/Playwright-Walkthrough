package stepdefinitions;

import com.automation.Exersicse.Api.CreateUserAPI;
import com.automationExercise.pages.ContactUs_Screen;
import com.automationExercise.pages.Home_Screen;
import com.automationExercise.pages.Login_Screen;
import com.automationExercise.pages.SignUp_Screen;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.AriaRole;
import com.utilites.JsonReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.json.JSONObject;
import org.junit.Assert;

public class Automation_Excersie_StepDef {

    Playwright playwright = Playwright.create();
          Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(1000));
  //  Browser browser = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(true));
    Page page = browser.newPage();
    Home_Screen homeScreen;
    SignUp_Screen signUpScreen;
    CreateUserAPI createUserAPI;
    Login_Screen loginScreen;
    ContactUs_Screen contactUsScreen;
    JSONObject testData;

    String email_user = String.valueOf(System.currentTimeMillis()) + "@hotmail.com";


    @Given("I open the browser and go to BaseUrl")
    public void iOpenTheBrowserAndGoToBaseUrl() {
        page.navigate("https://automationexercise.com/");
        homeScreen = new Home_Screen(page);
        signUpScreen = new SignUp_Screen(page);
        createUserAPI = new CreateUserAPI(page);
        loginScreen = new Login_Screen(page);
        contactUsScreen = new ContactUs_Screen(page);

        testData = JsonReader.readJsonFile("C:\\Users\\workstation\\IdeaProjects\\PlaywrightJave\\src\\test\\resources\\userData.json");


        createUserAPI.registerUserThroughApi(email_user);
        Assert.assertEquals(200, createUserAPI.validateResponseCode());
        Assert.assertEquals("{\"responseCode\": 201, \"message\": \"User created!\"}", createUserAPI.validateResponseMessage());


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
        signUpScreen.enterUserName(String.valueOf(System.currentTimeMillis()) + "userName");
        signUpScreen.enterPassword(String.valueOf(System.currentTimeMillis()) + "@xyz.com");
        signUpScreen.clickSubmit();

    }

    @When("I fill in the account and address details")
    public void iFillInTheAccountAndAddressDetails() {
        signUpScreen
                .clickMaleGender()
                .enterAccountPassword(String.valueOf(System.currentTimeMillis()) + "Asd123@@")
                .enterFirstName("Hussam").
                enterLastName("Abd EL Fattah")
                .enterAddress()
                .selectCountry()
                .enterState()
                .enterCity()
                .enterZipcode()
                .enterMobile();

    }

    @And("I select the newsletter and offers checkboxes")
    public void iSelectTheNewsletterAndOffersCheckboxes() {
        signUpScreen
                .clickNewSettler()
                .clickLatestOffers();
    }

    @And("I click {string}")
    public void iClick(String arg0) {
        signUpScreen.clickCreateAccountBtn();

    }

    @Then("I should see New User Signup!")
    public void iShouldSeeNewUserSignup() {
        Assert.assertTrue(signUpScreen.validateSignUpTitleVisible());
    }

    @Then("I should see ACCOUNT CREATED!")
    public void iShouldSeeACCOUNTCREATED() {
        Assert.assertTrue(signUpScreen.isAccountCreatedVisible());
    }

    @When("I click Continue")
    public void iClickContinue() {
        page.locator("//a[@data-qa='continue-button']").click();
    }

    @Then("I should see {string}")
    public void iShouldSee(String arg0) {
        Assert.assertTrue(page.locator("//a[contains(.,'Logged in as')]").isVisible());
    }

    @When("I click Delete Account")
    public void iClickDeleteAccount() {
        page.locator("//a[.=' Delete Account']").click();
    }

    @Then("I should see ACCOUNT DELETED!")
    public void iShouldSeeACCOUNTDELETED() {
        Assert.assertTrue(page.locator("//h2[@data-qa='account-deleted']/b").isVisible());
    }

    @And("I click Continue Button")
    public void iClickContinueButton() {
        page.locator("//a[.='Continue']").click();
    }


    @Then("I should see Login to your account is visible")
    public void iShouldSeeLoginToYourAccountIsVisible() {

        Assert.assertTrue(loginScreen.validateLoginToAccountVisible());

    }

    @And("Enter correct email address and password")
    public void enterCorrectEmailAddressAndPassword() {
        loginScreen.enterEmail(email_user);
        System.out.print(email_user);
        loginScreen.enterPassword();

    }

    @And("Click login button")
    public void clickLoginButton() {
        loginScreen.clickLoginButton();
    }

    @And("Enter incorrect email address and password")
    public void enterIncorrectEmailAddressAndPassword() {
        loginScreen.enterEmail(testData.getString("username"));
        loginScreen.enterPassword();

    }

    @Then("I should see  error {string} is visible")
    public void iShouldSeeErrorYourEmailOrPasswordIsIncorrectIsVisible(String args) {

        Assert.assertEquals(testData.getString("message"), loginScreen.validateIncorrectMsg());
    }

    @When("I Click Logout Button")
    public void iClickLogoutButton() {

        homeScreen.clickLogoutButton();

    }

    @Then("I should see The Login Screen")
    public void iShouldSeeTheLoginScreen() {

        Assert.assertTrue(signUpScreen.signupTitle());
    }

    @When("I enter name & already registered email address")
    public void iEnterNameAlreadyRegisteredEmailAddress() {


        signUpScreen.enterUserName(String.valueOf(System.currentTimeMillis()) + "userName");
        signUpScreen.enterPassword(testData.getString("already_Exist_email"));
    }

    @And("Click Sign up button")
    public void clickSignUpButton() {
        signUpScreen.clickSubmit();
    }

    @Then("I should see error message Email Address Already Exist")
    public void iShouldSeeErrorMessageEmailAddressAlreadyExist() {
        Assert.assertEquals(testData.getString("already_Exist_message"), signUpScreen.getErrorMessageContent());

    }

    @When("Click Contact Us Button")
    public void clickContactUsButton() {
        homeScreen.clickContactUs();
    }

    @Then("Get IN Touch Is Vislible")
    public void getINTouchIsVislible() {

        Assert.assertTrue(testData.getString("contactUs_message"), contactUsScreen.getInTouchMessage());
    }

    @When("Enter Name ,Email ,Subject and Message")
    public void enterNameEmailSubjectAndMessage() {
        contactUsScreen
                .enterFormData(testData.getString("username"), testData.getString("already_Exist_email"), testData.getString("already_Exist_email"), testData.getString("already_Exist_email"));
    }

    @And("Upload File")
    public void uploadFile() {
        contactUsScreen.uploadFile();
    }

    @And("Click Submit Button")
    public void clickSubmitButton() {
        contactUsScreen.clickSubmitButton();
    }

    @And("Click Ok Button")
    public void clickOkButton() {
        page.onceDialog(dialog -> {
            System.out.println("Alert Message: " + dialog.message()); // Debugging
            dialog.accept(); // Click "OK"
        });
    }

    @Then("Success message 's Visible")
    public void successMessageSVisible() {
        Assert.assertTrue(contactUsScreen.sucessMessage());
    }

    @And("Click Continue Button")
    public void clickContinueButton() {
        contactUsScreen.clickHome();
    }

    @When("Click Testcases Button")
    public void clickTestcasesButton() {
        homeScreen.clickTestcases();
    }

    @Then("Verify user is navigated to test cases page successfully")
    public void verifyUserIsNavigatedToTestCasesPageSuccessfully() {

        Assert.assertTrue(homeScreen.testCasesPageIsOpned());
    }

    @When("Click Products & View First Product")
    public void clickProductsViewFirstProduct() {

        homeScreen.clickProducts();
        homeScreen.clickViewFirtProduct();


    }
}

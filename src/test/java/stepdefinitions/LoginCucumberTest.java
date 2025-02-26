package stepdefinitions;


import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.saucedemo.pages.CartPage;
import com.saucedemo.pages.HomePage;
import com.saucedemo.pages.LoginPage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LoginCucumberTest {

    LoginPage login;
    HomePage home;
    CartPage cart;
    Playwright playwright = Playwright.create();
    BrowserType chrome = playwright.chromium();
    Browser browser = chrome.launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(20));
    Page page = browser.newPage();

    @Given("User launched SwagLabs application")
    public void setUp() {
        page.navigate("https://www.saucedemo.com/");
        home = new HomePage(page);
        login = new LoginPage(page);
        cart = new CartPage(page);

    }

    @When("User verify the Page title")
    public void verifyPageTitle() {
        String title = login.verifyTitle();
        Assert.assertEquals(title, "Swag Labs");

    }

    //Login into the application
    @When("User logged in the app using username {string} and password {string}")
    public void loginIntoTheApplication(String username, String password) {
        login.loginIntoApplication(username, password);
    }

    //Verify product name after login
    @Then("User verify the product name {string}")
    public void verifyProductsName(String productname) {
        String productName = home.getProductName();
        Assert.assertEquals(productName, productname);

    }

    //Logout from application
    @Then("User logout from the application")
    public void logoutFromApplication() {
        login.logoutApplication();
    }


    @And("User Add {string} To Cart")
    public void userAddToCart(String productName) {
        home.addProductCart(productName);
    }

    @And("User Clicks on the Cart Icon to View the Shopping Cart")
    public void userClicksOnTheCartIconToViewTheShoppingCart() {
        home.clickCartIcon();

    }

    @And("User Clicks the Remove Button to Delete an Item from the Cart")
    public void userClicksTheRemoveButtonToDeleteAnItemFromTheCart() {
        cart.clickDeleteButton();

    }

    @And("User Clicks the Continue Shopping Button to Return to the Store")
    public void userClicksTheContinueShoppingButtonToReturnToTheStore() {
        cart.clickContinueShopping();
    }

    @When("User clicks the Checkout button")
    public void userClicksTheCheckoutButton() {
        cart.clickCheckOutButton();
    }

    @And("User enters {string}, {string}, and {string} in the checkout form")
    public void userEntersAndInTheCheckoutForm(String fName, String sName, String add) {
        cart.fillCheckoutForum(fName,sName,add);

    }

    @And("User clicks the Continue button")
    public void userClicksTheContinueButton() {
        cart.clickOveriewContinueButton();

    }

    @Then("User should see the Checkout Overview page")
    public void userShouldSeeTheCheckoutOverviewPage() {

        String paymentInformationMsg=cart.getPaymentInformationMessage();
        Assert.assertEquals(paymentInformationMsg,"Payment Information:");
    }

    @When("User clicks the Finish button")
    public void userClicksTheFinishButton() {
        cart.clickFinishButton();
    }

    @Then("User should see the Order Confirmation message")
    public void userShouldSeeTheOrderConfirmationMessage() {

        boolean isDisplayed=cart.isMessageVisbible();

    }

    @Then("User Click Home Button and log out")
    public void userClickHomeButtonAndLogOut() {
        cart.backHomeButton();
        login.logoutApplication();
    }
}
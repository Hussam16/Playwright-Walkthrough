@Smoke
Feature: Login

  @TC-01
  Scenario Outline: Login to SwagLabs Application with Correct credentials
    Given User launched SwagLabs application
    When User verify the Page title
    When User logged in the app using username "<UserName>" and password "<Password>"
    And  User Add "<ProductName>" To Cart
    And User Clicks on the Cart Icon to View the Shopping Cart
    And User Clicks the Remove Button to Delete an Item from the Cart
    And User Clicks the Continue Shopping Button to Return to the Store
    Then User verify the product name "<ProductName>"
    Then User logout from the application

    Examples:
      | UserName      | Password     | ProductName         |
      | standard_user | secret_sauce | Sauce Labs Backpack |


  @TC-02
  Scenario Outline: Login to SwagLabs Application, Add Products to Cart, Then Checkout
    Given User launched SwagLabs application
    When User verify the Page title
    When User logged in the app using username "<username>" and password "<password>"
    And  User Add "<product_name>" To Cart
    And User Clicks on the Cart Icon to View the Shopping Cart
    When User clicks the Checkout button
    And User enters "<first_name>", "<last_name>", and "<postal_code>" in the checkout form
    And User clicks the Continue button
    Then User should see the Checkout Overview page
    When User clicks the Finish button
    Then User should see the Order Confirmation message
    Then User Click Home Button and log out

    Examples:
      | username      | password     | product_name        | first_name | last_name | postal_code |
      | standard_user | secret_sauce | Sauce Labs Backpack | John       | Doe       | 12345       |
@AutomationExercise
Feature: Register User


  @TestCase-1
  Scenario: User registers and deletes account successfully
    Given I open the browser and go to BaseUrl
    When I click on "Signup / Login"
    Then I should see New User Signup!
    When I enter a name and email, then click "Signup"
    Then I should see ENTER ACCOUNT INFORMATION
    When I fill in the account and address details
    And I select the newsletter and offers checkboxes
    And I click "Create Account"
    Then I should see ACCOUNT CREATED!
    When I click Continue
    Then I should see "Logged in as username"
    When I click Delete Account
    Then I should see ACCOUNT DELETED!
    And I click Continue Button

  @TestCase-2
  Scenario: User Login and deletes account successfully
    Given I open the browser and go to BaseUrl
    When I click on "Signup / Login"
    Then I should see Login to your account is visible
    And  Enter correct email address and password
    And Click login button
    Then I should see "Logged in as username"
    When I click Delete Account
    Then I should see ACCOUNT DELETED!
    And I click Continue Button


  @TestCase-3
  Scenario: User Login With Incorrect Email & Password
    Given I open the browser and go to BaseUrl
    When I click on "Signup / Login"
    Then I should see Login to your account is visible
    And  Enter incorrect email address and password
    And Click login button
    Then I should see  error 'Your email or password is incorrect!' is visible


  @TestCase-4
  Scenario: User Login and Then logout Sucessfully
    Given I open the browser and go to BaseUrl
    When I click on "Signup / Login"
    Then I should see Login to your account is visible
    And  Enter correct email address and password
    And Click login button
    Then I should see "Logged in as username"
    When I Click Logout Button
    Then I should see The Login Screen


  @TestCase-5
  Scenario: User Signup With Already Exist Email Then Error Message 's Displayed
    Given I open the browser and go to BaseUrl
    When I click on "Signup / Login"
    Then I should see New User Signup!
    When I enter name & already registered email address
    And Click Sign up button
    Then I should see error message Email Address Already Exist


  @TestCase-6
  Scenario: User registers and deletes account successfully
    Given I open the browser and go to BaseUrl
    When Click Contact Us Button
    Then Get IN Touch Is Vislible
    When Enter Name ,Email ,Subject and Message
    And Upload File
    And Click Submit Button
    And Click Ok Button
    Then Success message 's Visible
    And Click Continue Button
   # Then Verify Landed on Home Page

  @TestCase-7
  Scenario: Verify Test Cases Page
    Given I open the browser and go to BaseUrl
    When Click Testcases Button
    Then  Verify user is navigated to test cases page successfully


  @TestCase-8
  Scenario: Verify All Products and product detail page
    Given I open the browser and go to BaseUrl
    When Click Products & View First Product



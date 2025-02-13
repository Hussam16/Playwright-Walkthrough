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
  Scenario: User Login and deletes account successfully
    Given I open the browser and go to BaseUrl
    When I click on "Signup / Login"
    Then I should see Login to your account is visible
    And  Enter incorrect email address and password
    And Click login button
    Then I should see  error 'Your email or password is incorrect!' is visible

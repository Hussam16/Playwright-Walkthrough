Feature: Register User


  @TestCase-1
  Scenario: User registers and deletes account successfully
    Given I open the browser and go to BaseUrl
    When I click on "Signup / Login"
    Then I should see New User Signup!
    When I enter a name and email, then click "Signup"
    Then I should see ENTER ACCOUNT INFORMATION
#    When I fill in the account and address details
#    And I select the newsletter and offers checkboxes
#    And I click "Create Account"
#    Then I should see "ACCOUNT CREATED!"
#    When I click "Continue"
#    Then I should see "Logged in as username"
#    When I click "Delete Account"
#    Then I should see "ACCOUNT DELETED!"
#    And I click "Continue"

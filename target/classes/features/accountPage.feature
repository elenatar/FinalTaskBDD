Feature: Sign in
  As a user
  I want to have the possibility to open Create account page
  So that I can create an account

  Scenario Outline: Check that Create account page opens from cart page
    Given User opens '<homePage>' page
    And User checks Cart button visibility
    And User clicks Cart button
    And User clicks Sign up now
    Then User checks that Create account page appears

    Examples:
      | homePage                |
      | https://www.amazon.com/ |


  Scenario Outline: Check that Create account page opens from Sign In page
    Given User opens '<homePage>' page
    And User checks Sign in button visibility
    And User clicks Sign in button
    Then User checks that sign in page appears
    And Users clicks Create your Amazon account
    Then User checks that Create account page appears

    Examples:
      | homePage                |
      | https://www.amazon.com/ |

  Scenario Outline: Check that Create account page opens from Add to list if not registered
    Given User opens '<homePage>' page
    And User checks search field visibility
    When User makes search by keyword '<keyword>'
    And User clicks search button
    And User clicks on first product
    And User clicks Add to List button
    Then User checks that Create account page appears

    Examples:
      | homePage                            | keyword             |
      | https://www.amazon.com/             | xiaomi vacuum robot |



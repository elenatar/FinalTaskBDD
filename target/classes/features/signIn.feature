Feature: Sign in
  As a user
  I want to have the possibility to open sign in page
  So that I can sign in with my account

  Scenario Outline: Check that sign in page opens from top bar
    Given User opens '<homePage>' page
    And User checks Sign in button visibility
    And User clicks Sign in button
    Then User checks that sign in page appears


    Examples:
      | homePage                |
      | https://www.amazon.com/ |

  Scenario Outline: Check that Sign in page opens from cart page
    Given User opens '<homePage>' page
    And User checks Cart button visibility
    And User clicks Cart button
    And User clicks Sign in to your account button
    Then User checks that sign in page appears


    Examples:
      | homePage                |
      | https://www.amazon.com/ |

  Scenario Outline: Check negative flow of Email field on Sign In page
    Given User opens '<homePage>' page
    And User checks Sign in button visibility
    And User clicks Sign in button
    Then User checks that sign in page appears
    And User enters '<symbols>' on Email field
    And User clicks Continue button
    And User checks that warning field appears
    Then User checks the warning '<message>'

    Examples:
      | homePage                | symbols   | message                                           |
      | https://www.amazon.com/ | lfh13l    | We cannot find an account with that email address |





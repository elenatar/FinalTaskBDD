Feature: Search
  As a user
  I want to test search results functionality
  So that I can be sure that I can find searched products

  Scenario Outline: Check that url contains searched word
    Given User opens '<homePage>' page
    And User checks search field visibility
    When User makes search by keyword '<keyword>'
    And User clicks search button
    Then User checks that url contains search '<keyword>'

    Examples:
      | homePage                            | keyword  |
      | https://www.amazon.com/             | Xiaomi   |

  Scenario Outline: Check that searched results contains searched word
    Given User opens '<homePage>' page
    And User checks search field visibility
    When User makes search by keyword '<keyword>'
    And User clicks search button
    Then User checks that resulted products title contains search '<keyword>'

    Examples:
      | homePage                            | keyword             |
      | https://www.amazon.com/             | Xiaomi vacuum robot |

Feature: Add to cart
  As a user
  I want to have the possibility to add products to shopping cart
  So that I can see the added products amount on the shopping cart icon

  Scenario Outline: Check add product to cart
    Given User opens '<homePage>' page
    And User checks search field visibility
    When User makes search by keyword '<keyword>'
    And User clicks search button
    And User clicks on first product
    And User clicks Add to Cart button on product page
    Then User checks that add to cart header is '<amount>'

    Examples:
      | homePage                            | keyword             | amount  |
      | https://www.amazon.com/             | xiaomi vacuum robot | 1       |

  Scenario Outline: Check add product to list
    Given User opens '<homePage>' page
    And User checks search field visibility
    When User makes search by keyword '<keyword>'
    And User clicks search button
    And User clicks on first product
    And User clicks Add to List button
    Then User checks that sign in page appears

    Examples:
      | homePage                            | keyword             |
      | https://www.amazon.com/             | xiaomi vacuum robot |
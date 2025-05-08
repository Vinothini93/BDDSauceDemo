Feature: Sauce Demo Order Flow

  Scenario Outline: Complete a successful order as a standard user
    Given I launch the SauceDemo application
    When I login with username "<username>" and password "<password>"
    Then I should see the Products page

    When I add Sauce Labs Backpack and Sauce Labs Bike Light to the cart
    And I proceed to checkout
    And I enter checkout details with first name "Vinothini", last name "Anandharajan", and zip code "626123"
    And I finish the purchase
    Then I should see the order confirmation message "Thank you for your order!"

  Examples:
    | username      | password      |
    | standard_user | secret_sauce  |

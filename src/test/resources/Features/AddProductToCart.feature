Feature: Search a product and checkout

  Scenario: Search and select a product from search text box and then checkout
    Given user is in dashboard screen
    And user enters product name "iphone 13" in text box and selects a product
    Then Select a product and verify the product value as 71990
    And user clicks on add to cart option
    And then checkout and verify the added product value
Feature: Login into ecommerce website

  Scenario Outline: Login into ecommerce website
    Given user is on signUp page and entered useremail from "<Sheetname>" and romnumber <Rownumber>
    And clicked on continue button
    Then user navigated to password screen
    And entered password from "<Sheetname>" and romnumber <Rownumber>
    And click on submit button
    Examples:
      | Sheetname | Rownumber |
      | Login     | 0         |
     # | Login     | 1         |


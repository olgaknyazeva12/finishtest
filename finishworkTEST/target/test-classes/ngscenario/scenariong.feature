Feature: TestNG Search in Mail

  Scenario: TestNG Search for cafe
    Given I am on the main application page
    When I fill in the search field text to find list of cafe sites 
    When I click search button
    Then I see the first site in the result search list
    
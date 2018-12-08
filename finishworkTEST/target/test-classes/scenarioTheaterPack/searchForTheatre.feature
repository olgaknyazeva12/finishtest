Feature: Searching on Mail site (verification 2)

 Scenario: Search for theater on Mail 
    Given I am on main application page to find theater site
    When I fill in the search field text to find list of theater sites 
    When I click search button to find theater
    Then I see the first theater site in the result search list
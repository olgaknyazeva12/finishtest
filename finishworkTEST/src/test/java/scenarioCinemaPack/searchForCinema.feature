Feature: Searching on Mail site (verification 1)

 Scenario: Search for movie on Mail 
    Given I am on main application page
    When I fill in the search field text to find list of movie sites 
    When I click search button
    Then I see the first site in the result search list
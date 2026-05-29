Feature: Group Creation and Validation

  Scenario Outline: Admin creates group and verifies it in signup page

    Given I am on the login page
    And I enter email "<email>"
    And I enter password "<password>"
    When I click login button
    Then I should be logged in successfully
    When I navigate to admin panel
    And I click on group section
    And I click on the create new group button
    And I create group with "<groupName>", "<groupDescription>", "<year>", "<maxCapacity>", "<startDate>", "<endDate>"
    Then i should see the group created successfully
    And I click back to website button
    And I click log out
    When I confirm logout
    And I navigate to signup page
    Then Created group should be visible in group dropdown

    Examples:
      | email              | password  | groupName       | groupDescription | year | maxCapacity | startDate  | endDate    |
      | shazilax@gmail.com | 586424Hh@ | Auto Group 2026 | Automation Group | 2026 | 1000        | 2026-05-18 | 2027-11-18 |

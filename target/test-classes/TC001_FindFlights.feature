#Author: your.email@your.domain.com

@TC001
Feature: Verify user is able to select  a flight and continue

  Scenario: User is able to view Flight Finder page
    Given a user lands into "http://newtours.demoaut.com/mercurywelcome.php" website
    And a user clicks username and enter "demo" as username
    And a user clicks password and enter "demo" as password
    When a user click login button
    Then a user is able to veriy "Flight Finder" page


  Scenario: User is able to select a flight and continue
    Given a user lands into "http://newtours.demoaut.com/mercurywelcome.php" website
    And a user clicks username and enter "demo" as username
    And a user clicks password and enter "demo" as password
    When a user click login button
    Then a user is able to veriy "Flight Finder" page
    
    And a user able to enter required details in Flight Finder page and click Continue
    
      | Type           | One Way          |
      
      | Passengers     |                2 |
      
      | Departing From | London           |
      
      | Month          | June             |

      | Day            |               10 |

      | Service Class  | Business Class   |

      | Airline        | Unified Airlines |

    And a user is able to veriy "Select Flight" page
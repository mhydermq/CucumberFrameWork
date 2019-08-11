#Author: your.email@your.domain.com

@TC002
Feature: Verify user is able to select a flight and continue

  Scenario Outline: User is able to select a flight and continue
    Given a user lands into "http://newtours.demoaut.com/mercurywelcome.php" website
    And a user clicks username and enter "demo" as username
    And a user clicks password and enter "demo" as password
    When a user click login button
    Then a user is able to veriy "Flight Finder" page

    And a user able to enter required details in Flight Finder page and click Continue

      | Type           | <Type>           |

      | Passengers     | <Passengers>     |

      | Departing From | <Departing From> |

      | Month          | <Month>          |

      | Day            | <Day>            |

      | Service Class  | <Service Class>  |

      | Airline        | <Airline>        |

    And a user is able to veriy "Select Flight" page

    Examples: 
      | Type    | Passengers | Departing From | Month | Day | Service Class  | Airline          |

      | One Way |          2 | London         | June  |  10 | Business Class | Unified Airlines |

      | One Way |          3 | London         | July  |  20 | Business Class | Unified Airlines |
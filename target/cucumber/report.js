$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("TC001_FindFlights.feature");
formatter.feature({
  "comments": [
    {
      "line": 1,
      "value": "#Author: your.email@your.domain.com"
    }
  ],
  "line": 4,
  "name": "Verify user is able to select  a flight and continue",
  "description": "",
  "id": "verify-user-is-able-to-select--a-flight-and-continue",
  "keyword": "Feature",
  "tags": [
    {
      "line": 3,
      "name": "@TC001"
    }
  ]
});
formatter.before({
  "duration": 16644369800,
  "status": "passed"
});
formatter.scenario({
  "line": 6,
  "name": "User is able to view Flight Finder page",
  "description": "",
  "id": "verify-user-is-able-to-select--a-flight-and-continue;user-is-able-to-view-flight-finder-page",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 7,
  "name": "a user lands into \"http://newtours.demoaut.com/mercurywelcome.php\" website",
  "keyword": "Given "
});
formatter.step({
  "line": 8,
  "name": "a user clicks username and enter \"demo\" as username",
  "keyword": "And "
});
formatter.step({
  "line": 9,
  "name": "a user clicks password and enter \"demo\" as password",
  "keyword": "And "
});
formatter.step({
  "line": 10,
  "name": "a user click login button",
  "keyword": "When "
});
formatter.step({
  "line": 11,
  "name": "a user is able to veriy \"Flight Finder\" page",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "http://newtours.demoaut.com/mercurywelcome.php",
      "offset": 19
    }
  ],
  "location": "Home_Step.a_user_lands_into_website(String)"
});
formatter.result({
  "duration": 1173004400,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "demo",
      "offset": 34
    }
  ],
  "location": "Home_Step.a_user_clicks_username_and_enter_as_username(String)"
});
formatter.result({
  "duration": 967156100,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "demo",
      "offset": 34
    }
  ],
  "location": "Home_Step.a_user_clicks_password_and_enter_as_password(String)"
});
formatter.result({
  "duration": 715492200,
  "status": "passed"
});
formatter.match({
  "location": "Home_Step.a_user_click_login_button()"
});
formatter.result({
  "duration": 6336345700,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Flight Finder",
      "offset": 25
    }
  ],
  "location": "FlightFinder_Step.a_user_is_able_to_veriy_page(String)"
});
formatter.result({
  "duration": 535594000,
  "status": "passed"
});
formatter.after({
  "duration": 5514066300,
  "status": "passed"
});
formatter.before({
  "duration": 9516258300,
  "status": "passed"
});
formatter.scenario({
  "line": 14,
  "name": "User is able to select a flight and continue",
  "description": "",
  "id": "verify-user-is-able-to-select--a-flight-and-continue;user-is-able-to-select-a-flight-and-continue",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 15,
  "name": "a user lands into \"http://newtours.demoaut.com/mercurywelcome.php\" website",
  "keyword": "Given "
});
formatter.step({
  "line": 16,
  "name": "a user clicks username and enter \"demo\" as username",
  "keyword": "And "
});
formatter.step({
  "line": 17,
  "name": "a user clicks password and enter \"demo\" as password",
  "keyword": "And "
});
formatter.step({
  "line": 18,
  "name": "a user click login button",
  "keyword": "When "
});
formatter.step({
  "line": 19,
  "name": "a user is able to veriy \"Flight Finder\" page",
  "keyword": "Then "
});
formatter.step({
  "line": 21,
  "name": "a user able to enter required details in Flight Finder page and click Continue",
  "rows": [
    {
      "cells": [
        "Type",
        "One Way"
      ],
      "line": 23
    },
    {
      "cells": [
        "Passengers",
        "2"
      ],
      "line": 25
    },
    {
      "cells": [
        "Departing From",
        "London"
      ],
      "line": 27
    },
    {
      "cells": [
        "Month",
        "June"
      ],
      "line": 29
    },
    {
      "cells": [
        "Day",
        "10"
      ],
      "line": 31
    },
    {
      "cells": [
        "Service Class",
        "Business Class"
      ],
      "line": 33
    },
    {
      "cells": [
        "Airline",
        "Unified Airlines"
      ],
      "line": 35
    }
  ],
  "keyword": "And "
});
formatter.step({
  "line": 37,
  "name": "a user is able to veriy \"Select Flight\" page",
  "keyword": "And "
});
formatter.match({
  "arguments": [
    {
      "val": "http://newtours.demoaut.com/mercurywelcome.php",
      "offset": 19
    }
  ],
  "location": "Home_Step.a_user_lands_into_website(String)"
});
formatter.result({
  "duration": 770822100,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "demo",
      "offset": 34
    }
  ],
  "location": "Home_Step.a_user_clicks_username_and_enter_as_username(String)"
});
formatter.result({
  "duration": 747728600,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "demo",
      "offset": 34
    }
  ],
  "location": "Home_Step.a_user_clicks_password_and_enter_as_password(String)"
});
formatter.result({
  "duration": 702964800,
  "status": "passed"
});
formatter.match({
  "location": "Home_Step.a_user_click_login_button()"
});
formatter.result({
  "duration": 6394054900,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Flight Finder",
      "offset": 25
    }
  ],
  "location": "FlightFinder_Step.a_user_is_able_to_veriy_page(String)"
});
formatter.result({
  "duration": 567274500,
  "status": "passed"
});
formatter.match({
  "location": "FlightFinder_Step.a_user_able_to_enter_required_details_in_Flight_Finder_page_and_click_Continue(String,String\u003e)"
});
formatter.result({
  "duration": 2008116700,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Select Flight",
      "offset": 25
    }
  ],
  "location": "FlightFinder_Step.a_user_is_able_to_veriy_page(String)"
});
formatter.result({
  "duration": 536396900,
  "status": "passed"
});
formatter.after({
  "duration": 796638000,
  "status": "passed"
});
});
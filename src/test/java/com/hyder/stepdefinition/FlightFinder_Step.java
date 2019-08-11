package com.hyder.stepdefinition;

import java.util.Map;
import com.hyder.base.WebDriverBase;
import com.hyder.pages.FlightFinderPage;
import cucumber.api.java.en.Then;

public class FlightFinder_Step extends WebDriverBase{
	FlightFinderPage flightFinderPage;

	public FlightFinder_Step() {
		flightFinderPage = new FlightFinderPage();
	}

	@Then("^a user is able to veriy \"([^\"]*)\" page$")
	public void a_user_is_able_to_veriy_page(String arg1) throws Throwable {
		flightFinderPage.verifyFlightFinderPage();    
	}
	
	@Then("^a user able to enter required details in Flight Finder page and click Continue$")
	public void a_user_able_to_enter_required_details_in_Flight_Finder_page_and_click_Continue(Map<String, String> flightDetails) throws Throwable {
		flightFinderPage.fillFlightDetails(flightDetails);
		System.out.println("Passengers: "+ flightDetails.get("Passengers"));
	}
}
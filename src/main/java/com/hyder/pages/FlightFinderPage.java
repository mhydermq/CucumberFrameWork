package com.hyder.pages;

import java.util.Map;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.hyder.base.BasePage;
import com.hyder.utils.Log;

public class FlightFinderPage extends BasePage {

	//Element Locators for one way radio button
	@FindBy(xpath = "//input[@value='oneway']")
	private WebElement onewayRadio;

	public WebElement getOneWayRadio() {
		try {
			elementDetails.put(onewayRadio, "One Way radio button");
		} catch (Exception e) {
			
		}
		return onewayRadio;
	}

	//Element Locators for Flight Finder Image
	@FindBy(xpath = "//img[contains(@src,'/images/masts/mast_flightfinder.gif')]")
	private WebElement flightFinderImage;

	public WebElement getFlightFinderImage() {
		try {
			elementDetails.put(flightFinderImage, "Flight Finder Image");
		} catch (Exception e) {

		}
		return flightFinderImage;
	}

	

	//Select the location from dropdown
	@FindBy(name = "fromPort")
	private WebElement fromPortDrop;

	public WebElement getFromPortDrop(){
		try{
			elementDetails.put(fromPortDrop, "From Port drop down");
		}catch (Exception e) {

		}	
		return fromPortDrop;
	}

    //Select the passengers
	@FindBy(name = "passCount")
	private WebElement passengerDrop;

	public WebElement getPassengerDrop(){
		try{
			elementDetails.put(passengerDrop, "Select number of passengers");
		}catch (Exception e) {

		}	
		return passengerDrop;
	}

	//Select the day from dropdown
	@FindBy(xpath = "//select[@name='fromDay']")
	private WebElement fromDayDrop;

	public WebElement getFromDayDrop(){
		try{
			elementDetails.put(fromDayDrop, "From Day drop down");
		}catch (Exception e) {

		}
		return fromDayDrop;
	}

		//Select the Month from dropdown
		@FindBy(xpath = "//select[@name='fromMonth']")
		private WebElement fromMonthDrop;

		public WebElement getFromMonthDrop(){
			try{
				elementDetails.put(fromMonthDrop, "From Month drop down");
			}catch (Exception e) {

			}
			return fromMonthDrop;
		}

	//Click Business radio button
	@FindBy(xpath = "//input[@value='Business']")
	private WebElement businessRadio;

	public WebElement getBusinessRadio(){
		try{
			elementDetails.put(businessRadio, "Business radio button");
		}catch (Exception e) {
			
		}
		return businessRadio;
	}

	

	//Click find flights button
	@FindBy(name = "findFlights")
	private WebElement findFlightsButton;
	public WebElement getFindFlightsButton(){

		try{
			elementDetails.put(findFlightsButton, "Find Flights button");
		}catch (Exception e) {

		}
		return findFlightsButton;
	}

	//Select the Airline from dropdown
	@FindBy(xpath = "//select[@name='airline']")
	private WebElement airlineDrop;

	public WebElement getAirlineDrop(){
		try{
			elementDetails.put(airlineDrop, "Airline drop down");
		}catch (Exception e) {

		}
		return airlineDrop;
	}

	
	//Find Flights method. Notice there is no return type
	public void findFlights(String departFrom, String departDate) {

		// Click one way radio button
		clickElement(getOneWayRadio());
		Log.info("FlightFinderPage.findFlights - One way Radio Button clicked");

		// Select Departing From dropdown
		SelectElementByText(getFromPortDrop(), departFrom);
		Log.info("FlightFinderPage.findFlights - Depart From Dropdown clicked");

		// Select Departing Day dropdown
		SelectElementByText(getFromDayDrop(), departDate);
		Log.info("FlightFinderPage.findFlights - Depart Date Dropdown clicked");

		// Click business class
		clickElement(getBusinessRadio());
		Log.info("FlightFinderPage.findFlights - Business Radio Button clicked");

		// Click Find Flights button
		clickElement(getFindFlightsButton());
		Log.info("FlightFinderPage.findFlights - Find Flights Button clicked");
	}

	public void verifyFlightFinderPage() {

		clickElement(getFlightFinderImage());
		Log.info("FlightFinderPage.findFlights - Find Flights Image clicked");
	}

	public void fillFlightDetails(Map<String, String> flightDetails) {

		if(flightDetails.get("Type").equals("One Way")) {

			// Click one way radio button
			clickElement(getOneWayRadio());
			Log.info("FlightFinderPage.findFlights - One way Radio Button clicked");
		}

		// Select No of passengers
		SelectElementByText(getPassengerDrop(), flightDetails.get("Passengers"));
		Log.info("FlightFinderPage.findFlights - Depart From Dropdown clicked");

		// Select Departing From dropdown
		SelectElementByText(getFromPortDrop(), flightDetails.get("Departing From"));
		Log.info("FlightFinderPage.findFlights - Depart From Dropdown clicked");

		// Select Departing Month dropdown
		SelectElementByText(getFromMonthDrop(), flightDetails.get("Month"));
		Log.info("FlightFinderPage.findFlights - Depart Month Dropdown clicked");

	    // Select Departing Day dropdown
		SelectElementByText(getFromDayDrop(), flightDetails.get("Day"));
		Log.info("FlightFinderPage.findFlights - Depart Date Dropdown clicked");

		if(flightDetails.get("Service Class").equals("Business Class")) {
			
			// Click business class
			clickElement(getBusinessRadio());
			Log.info("FlightFinderPage.findFlights - Business Radio Button clicked");	
		}

		// Select Departing airline
		SelectElementByText(getAirlineDrop(), flightDetails.get("Airline"));
		Log.info("FlightFinderPage.findFlights - Depart airline Dropdown clicked");
	}

			



}
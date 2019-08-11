package com.hyder.stepdefinition;

import com.hyder.base.WebDriverBase;
import com.hyder.pages.HomePage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

public class Home_Step extends WebDriverBase{
	HomePage homePage;

	public Home_Step() {
		homePage = new HomePage();
	}

	@Given("^a user lands into \"([^\"]*)\" website$")
	public void a_user_lands_into_website(String url) throws Throwable {
	    homePage.navigateToURL(url);
	    //WebDriverBase.getDriverInstance().close();
		//WebDriverBase.getDriverInstance().quit();
	}

	@Given("^a user clicks username and enter \"([^\"]*)\" as username$")
	public void a_user_clicks_username_and_enter_as_username(String uname) throws Throwable {
		
	    // Write code here that turns the phrase above into concrete actions
	    homePage.clickUserName();
	    homePage.enterUserName(uname);
	}

	@Given("^a user clicks password and enter \"([^\"]*)\" as password$")
	public void a_user_clicks_password_and_enter_as_password(String pwd) throws Throwable {

	    // Write code here that turns the phrase above into concrete actions
	    homePage.clickPwd();
	    homePage.enterPwd(pwd);
	}

	@When("^a user click login button$")
	public void a_user_click_login_button() throws Throwable {
	    homePage.clickLogin();
	}
}

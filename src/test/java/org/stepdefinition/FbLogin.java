package org.stepdefinition;

import org.pojo.FbLoginPojo;
import org.sam.BaseClass;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class FbLogin extends BaseClass {
	@Given("To launch the chrome browser and maximise window")
	public void to_launch_the_chrome_browser_and_maximise_window() {
		lanunchBrowser();
		windowMaximize();
	  
	}

	@When("To launch the url facebook appliction")
	public void to_launch_the_url_facebook_appliction() {
		launchUrl("https://en-gb.facebook.com/");
	    
	}

	@When("To pass valid username in email field")
	public void to_pass_valid_username_in_email_field() {
		FbLoginPojo f = new FbLoginPojo();
		passText("pritiv07@gmail.com", f.getEmail());
		
	    
	}

	@When("TO pass invalid password in password field")
	public void to_pass_invalid_password_in_password_field() {
		FbLoginPojo f = new FbLoginPojo();
		passText("sakthi", f.getPassword());
	    
	}

	@When("To click the login button")
	public void to_click_the_login_button() {
		FbLoginPojo f = new FbLoginPojo();
		clickBtn(f.getLoginBtn());
	   
	}

	@When("To check wheather navigate to home page or not")
	public void to_check_wheather_navigate_to_home_page_or_not() {
	   System.out.println("To check your login credentials");
	}

	@Then("To close the browser")
	public void to_close_the_browser() {
		closeEntireBrowser();
	   
	}

}

package com.tastyNibbles.stepDefinition;

import com.tastyNibbles.browser.Browser;
import com.tastyNibbles.pages.RegistrationPage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class RegistrationSteps {
	// Step to open the browser
	@Given("User opens the Browser")
	public void user_opens_the_browser() throws Exception {
	    Browser.openBrowser();
	}
	
	// Step to navigate to the specified webpage
	@And("User navigate to the {string} web page")
	public void user_navigate_to_the_web_page(String string) throws Exception {
	   Browser.navigateToUrl(string);
	}
	
	// Step to click on the Account link
	@When("User clicks on Account link")
	public void user_clicks_on_account_link() {
	    RegistrationPage.clickOnAccount();
	}
	
	// Step to click on the Create Account link
	@When("user clicks on Create account link")
	public void user_clicks_on_create_account_link() {
	   RegistrationPage.clickOnCreateAccount();
	}
	
	// Step to enter the First Name
	@When("User enters {string} in FirstName")
	public void user_enters_in_first_name(String string) {
	   RegistrationPage.enterFirstName(string);
	}
	
	// Step to enter the Last Name
	@And("User enters  {string} in LastName")
	public void user_enters_in_last_name(String string) {
		   RegistrationPage.enterLastName(string);
	}
	
	// Step to enter the Email ID
	@And("User enters {string} in email")
	public void user_enters_in_email(String string) {
		   RegistrationPage.enterEmail(string);
	}
	
	// Step to enter the Password
	@And("User enters  {string} in password")
	public void user_enters_in_password(String string) {
		   RegistrationPage.enterPassword(string);
	}
	
	// Step to click on the Create button
	@And("User clicks on Create button")
	public void user_clicks_on_create_button() {
	    RegistrationPage.clickCreate();
	}
	
	// Step to verify the error message if registration fails
	@Then("User verifies the error message")
	public void user_verifies_the_error_message() {
	   RegistrationPage.verifyErrorMsg();
	}
	
	// Step to verify successful registration
	@Then("User verifies  registered successfully")
	public void user_verifies_registered_successfully() {
	   RegistrationPage.verifySuccessfullRegistrationMsg();
	}
	
	// Step to close the browser after test execution
	@And("User closes the Browser")
	public void user_closes_the_browser() {
		 RegistrationPage.closeBrowser();
	}
}
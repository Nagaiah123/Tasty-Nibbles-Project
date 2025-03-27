package com.tastyNibbles.stepDefinition;


import com.tastyNibbles.pages.ValidandInvalidCredentialsPage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;

public class ValidandInvalidCredentialsSteps {
	 // Step definition for entering an invalid email
	@When("User enters the {string} invalid email")
	public void user_enters_the_invalid_email(String string) {
	    ValidandInvalidCredentialsPage.enterEmail(string);
	}
	
	  // Step definition for entering a password
	@When("User enters the {string} password")
	public void user_enters_the_password(String string) {
	    ValidandInvalidCredentialsPage.enterPassword(string);
	}

	 // Step definition for verifying the error message displayed
	@And("User verifies the {string} error message")
	public void user_verifies_the_error_message(String string) {
	   ValidandInvalidCredentialsPage.verifyErrorMsg(string);
	}

	  // Step definition for verifying whether a specific message is displayed after login
	@And("User verifies {string} is displayed or not")
	public void user_verifies_is_displayed_or_not(String string) {
	    ValidandInvalidCredentialsPage.verifySuccessfulLogin(string);
	}
}
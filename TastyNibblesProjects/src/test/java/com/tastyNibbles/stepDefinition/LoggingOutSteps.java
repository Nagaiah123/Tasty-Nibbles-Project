package com.tastyNibbles.stepDefinition;



import com.tastyNibbles.pages.LoggingOutPage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class LoggingOutSteps {
	 // Step definition for selecting the logout option
    @And("User selects Logout option")
    public void user_selects_logout_option() {
        LoggingOutPage.logoutFromApp();
    }

 // Step definition for verifying that the session ends and the user is redirected to the homepage
    @Then("User Verify that the session ends and the user is redirected to the {string} homepage.")
    public void user_verify_that_the_session_ends_and_the_user_is_redirected_to_the_homepage(String string) {
        LoggingOutPage.verifyLogout(string);
    }
}

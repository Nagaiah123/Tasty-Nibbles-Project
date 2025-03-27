package com.tastyNibbles.pages;

import java.time.Duration;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.tastyNibbles.browser.Browser;
import com.tastyNibbles.locators.RegistrationObj;


public class RegistrationPage extends Browser {

	 // Method to click on the "Create Account" button
    public static void clickOnCreateAccount() {
        try {
        	RegistrationObj.createAccount().click();
        } catch (Exception e) {
            System.out.println("Exception in clickOnCreateAccount: " + e.getMessage());
        }
    }

   // Method to enter the first name in the registration form
    public static void enterFirstName(String firstName) {
        try {
            wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOfElementLocated(RegistrationObj.firstName));
            RegistrationObj.firstName().sendKeys(firstName);
        } catch (Exception e) {
            System.out.println("Exception in enterFirstName: " + e.getMessage());
        }
    }
    
    // Method to enter the last name in the registration form
    public static void enterLastName(String lastName) {
        try {
        	RegistrationObj.lastName().sendKeys(lastName);
        } catch (Exception e) {
            System.out.println("Exception in enterLastName: " + e.getMessage());
        }
    }

 // Method to enter the email address in the registration form
    public static void enterEmail(String email) {
        try {
        	RegistrationObj.email().sendKeys(email);
        } catch (Exception e) {
            System.out.println("Exception in enterEmail: " + e.getMessage());
        }
    }

    // Method to enter the password in the registration form
    public static void enterPassword(String password) {
        try {
        	RegistrationObj.password().sendKeys(password);
        } catch (Exception e) {
            System.out.println("Exception in enterPassword: " + e.getMessage());
        }
    }

    // Method to click the "Create" button to submit the registration form
    public static void clickCreate() {
        try {
        	RegistrationObj.createButton().click();
        } catch (Exception e) {
            System.out.println("Exception in clickCreate: " + e.getMessage());
        }
    }

    // Method to verify if an error message is displayed
    public static void verifyErrorMsg() {
        try {
            wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement errorDiv = wait.until(ExpectedConditions.visibilityOfElementLocated(RegistrationObj.errorDiv));
            Assert.assertTrue(errorDiv.isDisplayed());
        } catch (Exception e) {
            System.out.println("Exception in verifyErrorMsg: " + e.getMessage());
        }
    }

    // Method to verify successful registration by checking if "Log out" appears
    public static void verifySuccessfullRegistrationMsg() {
        try {
        	RegistrationObj.accountLink().click();
            wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOfElementLocated(RegistrationObj.logoutElement));
            Assert.assertEquals(RegistrationObj.assertText().getText(), "Log out");
        } catch (Exception e) {
            System.out.println("Exception in verifySuccessfullRegistrationMsg: " + e.getMessage());
          
        }
    }

    // Method to close the browser
    public static void closeBrowser() {
        try {
            Browser.closeBrowser();
        } catch (Exception e) {
            System.out.println("Exception in closeBrowser: " + e.getMessage());
        }
    }

    // Method to click on the "Account" link after closing a popup if present
    public static void clickOnAccount() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            wait.until(ExpectedConditions.visibilityOfElementLocated(RegistrationObj.closeButton));
            RegistrationObj.closeButton().click();
            RegistrationObj.accountLink().click();
        } catch (Exception e) {
            System.out.println("Exception in clickOnAccount: " + e.getMessage());
        }
    }
}

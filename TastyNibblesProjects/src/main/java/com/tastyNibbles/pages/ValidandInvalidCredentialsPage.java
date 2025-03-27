package com.tastyNibbles.pages;

import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.tastyNibbles.browser.Browser;
import com.tastyNibbles.locators.ValidandInvalidCredentialsObj;



public class ValidandInvalidCredentialsPage extends Browser {
    
	  // Method to enter email into the email field
    public static void enterEmail(String email) {
        try {
        	wait=new WebDriverWait(driver,Duration.ofSeconds(10));
        	wait.until(ExpectedConditions.visibilityOfElementLocated(ValidandInvalidCredentialsObj.email));
            ValidandInvalidCredentialsObj.email().sendKeys(email);
        } catch (Exception e) {
            System.out.println("Error while entering email: " + e.getMessage());
        }
    }
    // Method to enter password into the password field
    public static void enterPassword(String password) {
        try {
            ValidandInvalidCredentialsObj.password().sendKeys(password);
        } catch (Exception e) {
            System.out.println("Error while entering password: " + e.getMessage());
        }
    }
    // Method to click the Sign In button
    public static void clickSignIn() {
        try {
            ValidandInvalidCredentialsObj.signInButton().click();
        } catch (Exception e) {
            System.out.println("Error while clicking Sign In button: " + e.getMessage());
        }
    }
 // Method to verify the error message displayed for invalid credentials
    public static void verifyErrorMsg(String msg) {
    	try {
    		wait=new WebDriverWait(driver,Duration.ofSeconds(10));
    		wait.until(ExpectedConditions.visibilityOfElementLocated(ValidandInvalidCredentialsObj.errorMsg));
    		Assert.assertEquals(ValidandInvalidCredentialsObj.error().getText(), msg);
    	}catch(Exception e) {
    		System.out.println(e.getMessage());
    	}
    }
    // Method to verify successful login by checking if the My Account element is visible
    public static void verifySuccessfulLogin(String str) {
    	try {
    		wait=new WebDriverWait(driver,Duration.ofSeconds(10));
    		wait.until(ExpectedConditions.visibilityOfElementLocated(ValidandInvalidCredentialsObj.myAccountElement));
    		Assert.assertEquals(ValidandInvalidCredentialsObj.myAccount().getText(), str);
    	}catch(Exception e) {
    		System.out.println(e.getMessage());
    	}
    }
}
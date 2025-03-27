package com.tastyNibbles.locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.tastyNibbles.browser.Browser;


public class RegistrationObj extends Browser {

    // Elements from createAccountObjects
    public static By firstName = By.xpath("//input[@name='customer[first_name]']");
    public static By createAccountLink = By.linkText("Create account");
    public static By lastName = By.xpath("//input[@name='customer[last_name]']");
    public static By email = By.xpath("//input[@name='customer[email]']");
    public static By password = By.xpath("//input[@name='customer[password]']");
    public static By createButton = By.xpath("//input[@class='btn btn--full']");
    public static By logoutElement = By.linkText("Log out");
    public static By errorDiv = By.xpath("//div[@class='errors']");

    // Elements from homePageObjects
    public static By closeButton = By.xpath("//span[@class='engt_modal_close-btn']");
    public static By accountLink = By.linkText("ACCOUNT");

    // Methods from createAccountObjects
   // Returns "Create Account" link element
    public static WebElement createAccount() {
        return driver.findElement(createAccountLink);
    }

    // Returns First Name input field element
    public static WebElement firstName() {
        return driver.findElement(firstName);
    }

    // Returns Last Name input field element
    public static WebElement lastName() {
        return driver.findElement(lastName);
    }

   // Returns Email input field element
    public static WebElement email() {
        return driver.findElement(email);
    }
    
    // Returns Password input field element
    public static WebElement password() {
        return driver.findElement(password);
    }

   // Returns Create Account button element
    public static WebElement createButton() {
        return driver.findElement(createButton);
    }
    
    // Returns Logout element (for assertion after registration)
    public static WebElement assertText() {
        return driver.findElement(logoutElement);
    }

    // Returns error message container element
    public static WebElement errorDiv() {
        return driver.findElement(errorDiv);
    }

    // Methods from homePageObjects
    // Returns close button element (used for closing popups)
    public static WebElement closeButton() {
        return driver.findElement(closeButton);
    }

 // Returns Account link element
    public static WebElement accountLink() {
        return driver.findElement(accountLink);
    }
}

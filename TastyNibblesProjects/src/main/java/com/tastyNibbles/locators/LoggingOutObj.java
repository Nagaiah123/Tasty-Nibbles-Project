package com.tastyNibbles.locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.tastyNibbles.browser.Browser;



public class LoggingOutObj extends Browser {
    public static By logoutButton = By.linkText("Log out");    // Locator for the "Log out" button
    public static By accountLink = By.linkText("ACCOUNT");	  // Locator for the "ACCOUNT" link
    public static By vefiryDiv = By.xpath("//div[@class=\"hero__animation-contents\"]");  // Locator for the verification div on the homepage

    // Method to find and return the "ACCOUNT" link WebElement
    public static WebElement accountLink() {
        return driver.findElement(accountLink);
    }

 // Method to find and return the "Log out" button WebElement
    public static WebElement logout() {
        return driver.findElement(logoutButton);
    }

    // Method to get and return the current page URL
    public static String homePageUrl() {
        return driver.getCurrentUrl();
    }
}

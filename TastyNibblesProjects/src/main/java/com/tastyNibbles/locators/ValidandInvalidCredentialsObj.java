package com.tastyNibbles.locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.tastyNibbles.browser.Browser;

public class ValidandInvalidCredentialsObj  extends Browser{
	public static By email=By.xpath("//input[@name=\"customer[email]\"]");          // Locator for the email input field
	public static By password =By.xpath("//input[@name=\"customer[password]\"]");	// Locator for the password input field
	public static By signInButoon=By.xpath("//button[@class=\"btn btn--full\"]");	// Locator for the sign-in button
	public static By errorMsg=By.xpath("//div[@class=\"errors\"]/ul/li");			// Locator for the error message element
	public static By myAccountElement=By.xpath("//h1[@class=\"section-header__title\"]");  // Locator for the "My Account" section header
	
	 // Method to find and return the email input WebElement
	public static WebElement email() {
		return driver.findElement(email);
	}
	 // Method to find and return the password input WebElement
	public static WebElement password() {
		return driver.findElement(password);
	}
	// Method to find and return the sign-in button WebElement
	public static WebElement signInButton() {
		return driver.findElement(signInButoon);
	}
	// Method to find and return the error message WebElement
	public static WebElement error() {
		return driver.findElement(errorMsg);
	}
	 // Method to find and return the "My Account" section header WebElement
	public static WebElement myAccount() {
		return driver.findElement(myAccountElement);
	}

}

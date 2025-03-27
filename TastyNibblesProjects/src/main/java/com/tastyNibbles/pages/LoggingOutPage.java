package com.tastyNibbles.pages;

import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.tastyNibbles.browser.Browser;
import com.tastyNibbles.locators.LoggingOutObj;

public class LoggingOutPage extends Browser {
    
	 // Method to log out from the application
    public static void logoutFromApp() {
        try {
            LoggingOutObj.logout().click();
        } catch (Exception e) {
            System.out.println("Exception in logoutFromApp: " + e.getMessage());
        }
    }

 // Method to verify successful logout by checking if the URL matches the expected homepage URL
    public static void verifyLogout(String url) {
        try {
            wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOfElementLocated(LoggingOutObj.vefiryDiv));
            Assert.assertEquals(LoggingOutObj.homePageUrl(), url);
        } catch (Exception e) {
            System.out.println("Exception in verifyLogout: " + e.getMessage());
        }
    }
}

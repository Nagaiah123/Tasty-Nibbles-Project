package com.tastyNibbles.pages;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.aventstack.extentreports.Status;
import com.tasteNibbles.CustomizedExceptions.CustomizedExceptions;
import com.tastyNibbles.browser.Browser;
import com.tastyNibbles.locators.AddingDifferentItemsObj;
import com.tastyNibbles.locators.SearchObj;

public class AddingDifferentItemsPage extends Browser {
	
	// Method to navigate to the cart
	public static void navigateToCart() throws InterruptedException {
		try {
			// Wait until the cart div is visible
			wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        wait.until(ExpectedConditions.visibilityOfElementLocated(SearchObj.cartDiv));

	        // Adding a delay before refreshing the page
	        Thread.sleep(9000);
			driver.navigate().refresh();

			// Click on the cart button
			SearchObj.cart().click();
		} catch (Exception e) {
			System.out.println("Exception in navigating to cart: " + e.getMessage());
		}
	}

	// Method to verify the total price of items in the cart
	public static void verifyPrices() throws CustomizedExceptions {
	    double priceOfAllItems = 0;
	   
	    try {
	        // Wait until the cart div is visible
	        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        wait.until(ExpectedConditions.visibilityOfElementLocated(SearchObj.cartDiv));

	        // Get the list of price elements from the cart
	        List<WebElement> list = AddingDifferentItemsObj.prices();
	        ArrayList<String> prices = new ArrayList<>();

	        // Extract and clean the price values from elements
	        for (WebElement element : list) {
	            String[] splitPrices = element.getText().replace("₹", "").trim().split("\\s+"); 
	            for (String price : splitPrices) {
	                prices.add(price);
	            }
	        }

	        // Summing up the individual item prices
	        for (int i = 1; i < prices.size(); i += 2) {
	        	priceOfAllItems += Double.parseDouble(prices.get(i));
	        }
	        System.out.println(priceOfAllItems + "  prices");

	        // Retrieve and clean the total price displayed in the cart
	        WebElement totalElement = AddingDifferentItemsObj.totalPrice();
	        String totalText = totalElement.getText().trim();
	        totalText = totalText.replaceAll("[^0-9]", "").trim();
	        
	        // Handling cases where the total price has decimal or unwanted characters
	        if (totalText.length() > 2) {
	            totalText = totalText.substring(0, totalText.length() - 2);
	        }
	        
	        double totalPrice = Double.parseDouble(totalText);

	        // Assert that the calculated price matches the displayed total price
	        Assert.assertEquals(totalPrice, priceOfAllItems);

	    } catch (Exception e) {
	        throw new CustomizedExceptions("Error in verifying price: " + e.getMessage());
	    }
	}
}

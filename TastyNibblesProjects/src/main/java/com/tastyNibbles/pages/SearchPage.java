package com.tastyNibbles.pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.aventstack.extentreports.Status;
import com.tasteNibbles.CustomizedExceptions.CustomizedExceptions;
import com.tastyNibbles.browser.Browser;
import com.tastyNibbles.locators.SearchObj;
import com.tastyNibbles.screenshot.Capture;


public class SearchPage extends Browser{
	
		//method to enter the product name in the search box
		public static void searchProduct(String product) throws CustomizedExceptions {
			extent.attachReporter(reporter);
			logger1=extent.createTest("Searching for a Item ");
			logger1.log(Status.INFO,"Searcing for a Item");
			try {
				
				wait=new WebDriverWait(driver,Duration.ofSeconds(10));
				wait.until(ExpectedConditions.visibilityOfElementLocated(SearchObj.searchBox));
				SearchObj.searchElement().sendKeys(product,Keys.ENTER);
				logger1.addScreenCaptureFromPath(Capture.screenShot("SearchPage"));
				logger1.log(Status.PASS,"Searching for a Item is successful");
			}catch(Exception e) {
				logger1.log(Status.FAIL,"Searching for a Item is unsuccessful");
				throw new CustomizedExceptions("Error in searching Item:"+e.getMessage());
			}
			extent.flush();
		}
		//method to select the product from results (used auto suggest concept)
		public static void selectProduct(String item) throws CustomizedExceptions {
			extent.attachReporter(reporter);
			logger1=extent.createTest("Selecting Item ");
			logger1.log(Status.INFO,"Selecting Item ");
			try {
				
				Thread.sleep(9000);
				wait=new WebDriverWait(driver,Duration.ofSeconds(10));
				wait.until(ExpectedConditions.visibilityOfElementLocated(SearchObj.resultContainer));
		            List<WebElement> list = SearchObj.resultItems();
		            System.out.println(list.size());
		            for (int i = 0; i < list.size(); i++) {
		                if(list.get(i).getText().contains(item)) {
		                	list.get(i).click();
		                	break;
		                }
		            }
					logger1.log(Status.PASS,"Selecting Item is successful");
				}catch(Exception e) {
					logger1.log(Status.FAIL,"Selecting Item is unsuccessful");
					throw new CustomizedExceptions("Error in selecting product"+e.getMessage());
			}extent.flush();
			
	     }
		//method to add item from the results to the cart
		public static void addItemToCart() throws CustomizedExceptions {
			extent.attachReporter(reporter);
			logger1=extent.createTest("Adding Item to cart ");
			logger1.log(Status.INFO,"Adding Item to cart ");
			try {
				wait=new WebDriverWait(driver,Duration.ofSeconds(10));
				wait.until(ExpectedConditions.visibilityOfElementLocated(SearchObj.addToCartButton));
				SearchObj.addToCart().click();
				logger1.log(Status.PASS,"Adding Item to cart is successful");
			}catch(Exception e) {
				logger1.log(Status.FAIL,"Adding Item to cart is unsuccessful");
				throw new CustomizedExceptions("Error in adding Item to cart"+e.getMessage());
			}extent.flush();
			
		}
		//method to verify the added item in the cart 
		public static void verifyCart(String item) throws CustomizedExceptions {
		    extent.attachReporter(reporter);
		    logger1 = extent.createTest("Verifying Item in cart");
		    logger1.log(Status.INFO, "Verifying Item in cart");

		    try {
		    
		        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		        wait.until(ExpectedConditions.visibilityOfElementLocated(SearchObj.cartDiv));
		        List<WebElement> list = SearchObj.cartItems();
		        if (list.isEmpty()) { 
		            logger1.log(Status.FAIL, "Cart is empty, Item not found");
		            throw new CustomizedExceptions("Cart is empty, Item verification failed");
		        }
		        boolean itemFound = false;
		        for (WebElement element : list) {
		            if (element.getText().equals(item)) {
		                Assert.assertEquals(element.getText(), item);
		                System.out.println(element.getText());
		                itemFound = true;
		                break;
		            }
		        }
		        if (!itemFound) { 
		            logger1.log(Status.FAIL, "Item not found in the cart");
		            throw new CustomizedExceptions("Item '" + item + "' not found in cart");
		        }
		        logger1.log(Status.PASS, "Verifying Item in cart is successful");
		    } catch (Exception e) {
		        logger1.log(Status.FAIL, "Verifying Item in cart is unsuccessful");
		        throw new CustomizedExceptions("Error in verifying cart: " + e.getMessage());
		    } finally {
		        extent.flush();
		    }
		}
}
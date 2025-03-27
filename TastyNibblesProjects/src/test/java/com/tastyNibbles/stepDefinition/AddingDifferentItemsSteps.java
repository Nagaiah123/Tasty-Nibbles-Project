package com.tastyNibbles.stepDefinition;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.tastyNibbles.pages.AddingDifferentItemsPage;
import com.tastyNibbles.pages.SearchPage;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class AddingDifferentItemsSteps {
	 // Step definition for searching and adding two products to the cart
	@Then("User Search and add two products")
	public void user_search_and_add_two_products(DataTable dataTable) throws Exception {
		List<List<String>> credentials = credentials(
				"C:\\Users\\hi\\eclipse-workspace\\TastyNibblesProjects\\src\\test\\resources\\ItemsData.xlsx");
		dataTable = DataTable.create(credentials);
		SearchPage.searchProduct(dataTable.cell(0, 0));
		SearchPage.selectProduct(dataTable.cell(0, 0));
		SearchPage.addItemToCart();
		SearchPage.searchProduct(dataTable.cell(0, 1));
		SearchPage.selectProduct(dataTable.cell(0, 1));
		SearchPage.addItemToCart();
	}
	// Method to read product data from an Excel file and return it as a list
	public static List<List<String>> credentials(String excelFilePath) throws Exception {
		List<List<String>> credentials = new ArrayList<>();
		FileInputStream file = new FileInputStream(new File(excelFilePath));
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		Sheet sheet = workbook.getSheetAt(0);
		for (int i = 0; i <= sheet.getLastRowNum(); i++) {
			Row row = sheet.getRow(i);
			List<String> rowData = new ArrayList<>();
			if(row!=null) {
				for(int j=0;j<row.getLastCellNum();j++) {
					Cell cell=row.getCell(j);
					if(cell!=null) {
						rowData.add(cell.getStringCellValue());
					}else {
						rowData.add("");
					}
				}
			}
		credentials.add(rowData);
		}
	workbook.close();
	return credentials;
	}

	   // Step definition for verifying products and total price in the cart
	@Then("User Verifies the products and total price in the cart")
	public void user_verifies_the_products_and_total_price_in_the_cart(DataTable dataTable) throws Exception {
		List<List<String>> credentials = credentials(
				"C:\\Users\\hi\\eclipse-workspace\\TastyNibblesProjects\\src\\test\\resources\\ItemsData.xlsx");
		dataTable = DataTable.create(credentials);
		SearchPage.verifyCart(dataTable.cell(0, 0));
		SearchPage.verifyCart(dataTable.cell(0, 1));
		AddingDifferentItemsPage.verifyPrices();
	}
	
	 // Step definition for navigating to the cart
	@And("User Navigates to Cart")
	public void user_navigates_to_cart() throws InterruptedException {
		AddingDifferentItemsPage.navigateToCart();
	}

}
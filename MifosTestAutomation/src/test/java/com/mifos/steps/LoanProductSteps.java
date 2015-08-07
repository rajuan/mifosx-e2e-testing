package com.mifos.steps;

import java.util.List;

import com.mifos.pages.FrontPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;


public class LoanProductSteps {

	public String productExcelSheetPath = null;
	final public FrontPage varFrontPage = new FrontPage();

	@Given("^I setup the product loan \"([^\"]*)\"$")
	public void I_setup_the_product_loan(String sheetName,
			List<String> excelSheetName) throws Throwable {
		productExcelSheetPath = varFrontPage.getProductExcelSheetPath();
		
		varFrontPage.productNavigation(productExcelSheetPath, excelSheetName,
				sheetName);
	}

	@Then("^I entered the values into product loan from \"([^\"]*)\" Sheet$")
	public void I_entered_the_values_into_product_loan_from_Sheet_Verified(
			String sheetName, List<String> excelSheet) throws Throwable {
		String excelSheetName = excelSheet.get(0).toString();
		varFrontPage.setupLoanProduct(productExcelSheetPath, excelSheetName,
				sheetName);
	}
	
	@Then("^I should see product loan created successfully	from \"([^\"]*)\" Sheet$")
	public void I_should_see_product_loan_created_successfully_from_Sheet(
			String sheetName, List<String> excelSheet) throws Throwable {
		String excelSheetName = excelSheet.get(0).toString();
		varFrontPage.verifyProduct(productExcelSheetPath, excelSheetName, sheetName);

	}

}
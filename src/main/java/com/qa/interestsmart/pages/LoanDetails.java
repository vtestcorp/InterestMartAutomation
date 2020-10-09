package com.qa.interestsmart.pages;

import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.qa.interestsmart.base.BasePage;
import com.qa.interestsmart.utils.Calculate;
import com.qa.interestsmart.utils.CommonUtil;
import com.qa.interestsmart.utils.Constants;
import com.qa.interestsmart.utils.ElementUtil;
import com.qa.interestsmart.utils.JavaScriptUtil;
import com.qa.interestsmart.utils.Keyboard;

import config.DefineConstants;

public class LoanDetails extends BasePage {

	private static final Logger logger = LogManager.getLogger(LoanDetails.class);
	SoftAssert softAssert = new SoftAssert();
	private WebDriver driver;
	ElementUtil elementUtil;
	Properties prop;
	private ExtentTest test;

	private JavaScriptUtil javascriptutil;

	// Basic Information
	private By SSN = By.xpath("//input[@id='ssn_1']");

	private By DOB = By.xpath("//input[@id='dob_1']");
	private By yearsInSchool = By.xpath("//span[@id='select2-years_in_school_1-container']");
	private By yearsInSchoolSearch = By.xpath("//input[@class='select2-search__field']");
	private By maritalStatus = By.xpath("//span[@id='select2-maritial_status_1-container']");
	private By maritalStatusSearch = By.xpath("//input[@class='select2-search__field']");
	private By dependents = By.xpath("//input[@id='dependents_num_1']");
	private By dependentsAge = By.xpath("//input[@id='dependents_ages_1']");

	// Address Information

	private By yearsOfAddress = By.xpath("//span[@id='select2-years_at_address_1-container']");
	private By yearsOfAddressSearch = By.xpath("//input[@class='select2-search__field']");
	private By monthsAtAddress = By.xpath("//span[@id='select2-months_at_address_1-container']");
	private By monthsAtAddressSearch = By.xpath("//input[@class='select2-search__field']");
	private By Address = By.xpath("//input[@id='current_address_1']");
	private By City = By.xpath("//input[@id='current_city_1']");
	private By state = By.xpath("//input[@id='state']");
	private By zipCode = By.xpath("//input[@id='current_zip_1']");
	private By nextButton = By
			.xpath("//div[@id='first_borrower']//button[@class='btn btn--medium btn--fill'][contains(text(),'Next')]");

	// Income
	private By typeOFProperty = By.xpath("//span[@id='select2-property_type-container']");
	private By typeOFPropertySearch = By.xpath("//input[@class='select2-search__field']");
	private WebElement areYouSelfEmployed;
	private By monthlyIncome = By.xpath("//div[contains(text(),'Are you self-employed?')]//following::input[4]");

	// Income Source
	private By employerName = By.xpath("//input[@id='emp_name_1']");
	private By businessPhone = By.xpath("//input[@id='emp_phone_1']");
	private By Position = By.xpath("//input[@id='emp_position_1']");;
	private By yearsATheJob = By.xpath("//span[@id='select2-emp_years_1-container']");
	private By yearsATheJobSearch = By.xpath("//input[@class='select2-search__field']");
	private By yearsInLineOfWork = By.xpath("//span[@id='select2-emp_years_in_line_of_work_1-container']");
	private By yearsInLineOfWorkSearch = By.xpath("//input[@class='select2-search__field']");
	private By employerAddress = By.xpath("//input[@id='emp_address_1']");
	private By city = By.xpath("//input[@id='emp_city_1']");
	private By State = By.xpath("//span[@id='select2-emp_state_1-container']");
	private By stateSearch = By.xpath("//input[@class='select2-search__field']");
	private By zipCode1 = By.xpath("//input[@id='emp_zip_1']");
	private By nextButtonIncome = By.xpath("//button[@id='formSubmit']");

	// Assets
	private By assetType = By.xpath("//label[contains(text(),'Asset Name')]//preceding::span[2]");
	private By assetTypeSearch = By.xpath("//input[@class='select2-search__field']");
	private By assetName = By.xpath("//label[contains(text(),'Asset Name')]//following::input[1]");
	private By assetValue = By.xpath("//label[contains(text(),'Asset Value')]//following::input[1]");
	private WebElement plansForThisProperty;
	private By propertyType = By.xpath("//label[contains(text(),'Property Type')]//following::span[1]");
	private By propertyTypeSearch = By.xpath("//input[@class='select2-search__field']");
	private By nextButtonAssests = By.xpath("//button[@class='btn btn--medium btn--fill']");

	// Declarations
	private WebElement AreThereAnyOutstandingJudgmentsAgainstYou;
	private WebElement HaveYouBeenDeclaredBankruptWithinThePast7Years;
	private WebElement HaveYouHadPropertyForeclosedUponOrGivenTitleOrDeedInLieuThereofInTheLast7Years;
	private WebElement Are_you_a_party_to_a_lawsuit;
	private WebElement Have_you_directly_or_indirectly_been_obligated_on_any_loan_which_resulted_in_foreclosure_transfer_of_title_in_lieu_of_foreclosure_or_judgment;
	private WebElement Are_you_presently_delinquent_or_in_default_on_any_Federal_debt_or_any_other_loan_mortgage_financial_obligation_bond_or_loan_guarantee;
	private WebElement Are_you_obligated_to_pay_alimony_child_support_or_separate_maintenance;
	private WebElement Is_any_part_of_the_down_payment_borrowed;
	private WebElement Are_you_a_comaker_or_endorser_on_a_note;
	private WebElement Are_you_a_US_citizen;
	private WebElement Do_you_intend_to_occupy_the_property_as_your_primary_residence;
	private WebElement Have_you_had_an_ownership_interest_in_a_property_in_the_last_three_years;
	private By nextButtonDeclaration = By.xpath("//button[@class='btn btn--medium btn--fill']");

	// Documents
	private By driversLicenseButton = By
			.xpath("//div[contains(@class,'documents__name driver_license')]//following::a[1]");
	private By driversLicenseUpload = By
			.xpath("//form[@id='driver_license']//p[contains(text(),'Drop Files Here or Click to Upload')]");

	private By paystubsButton = By.xpath("//div[contains(@class,'documents__name paystub')]//following::a[1]");
	private By paystubsUpload = By
			.xpath("//form[@id='paystub']//p[contains(text(),'Drop Files Here or Click to Upload')]");

	private By W2sButton = By.xpath("//div[contains(@class,'documents__name w2s')]//following::a[1]");
	private By W2sUpload = By.xpath("//form[@id='w2s']//p[contains(text(),'Drop Files Here or Click to Upload')]");

	private By taxReturnsButton = By
			.xpath("//div[contains(@class,'documents__name tax_return_home')]//following::a[1]");
	private By taxReturnsUpload = By
			.xpath("//form[@id='tax_return_home']//p[contains(text(),'Drop Files Here or Click to Upload')]");

	private By bankStatementsButton = By
			.xpath("//div[contains(@class,'documents__name bank_statement')]//following::a[1]");
	private By bankStatementsUpload = By
			.xpath("//form[@id='bank_statement']//p[contains(text(),'Drop Files Here or Click to Upload')]");

	private By IRA_ETC_401KButton = By.xpath("//div[contains(@class,'documents__name other')]//following::a[1]");
	private By IRA_ETC_401KUpload = By
			.xpath("//form[@id='other']//p[contains(text(),'Drop Files Here or Click to Upload')]");

	private By finishButtonDocuments = By.xpath("//button[@id='finishBtn']");

	private By applicationSubmitted = By
			.xpath("//p[contains(text(),'Your application has been successfully Submitted. ')]");

	// Constructor of the page
	public LoanDetails(WebDriver driver, ExtentTest test) {
		elementUtil = new ElementUtil(driver);
		this.driver = driver;
		prop = super.init_prop();
		softAssert = new SoftAssert();
		javascriptutil = new JavaScriptUtil(driver);
		this.test = test;
	}

	// Actions:

	public void enterSSN(String inputSSN) {
		try {
			elementUtil.doSendKeys(SSN, inputSSN);
			// test.log(Status.INFO, "User entered "+inputSSN);
			Thread.sleep(3000L);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void enterDOB(String inputDOB) {
		try {
			elementUtil.doActionsSendKeys(DOB, inputDOB);
			Thread.sleep(3000L);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void enterYearsInSchool(String inputYearsInSchool) {
		try {
			elementUtil.clickWhenReady(yearsInSchool, 10);
			elementUtil.doActionsSendKeys(yearsInSchoolSearch, inputYearsInSchool);
			elementUtil.pressEnter(yearsInSchoolSearch);
			Thread.sleep(3000L);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void enterMaritalStatus(String inputMaritalStatus) {
		try {
			elementUtil.clickWhenReady(maritalStatus, 10);
			elementUtil.doActionsSendKeys(maritalStatusSearch, inputMaritalStatus);
			elementUtil.pressEnter(maritalStatusSearch);
			Thread.sleep(3000L);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void enterDependents(String inputDependents) {
		try {
			elementUtil.clearField(dependents);
			elementUtil.doActionsSendKeys(dependents, inputDependents);
			Thread.sleep(3000L);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void enterDependentsAge(String inputDependentsAge) {
		try {
			elementUtil.clearField(dependentsAge);
			elementUtil.doActionsSendKeys(dependentsAge, inputDependentsAge);
			Thread.sleep(3000L);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void enterYearsOfAddress(String inputYearsOfAddress) {
		try {
			elementUtil.clickWhenReady(yearsOfAddress, 10);
			elementUtil.doActionsSendKeys(yearsOfAddressSearch, inputYearsOfAddress);
			elementUtil.pressEnter(yearsOfAddressSearch);
			Thread.sleep(3000L);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void enterMonthAtAddress(String inputMonthAtAddress) {
		try {
			elementUtil.clickWhenReady(monthsAtAddress, 10);
			elementUtil.doActionsSendKeys(monthsAtAddressSearch, inputMonthAtAddress);
			elementUtil.pressEnter(monthsAtAddressSearch);
			Thread.sleep(3000L);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void clickNextButton() {
		try {
			elementUtil.doClick(nextButton);
			Thread.sleep(3000L);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void enterTypeOfProperty(String inputTypeOfProperty) {
		try {
			elementUtil.clickWhenReady(typeOFProperty, 10);
			elementUtil.doActionsSendKeys(typeOFPropertySearch, inputTypeOfProperty);
			elementUtil.pressEnter(typeOFPropertySearch);
			Thread.sleep(3000L);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void select_AreYouSelfEmployed(String inputAreYouSelfEmployed) {
		try {
			Thread.sleep(3000L);
			areYouSelfEmployed = driver.findElement(
					By.xpath("//div[contains(text(),'Are you self-employed?')]//following::label[contains(text(),'"
							+ inputAreYouSelfEmployed + "')]"));

			areYouSelfEmployed.click();
			Thread.sleep(3000L);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void enter_MonthlyIncome(String inputMonthlyIncome) {
		try {
			// elementUtil.doClick(monthlyIncome);
			// javascriptutil.clickElementByJS(monthlyIncome);
			// elementUtil.clearField(monthlyIncome);
			// javascriptutil.sendKeysUsingJSWithXpath(monthlyIncome,
			// inputMonthlyIncome);

			elementUtil.doSendKeys(monthlyIncome, inputMonthlyIncome);
			Thread.sleep(3000L);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void enter_EmployerName(String inputEmployerName) {
		try {
			elementUtil.clearField(employerName);
			elementUtil.doSendKeys(employerName, inputEmployerName);
			Thread.sleep(3000L);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void enter_BusinessPhone(String inputBusinessPhone) {
		try {
			elementUtil.clearField(businessPhone);
			elementUtil.doSendKeys(businessPhone, inputBusinessPhone);
			Thread.sleep(3000L);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void enter_Position(String inputPosition) {
		try {
			elementUtil.clearField(Position);
			elementUtil.doSendKeys(Position, inputPosition);
			Thread.sleep(3000L);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void enter_YearsAtJob(String inputYearsAtJob) {
		try {
			elementUtil.clickWhenReady(yearsATheJob, 10);
			elementUtil.doSendKeys(yearsATheJobSearch, inputYearsAtJob);
			elementUtil.pressEnter(yearsATheJobSearch);
			Thread.sleep(3000L);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void enter_YearsInLineOfWork(String inputYearsInLineOfWork) {
		try {
			elementUtil.clickWhenReady(yearsInLineOfWork, 10);
			elementUtil.doSendKeys(yearsInLineOfWorkSearch, inputYearsInLineOfWork);
			elementUtil.pressEnter(yearsInLineOfWorkSearch);
			Thread.sleep(3000L);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void enter_EmployerAddress(String inputEmployerAddress) {
		try {
			elementUtil.clearField(employerAddress);
			elementUtil.doSendKeys(employerAddress, inputEmployerAddress);
			Thread.sleep(3000L);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void enter_City(String inputCity) {
		try {
			elementUtil.clearField(city);
			elementUtil.doSendKeys(city, inputCity);
			Thread.sleep(3000L);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void enter_State(String inputState) {
		try {
			elementUtil.clickWhenReady(State, 10);
			elementUtil.doSendKeys(stateSearch, inputState);
			elementUtil.pressEnter(stateSearch);
			Thread.sleep(3000L);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void enter_ZipCode(String inputZipCode) {
		try {
			elementUtil.clearField(zipCode1);
			elementUtil.doSendKeys(zipCode1, inputZipCode);
			Thread.sleep(3000L);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void clickIncomeNextButton() {
		try {
			elementUtil.doClick(nextButtonIncome);
			Thread.sleep(3000L);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void enter_AssestsType(String inputAssestsType) {
		try {
			Thread.sleep(3000L);
			elementUtil.clickWhenReady(assetType, 50);
			// javascriptutil.clickElementByJS(driver.findElement(assetType));
			elementUtil.doSendKeys(assetTypeSearch, inputAssestsType);
			elementUtil.pressEnter(assetTypeSearch);
			Thread.sleep(3000L);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void enter_AssestsName(String inputAssestsName) {
		try {
			elementUtil.clearField(assetName);
			elementUtil.doSendKeys(assetName, inputAssestsName);
			Thread.sleep(3000L);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void enter_AssestsValue(String inputAssestsValue) {
		try {
			elementUtil.clearField(assetValue);
			elementUtil.doSendKeys(assetValue, inputAssestsValue);
			Thread.sleep(3000L);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void select_PlansForThisProperty(String input_PlansForThisProperty) {
		try {
			plansForThisProperty = driver
					.findElement(By.xpath("//label[contains(text(),'" + input_PlansForThisProperty + "')]"));
			plansForThisProperty.click();
			Thread.sleep(3000L);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void enter_AssestsPropertyType(String input_AssestsPropertyType) {
		try {
			elementUtil.clickWhenReady(propertyType, 10);
			elementUtil.doSendKeys(propertyTypeSearch, input_AssestsPropertyType);
			elementUtil.pressEnter(propertyTypeSearch);
			Thread.sleep(3000L);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void clickAssestsNextButton() {
		try {
			elementUtil.doClick(nextButtonAssests);
			Thread.sleep(3000L);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void question_1(String input_Yes_No) {
		try {
			AreThereAnyOutstandingJudgmentsAgainstYou = driver.findElement(By
					.xpath("//div[@class='form-group form-group--border outstanding_judgement_1_parent']//label[contains(text(),'"
							+ input_Yes_No + "')]"));
			AreThereAnyOutstandingJudgmentsAgainstYou.click();
			Thread.sleep(3000L);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void question_2(String input_Yes_No) {
		try {
			HaveYouBeenDeclaredBankruptWithinThePast7Years = driver.findElement(By
					.xpath("//div[@class='form-group form-group--border declared_bankrupt_past_7_years_1_parent']//label[contains(text(),'"
							+ input_Yes_No + "')]"));
			HaveYouBeenDeclaredBankruptWithinThePast7Years.click();
			Thread.sleep(3000L);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void question_3(String input_Yes_No) {
		try {
			HaveYouHadPropertyForeclosedUponOrGivenTitleOrDeedInLieuThereofInTheLast7Years = driver.findElement(By
					.xpath("//div[@class='form-group form-group--border foreclosed_property_1_parent']//label[contains(text(),'"
							+ input_Yes_No + "')]"));
			HaveYouHadPropertyForeclosedUponOrGivenTitleOrDeedInLieuThereofInTheLast7Years.click();
			Thread.sleep(3000L);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void question_4(String input_Yes_No) {
		try {
			Are_you_a_party_to_a_lawsuit = driver.findElement(
					By.xpath("//div[@class='form-group form-group--border lawsuit_1_parent']//label[contains(text(),'"
							+ input_Yes_No + "')]"));
			Are_you_a_party_to_a_lawsuit.click();
			Thread.sleep(3000L);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void question_5(String input_Yes_No) {
		try {
			Have_you_directly_or_indirectly_been_obligated_on_any_loan_which_resulted_in_foreclosure_transfer_of_title_in_lieu_of_foreclosure_or_judgment = driver
					.findElement(By
							.xpath("//div[@class='form-group form-group--border obligated_loan_1_parent']//label[contains(text(),'"
									+ input_Yes_No + "')]"));
			Have_you_directly_or_indirectly_been_obligated_on_any_loan_which_resulted_in_foreclosure_transfer_of_title_in_lieu_of_foreclosure_or_judgment
					.click();
			Thread.sleep(3000L);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void question_6(String input_Yes_No) {
		try {
			Are_you_presently_delinquent_or_in_default_on_any_Federal_debt_or_any_other_loan_mortgage_financial_obligation_bond_or_loan_guarantee = driver
					.findElement(By
							.xpath("//div[@class='form-group form-group--border default_federal_debt_1_parent']//label[contains(text(),'"
									+ input_Yes_No + "')]"));
			Are_you_presently_delinquent_or_in_default_on_any_Federal_debt_or_any_other_loan_mortgage_financial_obligation_bond_or_loan_guarantee
					.click();
			Thread.sleep(3000L);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void question_7(String input_Yes_No) {
		try {
			Are_you_obligated_to_pay_alimony_child_support_or_separate_maintenance = driver.findElement(
					By.xpath("//div[@class='form-group form-group--border alimony_1_parent']//label[contains(text(),'"
							+ input_Yes_No + "')]"));
			Are_you_obligated_to_pay_alimony_child_support_or_separate_maintenance.click();
			Thread.sleep(3000L);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void question_8(String input_Yes_No) {
		try {
			Is_any_part_of_the_down_payment_borrowed = driver.findElement(By
					.xpath("//div[@class='form-group form-group--border down_payment_1_parent']//label[contains(text(),'"
							+ input_Yes_No + "')]"));
			Is_any_part_of_the_down_payment_borrowed.click();
			Thread.sleep(3000L);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void question_9(String input_Yes_No) {
		try {
			Are_you_a_comaker_or_endorser_on_a_note = driver.findElement(By
					.xpath("//div[@class='form-group form-group--border co_maker_or_endorser_1_parent']//label[contains(text(),'"
							+ input_Yes_No + "')]"));
			Are_you_a_comaker_or_endorser_on_a_note.click();
			Thread.sleep(3000L);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void question_10(String input_Yes_No) {
		try {
			Are_you_a_US_citizen = driver.findElement(By
					.xpath("//div[@class='form-group form-group--border us_citizen_1_parent']//label[contains(text(),'"
							+ input_Yes_No + "')]"));
			Are_you_a_US_citizen.click();
			Thread.sleep(3000L);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void question_11(String input_Yes_No) {
		try {
			Do_you_intend_to_occupy_the_property_as_your_primary_residence = driver.findElement(By
					.xpath("//div[@class='form-group form-group--border primary_residence_1_parent']//label[contains(text(),'"
							+ input_Yes_No + "')]"));
			Do_you_intend_to_occupy_the_property_as_your_primary_residence.click();
			Thread.sleep(3000L);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void question_12(String input_Yes_No) {
		try {
			Have_you_had_an_ownership_interest_in_a_property_in_the_last_three_years = driver.findElement(By
					.xpath("//div[@class='form-group form-group--border ownership_interest_1_parent']//label[contains(text(),'"
							+ input_Yes_No + "')]"));
			Have_you_had_an_ownership_interest_in_a_property_in_the_last_three_years.click();
			Thread.sleep(3000L);
			// test.log(Status.INFO, "User selected "+input_Yes_No);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void clickDeclarationNextButton() {
		try {
			elementUtil.doClick(nextButtonDeclaration);
			Thread.sleep(3000L);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	

	public void uploadDriverLicense(String filePath) {
		try {
			elementUtil.doClick(driversLicenseButton);
			elementUtil.doActionsClick(driversLicenseUpload);
			Keyboard.uploadFileWithRobot(filePath);
			Thread.sleep(3000L);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void uploadPaystubs(String filePath) {
		try {
			elementUtil.doClick(paystubsButton);
			elementUtil.doActionsClick(paystubsUpload);
			Keyboard.uploadFileWithRobot(filePath);
			Thread.sleep(3000L);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void uploadW2s(String filePath) {
		try {
			elementUtil.doClick(W2sButton);
			elementUtil.doActionsClick(W2sUpload);
			Keyboard.uploadFileWithRobot(filePath);
			Thread.sleep(3000L);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void uploadTaxReturns(String filePath) {
		try {
			elementUtil.doClick(taxReturnsButton);
			elementUtil.doActionsClick(taxReturnsUpload);
			Keyboard.uploadFileWithRobot(filePath);
			Thread.sleep(3000L);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void uploadBankStatements(String filePath) {
		try {
			elementUtil.doClick(bankStatementsButton);
			elementUtil.doActionsClick(bankStatementsUpload);
			Keyboard.uploadFileWithRobot(filePath);
			Thread.sleep(3000L);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void uploadIRA(String filePath) {
		try {
			elementUtil.doClick(IRA_ETC_401KButton);
			elementUtil.doActionsClick(IRA_ETC_401KUpload);
			Keyboard.uploadFileWithRobot(filePath);
			Thread.sleep(3000L);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void clickFinishDocuments() {
		try {
			elementUtil.doClick(finishButtonDocuments);
			Thread.sleep(3000L);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void verify_ApplicationSubmitted() {
		try {
			
			if (elementUtil.doIsDisplayed(applicationSubmitted)) {
				System.out.println(driver.findElement(applicationSubmitted).getText()+ " value is verified");
				Assert.assertEquals(driver.findElement(applicationSubmitted).getText(),
						Constants.applicationSubmittedText);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

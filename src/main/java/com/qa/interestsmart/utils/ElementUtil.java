package com.qa.interestsmart.utils;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.interestsmart.base.BasePage;

public class ElementUtil {
	
	WebDriver driver;
	JavaScriptUtil jsUtil;

	public ElementUtil(WebDriver driver) {
		this.driver = driver;
		jsUtil = new JavaScriptUtil(driver);
	}

	/**
	 * this is used to create the webelement on the basis of given By locator
	 * 
	 * @param locator
	 * @return webelement
	 */
	public WebElement getElement(By locator) {
		WebElement element = driver.findElement(locator);
		if(Boolean.parseBoolean(BasePage.flashElement)) jsUtil.flash(element);
		return element;
	}
	
	public List<WebElement> getListOfElements(By locator)
	{
		List<WebElement> elementList = driver.findElements(locator);
		return elementList;
	}

	public void doSendKeys(By locator, String value) {
		getElement(locator).sendKeys(value);
	}
	
	public void clearField(By locator) {
		getElement(locator).clear();
	}

	public void pressEnter(By locator) {
		getElement(locator).sendKeys(Keys.ENTER);
	}
	
	
	public void doClick(By locator) {
		getElement(locator).click();
	}

	public void doActionsSendKeys(By locator, String value) {
		Actions act = new Actions(driver);
		act.sendKeys(getElement(locator), value).perform();
	}

	public void doActionsClick(By locator) {
		Actions act = new Actions(driver);
		act.click(getElement(locator)).perform();
	}

	public String doGetText(By locator) {
		return getElement(locator).getText();
	}

	public boolean doIsDisplayed(By locator) {
		return getElement(locator).isDisplayed();
	}

	public void doLinkClick(List<WebElement> linksList, String value) {
		System.out.println(linksList.size());
		for (WebElement ele : linksList) {
			String text = ele.getText();
			System.out.println(text);

			if (text.equals(value)) {
				ele.click();
				break;
			}
		}
	}

	// ****************************drop down
	// utils********************************
	public void selectDropDownValueByVisibleText(By locator, String value) {
		Select select = new Select(getElement(locator));
		select.selectByVisibleText(value);
	}

	public void selectDropDownValueByIndex(By locator, int index) {
		Select select = new Select(getElement(locator));
		select.selectByIndex(index);
	}

	public void selectDropDownValueByValue(By locator, String value) {
		Select select = new Select(getElement(locator));
		select.selectByValue(value);
	}

	public int getDropDownOptionsCount(By locator) {
		Select select = new Select(getElement(locator));
		List<WebElement> optionsList = select.getOptions();
		return optionsList.size();
	}

	public List<String> getDropDownOptionsValues(By locator) {
		List<String> textList = new ArrayList<String>();
		Select select = new Select(getElement(locator));
		List<WebElement> optionsList = select.getOptions();

		for (WebElement ele : optionsList) {
			String text = ele.getText();
			textList.add(text);
		}

		return textList;
	}

	public void selectValueFromDropDownWithOutSelect(By locator, String value) {
		List<WebElement> countryList = driver.findElements(locator);

		for (WebElement ele : countryList) {
			String text = ele.getText();
			System.out.println(text);
			if (text.equals(value)) {
				ele.click();
				break;
			}
		}
	}

	// *****************************wait utils
	// ************************************

	public List<WebElement> visibilityofAllElements(By locator, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
	}
	
	public Boolean invisibilityofAllElements(By locator, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		return wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
	}

	public void getPageLinksText(By locator, int timeOut) {
		visibilityofAllElements(locator, timeOut).stream().forEach(ele -> System.out.println(ele.getText()));
	}

	public WebElement waitForElementPresent(By locator, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));

	}

	public String waitForTitlePresent(String titleValue, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		wait.until(ExpectedConditions.titleIs(titleValue));
		return driver.getTitle();
	}

	public WebElement waitForElementToBeVisible(By locator, int timeOut) {
		WebElement element = getElement(locator);
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		return wait.until(ExpectedConditions.visibilityOf(element));

	}

	public boolean waitForUrl(String url, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		return wait.until(ExpectedConditions.urlContains(url));
	}

	public Alert waitForAlertToBePresent(int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		return wait.until(ExpectedConditions.alertIsPresent());
	}

	public WebElement waitForElementToBeClickable(By locator, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		return wait.until(ExpectedConditions.elementToBeClickable(locator));
	}

	public void clickWhenReady(By locator, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
		element.click();
	}

	public WebElement waitForElementWithFluentWait(By locator, int timeOut, int interval) {

		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(timeOut))
				.pollingEvery(Duration.ofSeconds(interval))
				.ignoring(NoSuchElementException.class);

		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));

	}
	
	public String getCurrentPageUrl()
	{
		return driver.getCurrentUrl();
	}
	
	/**
	 * This method waits for the frameToBeAvailableAndSwitchToIt
	 * condition of the frame on the WebElement
	 * @param locator
	 */
	public void waitForFramePresentAndSwitchToIt(By locator, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(locator));
	}
	
	/**
	 * This method waits for the frameToBeAvailableAndSwitchToIt
	 * condition of the frame on the WebElement
	 * @param locator
	 */
	public void waitForWindowPresentAndSwitchToIt(int expectedNumberOfWindows ,int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		wait.until(ExpectedConditions.numberOfWindowsToBe(expectedNumberOfWindows));
	}
	
	/**
	 * This method switch to the parent frame
	 */
	public void switchToParentFrame() {
		driver.switchTo().parentFrame();
	}
	
	/**
	 * This method switch to the default/main frame
	 */
	public void switchToDefaultMainFrame() {
		driver.switchTo().defaultContent();
	}
	
	/**
	 * This method fetches window handles available
	 * for the current situation on the browser
	 * @param driver
	 * @return listOfString
	 */
	public List<String> getWindowList(WebDriver driver)
	{
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> windowHandlesList = new ArrayList<String>(windowHandles);
		return windowHandlesList;
	}
	
	/**
	 * This method switches to the given window id
	 * in the parameter
	 * @param driver
	 * @param windowNumber
	 */
	public void switchToWindowId(WebDriver driver, int windowNumber)
	{
		List<String> windowList = getWindowList(driver);
		driver.switchTo().window(windowList.get(windowNumber));
	}
	
}

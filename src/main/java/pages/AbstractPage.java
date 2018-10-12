package pages;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * Created by Nuggy Santoso on 10/12/2018
 */
public abstract class AbstractPage {
    protected WebDriver webDriver;
    StringBuilder stringBuilder = new StringBuilder();
    Random randomGenerator = new Random();

    public AbstractPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    protected void assertTitlePageIsEquals(String expected) {
        String actual = webDriver.getTitle();
        assertEquals("Failed : " + actual + " Not Equals With " + expected, expected, actual);
    }

    protected void assertTrue(String message, boolean condition) {
        Assert.assertTrue(message, condition);
    }

    protected void assertEquals(String message, String expected, String actual) {
        Assert.assertEquals(message, expected, actual);
    }

    protected void assertTextElementIsEquals(WebElement webElement, String expected) {
        String actual = getTextOrValueElement(webElement);
        assertEquals("Failed : " + actual + " Not Equals With " + expected, expected, actual);
    }

    protected void assertElementIsDisplayed(WebElement webElement) {
        assertTrue("Failed : " + webElement.toString() + " Is Not Displayed", isElementPresent(webElement));
    }

    protected void clickElement(WebElement webElement) {
        assertElementIsDisplayed(webElement);
        webElement.click();
    }

    protected void inputTextToElement(WebElement webElement, String textToInput) {
        assertElementIsDisplayed(webElement);
        webElement.sendKeys(textToInput);
    }

    protected void setValueToElement(WebElement webElement, String textToInput){
        assertElementIsDisplayed(webElement);
        ((JavascriptExecutor)webDriver).executeScript("arguments[0].innerHTML = '"+ textToInput +"'", webElement);
    }

    protected String getTextOrValueElement(WebElement webElement) {
        assertElementIsDisplayed(webElement);
        return webElement.getText();
    }

    protected Boolean isElementPresent(WebElement webElement) {
        return webElement.isDisplayed();
    }

    protected void waitForPresenceOfElementByXpath(String xpath) {
        WebDriverWait wait = new WebDriverWait(webDriver, 15);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
    }

    protected void waitForPresenceOfElementById(String id) {
        WebDriverWait wait = new WebDriverWait(webDriver, 15);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(id)));
    }

    protected void waitForPresenceOfElementById(String id, int timeout) {
        WebDriverWait wait = new WebDriverWait(webDriver, timeout);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(id)));
    }

    protected void waitForPresenceOfElementByCssSelector(String cssSelector) {
        WebDriverWait wait = new WebDriverWait(webDriver, 15);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(cssSelector)));
    }

    protected void waitForDissapearOfElementByXpath(String xPatb) {
        WebDriverWait wait = new WebDriverWait(webDriver, 15);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(xPatb)));
    }

    protected WebElement getElementById(String id) {
        return webDriver.findElement(By.id(id));
    }

    protected WebElement getElementByCssSelector(String cssSelector) {
        return webDriver.findElement(By.cssSelector(cssSelector));
    }

    protected WebElement getElementByXPath(String xPath) {
        return webDriver.findElement(By.xpath(xPath));
    }

    protected String getRandomNumberGenerator(int amountNumber){
        for (int i = 0; i <= amountNumber; i++){
            int randomInt = randomGenerator.nextInt(10);
            stringBuilder.append(randomInt);
        }
        return stringBuilder.toString();
    }

    public void delayThread(int timeoutSecond) {
        try {
            TimeUnit.SECONDS.sleep(timeoutSecond);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public void selectDropDownByVisibleText(WebElement webElement, String valueToSelect){
        Select select = new Select(webElement);
        List<WebElement> options = select.getOptions();
        for(WebElement item:options)
        {
            if (item.getText().contains(valueToSelect)){
                select.selectByVisibleText(item.getText());
                break;
            }
        }
    }

    public String getRandomStringGenerator(int length){
        boolean useLetters = true;
        boolean useNumbers = true;
        return RandomStringUtils.random(length, useLetters, useNumbers);
    }
}

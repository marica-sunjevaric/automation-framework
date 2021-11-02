package tests;

import base.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.net.MalformedURLException;
import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

public class TestBase {

    public ThreadLocal<WebDriver> driver = new ThreadLocal<>();

//    BEFOR TEST
    @BeforeMethod(alwaysRun = true)
    public void setUp() throws MalformedURLException {
        driver.set(DriverFactory.initDriver());
    }

//    AFTER TEST
    @AfterMethod(alwaysRun = true)
    public void afterTest(ITestResult result) {
        driver.get().quit();
        driver.set(null);
    }

//    HELP METHODS
    /**
     * Initialize WebElement multiple times
     * @param selector
     * @return WebElement
     * @throws InterruptedException
     */
    public WebElement tryToInitializeElementMultipleTimes(By selector) throws InterruptedException {
        WebElement element = null;
        for (int i = 0; i < 20;) {
            try {
                element = driver.get().findElement(selector);
                break;
            } catch (Exception e) {
                e.printStackTrace();
                Thread.sleep(300);
                i++;
            }
        }
        return element;
    }

    /**
     * Waiting for WebElement
     * @param selector
     * @throws InterruptedException
     */
    public void waitForElementWithSelector (By selector) throws InterruptedException {
        NoSuchElementException noSuchElementException = new NoSuchElementException();
        for (int i = 0; i < 200; ) {
            try {
                WebElement element = driver.get().findElement(selector);
                return;
            } catch (Exception e) {
                e.printStackTrace();
                Thread.sleep(300);
                i++;
            }
        }
        throw noSuchElementException;
    }

    /**
     * Finding WebElement in List of WebElements by String
     * @param elementName
     * @param listOfElements
     * @return WebElement
     */
    public WebElement findElementFromListByString(String elementName, List<WebElement> listOfElements) { //try some other way
        WebElement desiredElement = null;
        for (int i = 0; i < listOfElements.size(); i++) {
            if (listOfElements.get(i).getText().equals(elementName)) {
                desiredElement = listOfElements.get(i);
                break;
            }
        }
        return desiredElement;
    }

    /**
     * Waiting for WebElement to be clickable
     * @param element
     * @param timeOutInSeconds
     */
    public void waitForElementToBeClickable (WebElement element, long timeOutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver.get(), timeOutInSeconds);
        wait.withTimeout(Duration.ofSeconds(timeOutInSeconds));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    /**
     * Waiting for WebElement and click
     * @param element
     * @param timeOutInSeconds
     */
    public void waitForElementAndClick (WebElement element, long timeOutInSeconds) {
        waitForElementToBeClickable(element, timeOutInSeconds);
        element.click();
    }

    /**
     * Waiting for WebElement to be visible
     * @param element
     * @param timeOutInSeconds
     */
    public void waitForElementToBeVisible(WebElement element, long timeOutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver.get(), timeOutInSeconds);
        wait.withTimeout(Duration.ofSeconds(timeOutInSeconds));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    /**
     * Waiting for WebElement
     * @param element
     * @param timeOutInSeconds
     */
    public void waitForElement(WebElement element, int timeOutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver.get(), timeOutInSeconds);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    /**
     * Waiting for WebElement invisibility
     * @param element
     */
    public void waitForElementInvisibilityLocatedBy(By element) {
        WebDriverWait wait = new WebDriverWait(driver.get(), 15);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(element));
    }
}

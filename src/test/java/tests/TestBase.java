package tests;

import base.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.net.MalformedURLException;

public class TestBase {

    public ThreadLocal<WebDriver> driver = new ThreadLocal<>();

//    Before test
    @BeforeMethod(alwaysRun = true)
    public void setUp() throws MalformedURLException {
        driver.set(DriverFactory.initDriver());
    }

//    After test
    @AfterMethod(alwaysRun = true)
    public void afterTest(ITestResult result) {
        driver.get().quit();
        driver.set(null);
    }

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
}

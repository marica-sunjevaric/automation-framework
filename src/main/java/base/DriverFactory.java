package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class DriverFactory {

    public static WebDriver initDriver() throws MalformedURLException {

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setBrowserName("chrome");

//        Path to ChromeDriver
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");

        /**
         * Code block for enabling Selenium grid
         * hubUrl is desired hub URL we are pointing at
         */
//        String hubUrl = "http://localhost:9995/wd/hub";
//        WebDriver driver = new RemoteWebDriver(new URL(hubUrl), capabilities);

        /**
         * Code block for running tests in local
         */
        ChromeOptions options= new ChromeOptions();
//        options.setHeadless(true);
        WebDriver driver = new ChromeDriver();

        /**
         * First page to open
         */
        driver.get("https://tddev5.brandmakerinc.com");
        return driver;
    }
}

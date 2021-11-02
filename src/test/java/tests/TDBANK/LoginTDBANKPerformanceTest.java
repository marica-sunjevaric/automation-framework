package tests.TDBANK;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import tests.TestBase;

//TODO - DONE - CAN BE REUSED
public class LoginTDBANKPerformanceTest extends TestBase {

    private static String userName = "marica.sunjevaric";
    private static String password = "marica.sunjevaric123";

    private static final By USERNAME = By.cssSelector("#userName");
    private static final By PASSWORD = By.cssSelector("#password");
    private static final By BTNLOIGN = By.cssSelector("form#login-form > .bm-login-bm-login27");
    private static final By NAV_DROPDOWN = By.cssSelector("form#login-form > .bm-login-bm-login27");

    @Test
    public void loginTest() throws InterruptedException {

        WebElement fldUsername = tryToInitializeElementMultipleTimes(USERNAME);
        WebElement fldPassword = tryToInitializeElementMultipleTimes(PASSWORD);
        WebElement btnLogin = tryToInitializeElementMultipleTimes(BTNLOIGN);;

        fldUsername.clear();
        fldPassword.clear();
        fldUsername.sendKeys(userName);
        fldPassword.sendKeys(password);

        long startTime = System.currentTimeMillis();
        btnLogin.click();
        waitForElementWithSelector(NAV_DROPDOWN);
        long endTime = System.currentTimeMillis();
        long timeDiff = endTime - startTime;
        System.out.println("Time required to login: " + timeDiff);
    }
}

package tests.TDBANK;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import tests.TestBase;

public class JobManagerTDBANKPerformanceTest extends TestBase {

    private static String userName = "marica.sunjevaric";
    private static String password = "marica.sunjevaric123";

    private static final By USERNAME = By.cssSelector("#userName");
    private static final By PASSWORD = By.cssSelector("#password");
    private static final By BTN_LOGIN = By.cssSelector("form#login-form > .bm-login-bm-login27");
    private static final By NAV_DROPDOWN = By.cssSelector(".bm-header-MuiButton-root.bm-header-MuiButton-text.bm-header-MuiButtonBase-root.bm-header-bm-header19.bm-header-bm-header20");
    private static final By NAV_JOBS = By.cssSelector("li:nth-of-type(3) > .bm-header-bm-header15");
    private static final By TABLE_JOB_MANAGER = By.cssSelector("div[role='rowgroup'] > div:nth-of-type(2)");

    @Test
    public void jobManagerTest() throws InterruptedException {

//        login
        WebElement fldUsername = tryToInitializeElementMultipleTimes(USERNAME);
        WebElement fldPassword = tryToInitializeElementMultipleTimes(PASSWORD);
        WebElement btnLogin = tryToInitializeElementMultipleTimes(BTN_LOGIN);;

        fldUsername.clear();
        fldPassword.clear();
        fldUsername.sendKeys(userName);
        fldPassword.sendKeys(password);
        btnLogin.click();

//        navigation dropdown on first page
        WebElement navDropdown = tryToInitializeElementMultipleTimes(NAV_DROPDOWN);
        navDropdown.click();

//        open jobs in navigation
        WebElement jobs = tryToInitializeElementMultipleTimes(NAV_JOBS);
        jobs.click();

        waitForElementWithSelector(TABLE_JOB_MANAGER);



    }
}

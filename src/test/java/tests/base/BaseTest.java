package tests.base;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Step;
import io.qameta.allure.selenide.AllureSelenide;
import org.testng.annotations.*;

import static com.codeborne.selenide.Selenide.*;

public class BaseTest {
    protected static final String BASE_URL = "http://automationexercise.com";

    @BeforeSuite(alwaysRun = true)
    @Step("Starting out with allure and a browser")
    public void initialSetup() {
        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";
        Configuration.headless = true;
        Configuration.timeout = 8000;

        // Added once for the entire run
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }

    @BeforeMethod
    @Step("Open base url")
    public void openBaseUrl() {
        open(BASE_URL);
    }

    @AfterMethod(alwaysRun = true)
    @Step("Clear browser cookies and local storage")
    public void cleanUp() {
        clearBrowserCookies();
        clearBrowserLocalStorage();
    }

    @AfterSuite(alwaysRun = true)
    @Step("Close browser")
    public void tearDown() {
        closeWebDriver();
    }
}

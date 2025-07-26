package tests.base;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Step;
import io.qameta.allure.selenide.AllureSelenide;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;

public class BaseTest {
    protected static final String BASE_URL = "http://automationexercise.com";

    @BeforeSuite(alwaysRun = true)
    @Step("Starting out with Allure and a Browser")
    public void initialSetup() {
        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";
        Configuration.headless = true;
        Configuration.timeout = 8000;

        // Added once for the entire run
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide()
                .screenshots(true)
                .savePageSource(false));
    }

    @BeforeMethod
    @Step("Open base url")
    public void openBaseUrl() {
        open(BASE_URL);
    }

    @AfterSuite(alwaysRun = true)
    @Step("Close Browser")
    public void tearDown() {
        closeWebDriver();
    }
}

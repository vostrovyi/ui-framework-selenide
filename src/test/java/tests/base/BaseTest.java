package tests.base;

import com.codeborne.selenide.Configuration;
import io.qameta.allure.Step;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;

public class BaseTest {
    protected final static String BASE_URL = "http://automationexercise.com";

    @Step()
    @BeforeTest
    public void setUp() {
        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";
        Configuration.headless = true;
        Configuration.timeout = 8000;
        open(BASE_URL);
    }

    @Step()
    @AfterTest
    public void tearDown() {
        closeWebDriver();
    }
}

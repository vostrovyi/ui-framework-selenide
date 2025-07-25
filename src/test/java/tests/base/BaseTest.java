package tests.base;

import com.codeborne.selenide.Configuration;
import io.qameta.allure.Step;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class BaseTest {


    @Step()
    @BeforeTest
    public void setUp() {
        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";
        Configuration.timeout = 5000;
    }

    @Step()
    @AfterTest
    public void tearDown() {
        closeWebDriver();
    }

}

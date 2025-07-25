package tests;

import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import tests.base.BaseTest;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.visible;
import static org.assertj.core.api.Assertions.assertThat;

public class SampleTest extends BaseTest {

    @Test
    public void verifyHomePageIsVisible() {
        open("http://automationexercise.com");
        $("img[alt='Website for automation practice']").shouldBe(visible);

        String actualTitle = title();
        assertThat(actualTitle).as("Check page title").isEqualTo("Automation Exercise");
    }

    @AfterTest
    public void tearDown() {
        closeWebDriver();
    }
}

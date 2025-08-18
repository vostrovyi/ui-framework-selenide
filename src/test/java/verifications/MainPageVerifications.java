package verifications;

import io.qameta.allure.Step;
import pages.MainPage;

import static com.codeborne.selenide.Selenide.title;
import static org.assertj.core.api.Assertions.assertThat;

public class MainPageVerifications {

    @Step("Verify that home page is visible successfully")
    public void verifyHomePageIsVisible(MainPage mainPage) {
        assertThat(mainPage
                .getHomePageHighlightedText())
                .isEqualTo("Home");

        assertThat(title())
                .isEqualTo("Automation Exercise");
    }
}

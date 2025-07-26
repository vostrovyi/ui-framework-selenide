package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.*;

public class MainPage extends BasePage {
    private final SelenideElement highlightedText = $("a[style='color: orange;']");
    private final SelenideElement loginButton = $("a[href='/login']");

    public MainPage() {
    }

    /**
     * verify Home Page Is Visible
     *
     * @return text
     */
    @Step("Check the main page is visible")
    public String verifyHomePageIsVisible() {
        waitForVisible(highlightedText);
        return highlightedText.getText();
    }

    /**
     * Click on Login button
     *
     * @return LoginPage
     */
    @Step("Click on Login button")
    public LoginPage clickLoginButton() {
        clickElement(loginButton);
        return new LoginPage();
    }
}

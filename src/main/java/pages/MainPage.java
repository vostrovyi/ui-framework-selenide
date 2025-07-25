package pages;

import com.codeborne.selenide.SelenideElement;

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
    public String verifyHomePageIsVisible() {
        waitForVisible(highlightedText);
        return highlightedText.getText();
    }

    /**
     * Click on Login button
     *
     * @return LoginPage
     */
    public LoginPage clickLoginButton() {
        clickElement(loginButton);
        return new LoginPage();
    }
}

package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class MainPage extends BasePage {
    private final SelenideElement highlightedText = $("a[style='color: orange;']");
    private final SelenideElement loginButton = $("a[href='/login']");
    private final SelenideElement loggedInAsText = $("li:has(i.fa-user) b");
    private final SelenideElement deleteAccountButton = $(byText("Delete Account"));
    private final SelenideElement logoutButton = $(byText("Logout"));
    private final SelenideElement contactUsButton = $("a[href='/contact_us']");

    @Step("Get Home page highlighted text")
    public String getHomePageHighlightedText() {
        return highlightedText.shouldBe(visible).getText();
    }

    @Step("Click on Login button")
    public LoginPage clickLoginButton() {
        clickElement(loginButton);
        return new LoginPage();
    }

    @Step("Get 'Logged in as' text")
    public String getLoggedInAsText() {
        return loggedInAsText.shouldBe(visible).getText();
    }

    @Step("Click Delete Account button")
    public AccountDeletedPage clickDeleteAccountButton() {
        clickElement(deleteAccountButton);
        return new AccountDeletedPage();
    }

    @Step("Click Logout button")
    public LoginPage clickLogoutButton() {
        clickElement(logoutButton);
        return new LoginPage();
    }

    @Step("Click on Contact Us button")
    public ContactUsPage clickContactUsButton() {
        clickElement(contactUsButton);
        return new ContactUsPage();
    }
}

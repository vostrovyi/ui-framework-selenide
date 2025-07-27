package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class AccountCreatedPage extends BasePage {

    private final SelenideElement confirmationHeader = $("[data-qa='account-created']");
    private final SelenideElement continueButton = $("[data-qa='continue-button']");

    @Step("Get 'ACCOUNT CREATED!' header text")
    public String getConfirmationHeaderText() {
        return confirmationHeader.shouldBe(visible).getText();
    }

    @Step("Click Continue button")
    public MainPage clickContinue() {
        clickElement(continueButton);
        return new MainPage();
    }
}

package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class AccountDeletedPage extends BasePage {

    private final SelenideElement confirmationHeader = $("[data-qa='account-deleted']");
    private final SelenideElement continueButton = $("[data-qa='continue-button']");

    @Step("Get 'ACCOUNT DELETED!' header text")
    public String getConfirmationHeaderText() {
        return confirmationHeader.shouldBe(visible).getText();
    }

    @Step("Click Continue button")
    public void clickContinue() {
        clickElement(continueButton);
    }
}

package pages;

import com.codeborne.selenide.SelenideElement;
import data.User;
import io.qameta.allure.Allure;
import io.qameta.allure.Step;

import java.io.File;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.switchTo;

public class ContactUsPage extends BasePage {

    private final SelenideElement titleGetInTouch = $("div.contact-form > h2");
    private final SelenideElement nameInput = $("[placeholder='Name']");
    private final SelenideElement emailInput = $("[placeholder='Email']");
    private final SelenideElement subjectInput = $("[placeholder='Subject']");
    private final SelenideElement messageInput = $("[placeholder='Your Message Here']");
    private final SelenideElement chooseFile = $("[type='file']");
    private final SelenideElement submitButton = $("[name='submit']");
    private final SelenideElement successMessage = $("div.status.alert.alert-success");
    private final SelenideElement homeButton = $(".fa-home");

    @Step("Get 'GET IN TOUCH' title text")
    public String getContactUsHeaderText() {
        return getElementText(titleGetInTouch);
    }

    @Step("Fill contact form with subject '{subject}' and message '{message}'")
    public ContactUsPage fillContactForm(User user, String subject, String message) {
        setInputValue(nameInput, user.getName());
        setInputValue(emailInput, user.getEmail());
        setInputValue(subjectInput, subject);
        setInputValue(messageInput, message);
        return this;
    }

    @Step()
    public ContactUsPage uploadFile(File file) {
        Allure.step("Upload file: " + file.getName());
        uploadFile(chooseFile, file);
        return this;
    }

    @Step("Click on Submit button and accept alert")
    public ContactUsPage clickSubmitButton() {
        clickElement(submitButton);
        switchTo().alert().accept();
        return this;
    }

    @Step("Get success message text")
    public String getSuccessMessageText() {
        return successMessage.shouldBe(visible).getText();
    }

    @Step("Click Home button")
    public MainPage clickHomeButton() {
        clickElement(homeButton);
        return new MainPage();
    }
}

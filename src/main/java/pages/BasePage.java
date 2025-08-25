package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Keys;

import java.io.File;

import static com.codeborne.selenide.Selenide.title;

public class BasePage {

    protected void waitForVisible(SelenideElement element) {
        element.shouldBe(Condition.visible);
    }

    protected void clickElement(SelenideElement element) {
        element.shouldBe(Condition.visible).click();
    }

    protected void setInputValue(SelenideElement element, String value) {
        element.shouldBe(Condition.visible).clear();
        element.setValue(value);
    }

    protected String getElementText(SelenideElement element) {
        return element.shouldBe(Condition.visible).getText();
    }

    public String getPageTitle() {
        return title(); }

    protected void shouldHaveText(SelenideElement element, String text) {
        element.shouldHave(Condition.text(text));
    }

    protected void shouldHaveAttribute(SelenideElement element, String attribute, String value) {
        element.shouldHave(Condition.attribute(attribute, value));
    }

    protected void scrollToElement(SelenideElement element) {
        element.scrollIntoView(true);
    }

    protected void uploadFile(SelenideElement fileInput, File file) {
        fileInput.uploadFile(file);
    }

    protected void pressEnter(SelenideElement element) {
        element.sendKeys(Keys.ENTER);
    }
}

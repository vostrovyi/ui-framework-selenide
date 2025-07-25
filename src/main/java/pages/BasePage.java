package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Keys;

import java.io.File;

public class BasePage {

    /**
     * Wait for element to be visible
     */
    protected void waitForVisible(SelenideElement element) {
        element.shouldBe(Condition.visible);
    }

    /**
     * Click on element (while waiting for visibility)
     */
    protected void clickElement(SelenideElement element) {
        element.shouldBe(Condition.visible).click();
    }

    /**
     * Enter text in the field (clears before entering)
     */
    protected void setInputValue(SelenideElement element, String value) {
        element.shouldBe(Condition.visible).clear();
        element.setValue(value);
    }

    /**
     * Get the text of the element
     */
    protected String getElementText(SelenideElement element) {
        return element.shouldBe(Condition.visible).getText();
    }

    /**
     * Check that the element contains text
     */
    protected void shouldHaveText(SelenideElement element, String text) {
        element.shouldHave(Condition.text(text));
    }

    /**
     * Check that an element has a certain attribute
     */
    protected void shouldHaveAttribute(SelenideElement element, String attribute, String value) {
        element.shouldHave(Condition.attribute(attribute, value));
    }

    /**
     * Scroll to the element
     */
    protected void scrollToElement(SelenideElement element) {
        element.scrollIntoView(true);
    }

    /**
     * Upload a file (input[type='file'])
     */
    protected void uploadFile(SelenideElement fileInput, File file) {
        fileInput.uploadFile(file);
    }

    /**
     * Press Enter on the element
     */
    protected void pressEnter(SelenideElement element) {
        element.sendKeys(Keys.ENTER);
    }
}

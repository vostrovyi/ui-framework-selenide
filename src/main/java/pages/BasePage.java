package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.title;

public class BasePage {

    protected void setInputValue(SelenideElement element, String value) {
        element.shouldBe(Condition.visible).clear();
        element.setValue(value);
    }

    protected String getElementText(SelenideElement element) {
        return element.shouldBe(Condition.visible).getText();
    }

    public String getPageTitle() {
        return title();
    }
}

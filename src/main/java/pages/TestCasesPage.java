package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;

public class TestCasesPage extends BasePage {

    private final SelenideElement titleTestCases = $("h2.title.text-center b");

    @Step("Get 'TEST CASES' header text")
    public String getTestCasesHeaderText() {
        return getElementText(titleTestCases);
    }
}

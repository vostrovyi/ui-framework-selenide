package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class ProductDetailPage extends BasePage {


    private final SelenideElement productName = $("div.product-information h2");
    private final SelenideElement productCategory = $x("//p[contains(., 'Category')]");
    private final SelenideElement productPrice = $("div.product-information span span");
    private final SelenideElement productAvailability = $x("//p[b[contains(., 'Availability')]]/b");
    private final SelenideElement productCondition = $x("//p[b[contains(., 'Condition')]]/b");
    private final SelenideElement productBrand = $x("//p[b[contains(., 'Brand')]]/b");

    /**
     * method checks the visibility of all key elements
     * returns a list of those that are NOT visible.
     */
    @Step("Find all invisible product details")
    public List<String> findInvisibleDetails() {
        List<String> invisibleElements = new ArrayList<>();

        Map<String, SelenideElement> elementsToCheck = Map.of( // Перейменував змінну для ясності
                "Product Name", productName,
                "Product Category", productCategory,
                "Product Price", productPrice,
                "Product Availability", productAvailability,
                "Product Condition", productCondition,
                "Product Brand", productBrand
        );

        for (var entry : elementsToCheck.entrySet()) {
            String name = entry.getKey();
            SelenideElement element = entry.getValue();

            // Якщо елемент невидимий, додаємо його назву до списку
            if (!element.isDisplayed()) {
                invisibleElements.add(name);
            }
        }

        return invisibleElements;
    }
}

package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import java.util.ArrayList;
import java.util.List;

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

        if (!productName.isDisplayed()) invisibleElements.add("Product Name");
        if (!productCategory.isDisplayed()) invisibleElements.add("Product Category");
        if (!productPrice.isDisplayed()) invisibleElements.add("Product Price");
        if (!productAvailability.isDisplayed()) invisibleElements.add("Product Availability");
        if (!productCondition.isDisplayed()) invisibleElements.add("Product Condition");
        if (!productBrand.isDisplayed()) invisibleElements.add("Product Brand");

        return invisibleElements;
    }
}

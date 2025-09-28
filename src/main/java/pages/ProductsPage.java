package pages;

import io.qameta.allure.Step;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.ElementsCollection;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

import java.util.List;

public class ProductsPage extends BasePage {

    private final SelenideElement productsListHeader = $(".features_items h2.title.text-center");

    private final SelenideElement productsList = $(".features_items");
    private final SelenideElement firstProductViewButton = $("a[href='/product_details/1']");
    private final SelenideElement searchInput = $("#search_product");
    private final SelenideElement searchButton = $("#submit_search");
    private final ElementsCollection productNames = $$(".features_items .productinfo p");

    @Step("Get products list header text")
    public String getProductsListHeaderText() {
        return getElementText(productsListHeader);
    }

    @Step("Check if the product list is visible")
    public boolean isProductsListVisible() {
        return productsList.isDisplayed();
    }

    @Step("Click on 'View Product' of the first product")
    public ProductDetailPage clickViewFirstProduct() {
        firstProductViewButton.scrollTo();
        firstProductViewButton.click();
        return new ProductDetailPage();
    }

    @Step("Search for a product")
    public ProductsPage searchProduct(String productName) {
        setInputValue(searchInput, productName);
        searchButton.click();
        return this;
    }

    @Step("Get the names of all visible products")
    public List<String> getVisibleProductNames() {
        return productNames.texts();
    }
}

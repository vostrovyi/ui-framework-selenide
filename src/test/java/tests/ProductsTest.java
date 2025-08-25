package tests;

import io.qameta.allure.Description;
import org.testng.annotations.Test;
import pages.*;
import tests.base.BaseTest;
import verifications.MainPageVerifications;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ProductsTest extends BaseTest {

    private final MainPage mainPage = new MainPage();
    private final MainPageVerifications mainPageVerifications = new MainPageVerifications();

    @Test
    @Description("Verify All Products and product detail page")
    public void verifyAllProductsAndProductDetailPage() {
        mainPageVerifications.verifyHomePageIsVisible(mainPage);
        ProductsPage productsPage = mainPage.clickProductsButton();

        assertThat(productsPage
                .getProductsListHeaderText())
                .isEqualToIgnoringCase("All Products");

        assertThat(productsPage.isProductsListVisible()).isTrue();

        ProductDetailPage productDetailPage = productsPage.clickViewFirstProduct();

        assertThat(productDetailPage.findInvisibleDetails()).isEmpty();
    }

    @Test
    @Description("Search Product")
    public void searchProduct() {
        String productNameToSearch = "Summer White Top";

        mainPageVerifications.verifyHomePageIsVisible(mainPage);
        ProductsPage productsPage = mainPage.clickProductsButton();

        assertThat(productsPage.getProductsListHeaderText())
                .isEqualToIgnoringCase("All Products");

        productsPage.searchProduct(productNameToSearch);

        assertThat(productsPage.getProductsListHeaderText())
                .isEqualToIgnoringCase("Searched Products");

        // Verify all the products related to search are visible
        List<String> visibleProductNames = productsPage.getVisibleProductNames();

        assertThat(visibleProductNames).allSatisfy(name -> {
            assertThat(name).contains(productNameToSearch);
        });
    }
}

package tests;

import io.qameta.allure.Description;
import org.testng.annotations.Test;
import pages.*;
import tests.base.BaseTest;
import verifications.MainPageVerifications;

import static org.assertj.core.api.Assertions.assertThat;

public class ProductsTest extends BaseTest {

    private MainPage mainPage = new MainPage();
    private final MainPageVerifications mainPageVerifications = new MainPageVerifications();

    @Test
    @Description("Verify All Products and product detail page")
    public void verifyAllProductsAndProductDetailPage() {
    }

    @Test
    @Description("Search Product")
    public void searchProduct() {
    }
}

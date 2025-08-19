package tests;

import data.User;
import data.UserDataFactory;
import io.qameta.allure.Description;
import org.testng.annotations.Test;
import pages.*;
import tests.base.BaseTest;
import verifications.MainPageVerifications;

import java.io.File;

import static org.assertj.core.api.Assertions.assertThat;

public class MainPageFeaturesTest extends BaseTest {

    private MainPage mainPage = new MainPage();
    private final MainPageVerifications mainPageVerifications = new MainPageVerifications();

    @Test
    @Description("Contact Us Form")
    public void contactUsForm() {
        User user = UserDataFactory.getPredefinedUser();

        mainPageVerifications.verifyHomePageIsVisible(mainPage);
        ContactUsPage contactUsPage = mainPage.clickContactUsButton();

        assertThat(contactUsPage
                .getTitleText())
                .isEqualTo("GET IN TOUCH");

        contactUsPage.fillContactForm(user, "Tes Subject", "Test Message")
                .uploadFile(new File("src/test/resources/passport.png"))
                .clickSubmitButton();

        assertThat(contactUsPage
                .getSuccessMessageText())
                .isEqualTo("Success! Your details have been submitted successfully.");
    }

    @Test
    @Description("Verify Test Cases Page")
    public void verifyTestCasesPage() {

    }

//    @Test
//    @Description("Verify Subscription in home page")
//    public void verifySubscriptionInHomePage() {
//
//    }
}

package tests;

import data.User;
import io.qameta.allure.Description;
import org.testng.annotations.Test;
import pages.AccountCreatedPage;
import pages.AccountDeletedPage;
import pages.LoginPage;
import pages.MainPage;
import tests.base.BaseTest;

import static com.codeborne.selenide.Selenide.*;
import static org.assertj.core.api.Assertions.assertThat;

public class LoginTest extends BaseTest {

    @Test
    @Description("Register New User")
    public void registerUser() {
        User user = new User();
        MainPage mainPage = new MainPage();

        // 1. Verify Home Page Is Visible
        assertThat(mainPage.getHomePageHighlightedText()).isEqualTo("Home");
        assertThat(title()).isEqualTo("Automation Exercise");

        LoginPage loginPage = mainPage.clickLoginButton();

        // 2. Verify 'New User Signup!' is visible
        assertThat(loginPage.getNewUserSignupText()).isEqualTo("New User Signup!");

        // 3. Verify that 'ENTER ACCOUNT INFORMATION' is visible
        assertThat(loginPage.setUserData(user).getEnterAccountInformationHeader().getText())
                .isEqualTo("ENTER ACCOUNT INFORMATION");

        AccountCreatedPage accountCreatedPage = loginPage.fillDetailsAndCreateAccount(user, "11", "May", "2000");

        // 4. Verify 'ACCOUNT CREATED!' is visible
        assertThat(accountCreatedPage.getConfirmationHeaderText()).isEqualTo("ACCOUNT CREATED!");

        mainPage = accountCreatedPage.clickContinue();

        // 5. Verify that 'Logged in as username' is visible
        assertThat(mainPage.getLoggedInAsText()).isEqualTo(user.getName());

        AccountDeletedPage accountDeletedPage = mainPage.clickDeleteAccountButton();

        // 6. Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button
        assertThat(accountDeletedPage.getConfirmationHeaderText()).isEqualTo("ACCOUNT DELETED!");

        // 7. Click the 'Continue' button
        accountDeletedPage.clickContinue();
    }
}

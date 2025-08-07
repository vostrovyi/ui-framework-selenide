package tests;

import data.User;
import io.qameta.allure.Description;
import org.testng.annotations.Test;
import pages.AccountCreatedPage;
import pages.AccountDeletedPage;
import pages.LoginPage;
import pages.MainPage;
import tests.base.BaseTest;
import verifications.MainPageVerifications;

import static com.codeborne.selenide.Selenide.*;
import static org.assertj.core.api.Assertions.assertThat;

public class LoginTest extends BaseTest {

    @Test
    @Description("Register New User")
    public void registerUser() {
        User user = new User();
        MainPage mainPage = new MainPage();
        MainPageVerifications mainPageVerifications = new MainPageVerifications();

        // 1. Verify that home page is visible successfully
        mainPageVerifications.verifyHomePageIsVisible(mainPage);

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

    @Test
    @Description("Login User With Correct Email And Password")
    public void loginUserWithCorrectEmailAndPassword() {
        User defaultUser = User.getPredefinedUser();
        MainPage mainPage = new MainPage();
        MainPageVerifications mainPageVerifications = new MainPageVerifications();

        // 1. Verify that home page is visible successfully
        mainPageVerifications.verifyHomePageIsVisible(mainPage);

        LoginPage loginPage = mainPage.clickLoginButton();

        // 2. Verify 'Login to your account' is visible
        assertThat(loginPage.getLoginToYourAccountText()).isEqualTo("Login to your account");

        mainPage = loginPage.loginAs(defaultUser.getEmail(), defaultUser.getPassword());

        // 3. Verify that 'Logged in as username' is visible
        assertThat(mainPage.getLoggedInAsText()).isEqualTo(defaultUser.getName());


    }
}

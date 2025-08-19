package tests;

import data.User;
import data.UserDataFactory;
import io.qameta.allure.Description;
import org.testng.annotations.Test;
import pages.*;
import tests.base.BaseTest;
import verifications.MainPageVerifications;

import static org.assertj.core.api.Assertions.assertThat;

public class LoginTest extends BaseTest {

    private MainPage mainPage = new MainPage();
    private final MainPageVerifications mainPageVerifications = new MainPageVerifications();

    @Test
    @Description("Register New User")
    public void registerUser() {
        User user = UserDataFactory.createRandomUser();

        // 1. Verify that home page is visible successfully
        mainPageVerifications.verifyHomePageIsVisible(mainPage);

        LoginPage loginPage = mainPage.clickLoginButton();

        // 2. Verify 'New User Signup!' is visible
        assertThat(loginPage
                .getNewUserSignupText())
                .isEqualTo("New User Signup!");

        // 3. Verify that 'ENTER ACCOUNT INFORMATION' is visible
        assertThat(loginPage
                .setUserData(user)
                .getEnterAccountInformationHeader()
                .getText())
                .isEqualTo("ENTER ACCOUNT INFORMATION");

        AccountCreatedPage accountCreatedPage = loginPage.fillDetailsAndCreateAccount(user, "11", "May", "2000");

        // 4. Verify 'ACCOUNT CREATED!' is visible
        assertThat(accountCreatedPage
                .getConfirmationHeaderText())
                .isEqualTo("ACCOUNT CREATED!");

        mainPage = accountCreatedPage.clickContinue();

        // 5. Verify that 'Logged in as username' is visible
        assertThat(mainPage
                .getLoggedInAsText())
                .isEqualTo(user.getName());

        AccountDeletedPage accountDeletedPage = mainPage.clickDeleteAccountButton();

        // 6. Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button
        assertThat(accountDeletedPage
                .getConfirmationHeaderText())
                .isEqualTo("ACCOUNT DELETED!");
    }

    @Test
    @Description("Login User With Correct Email And Password")
    public void loginUserWithCorrectEmailAndPassword() {
        User user = UserDataFactory.getPredefinedUser();

        mainPageVerifications.verifyHomePageIsVisible(mainPage);
        LoginPage loginPage = mainPage.clickLoginButton();

        assertThat(loginPage
                .getLoginToYourAccountText())
                .isEqualTo("Login to your account");

        mainPage = loginPage.loginAs(user.getEmail(), user.getPassword());

        assertThat(mainPage
                .getLoggedInAsText())
                .isEqualTo(user.getName());
    }

    @Test
    @Description("Login User with incorrect email and password")
    public void loginUserWithIncorrectEmailAndPassword() {
        User user = UserDataFactory.getUserWithInvalidPassword();

        mainPageVerifications.verifyHomePageIsVisible(mainPage);
        LoginPage loginPage = mainPage.clickLoginButton();

        assertThat(loginPage
                .getLoginToYourAccountText())
                .isEqualTo("Login to your account");

        loginPage.loginAs(user.getEmail(), user.getPassword());

        assertThat(loginPage
                .getLoginErrorMessage())
                .isEqualTo("Your email or password is incorrect!");
    }

    @Test
    @Description("Logout User")
    public void logoutUser() {
        User user = UserDataFactory.getPredefinedUser();

        mainPageVerifications.verifyHomePageIsVisible(mainPage);
        MainPageVerifications mainPageVerifications = new MainPageVerifications();

        mainPageVerifications.verifyHomePageIsVisible(mainPage);
        LoginPage loginPage = mainPage.clickLoginButton();

        assertThat(loginPage
                .getLoginToYourAccountText())
                .isEqualTo("Login to your account");

        mainPage = loginPage.loginAs(user.getEmail(), user.getPassword());

        assertThat(mainPage
                .getLoggedInAsText())
                .isEqualTo(user.getName());

        // Save the new object of the page you went to AFTER the logout
        LoginPage finalLoginPage = mainPage.clickLogoutButton();

        assertThat(finalLoginPage
                .getLoginToYourAccountText())
                .isEqualTo("Login to your account");
    }

    @Test
    @Description("Register User with existing email")
    public void registerUserWithExistingEmail() {
        User user = UserDataFactory.getPredefinedUser();

        mainPageVerifications.verifyHomePageIsVisible(mainPage);
        LoginPage loginPage = mainPage.clickLoginButton();

        assertThat(loginPage
                .getNewUserSignupText())
                .isEqualTo("New User Signup!");

        loginPage.setUserData(user);

        assertThat(loginPage
                .getSignupErrorMessage())
                .isEqualTo("Email Address already exist!");
    }
}

package tests;

import org.testng.annotations.Test;
import pages.LoginPage;
import pages.MainPage;
import tests.base.BaseTest;

import static com.codeborne.selenide.Selenide.*;
import static org.assertj.core.api.Assertions.assertThat;

public class SampleTest extends BaseTest {

    @Test
    public void registerUser() {
        MainPage mainPage = new MainPage();

        // Verify Home Page Is Visible
        assertThat(mainPage.verifyHomePageIsVisible()).isEqualTo("Home");
        assertThat(title()).isEqualTo("Automation Exercise");

        LoginPage loginPage = mainPage.clickLoginButton();

        // Verify 'New User Signup!' is visible
        assertThat(loginPage.getNewUserSignupText())
                .isEqualTo("New User Signup!");

        // Verify that 'ENTER ACCOUNT INFORMATION' is visible
        assertThat(loginPage.setUserData()
                .accountInformation()
                .getText())
                .isEqualTo("ENTER ACCOUNT INFORMATION");
    }
}

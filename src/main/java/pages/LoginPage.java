package pages;

import com.codeborne.selenide.SelenideElement;
import data.User;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class LoginPage extends BasePage {

    // --- Locators ---
    private final SelenideElement newUserSignUp = $("div.signup-form > h2");
    private final SelenideElement loginToYourAccount = $("div.login-form > h2");
    private final SelenideElement nameInputInitial = $("[placeholder='Name']");
    private final SelenideElement emailInputInitial = $("[data-qa='signup-email']");
    private final SelenideElement signUpButton = $("[data-qa='signup-button']");
    private final SelenideElement enterAccountInformationHeader = $x("(//div[@class='login-form']//h2[@class='title text-center']/b)[1]");
    private final SelenideElement titleMrRadio = $("#id_gender1");
    private final SelenideElement passwordInput = $("#password");
    private final SelenideElement daysSelect = $("#days");
    private final SelenideElement monthsSelect = $("#months");
    private final SelenideElement yearsSelect = $("#years");
    private final SelenideElement newsletterCheckbox = $("#newsletter");
    private final SelenideElement specialOffersCheckbox = $("#optin");
    private final SelenideElement firstNameInput = $("#first_name");
    private final SelenideElement lastNameInput = $("#last_name");
    private final SelenideElement companyInput = $("#company");
    private final SelenideElement address1Input = $("#address1");
    private final SelenideElement address2Input = $("#address2");
    private final SelenideElement stateInput = $("#state");
    private final SelenideElement cityInput = $("#city");
    private final SelenideElement zipcodeInput = $("#zipcode");
    private final SelenideElement mobileNumberInput = $("#mobile_number");
    private final SelenideElement createAccountButton = $("[data-qa='create-account']");
    private final SelenideElement loginEmailInput = $("[data-qa='login-email']");
    private final SelenideElement loginPasswordInput = $("[data-qa='login-password']");
    private final SelenideElement loginButton = $("[data-qa='login-button']");
    private final SelenideElement loginErrorMessage = $("p[style='color: red;']");
    private final SelenideElement signupErrorMessage = $("form[action='/signup'] p"); // Помилка при реєстрації

    // =================================================================
    // PUBLIC METHODS
    // =================================================================

    @Step("Receive the text 'New User Signup'")
    public String getNewUserSignupText() {
        return getElementText(newUserSignUp);
    }

    @Step("Receive the text 'Login to your account'")
    public String getLoginToYourAccountText() {
        return getElementText(loginToYourAccount);
    }

    @Step("Fill in the initial user's information for signup")
    public LoginPage setUserData(User user) {
        setInputValue(nameInputInitial, user.getName());
        setInputValue(emailInputInitial, user.getEmail());
        clickElement(signUpButton);
        return this;
    }

    @Step("Get 'ENTER ACCOUNT INFORMATION' header element")
    public SelenideElement getEnterAccountInformationHeader() {
        return enterAccountInformationHeader;
    }

    @Step("Fill in all account details and create an account")
    public AccountCreatedPage fillDetailsAndCreateAccount(User user, String day, String month, String year) {
        fillRequiredCredentials(user, day, month, year);
        fillAddressDetails(user);
        scrollToElement(createAccountButton);
        clickElement(createAccountButton);
        return new AccountCreatedPage();
    }

    @Step("Login as user with email: {email}")
    public MainPage loginAs(String email, String password) {
        setInputValue(loginEmailInput, email);
        setInputValue(loginPasswordInput, password);
        clickElement(loginButton);
        return new MainPage();
    }

    @Step("Get login error message")
    public String getLoginErrorMessage() {
        return loginErrorMessage.shouldBe(visible).getText();
    }

    @Step("Select marketing options checkboxes")
    private void selectMarketingOptions() {
        clickElement(newsletterCheckbox);
        clickElement(specialOffersCheckbox);
    }

    @Step("Get signup error message")
    public String getSignupErrorMessage() {
        return signupErrorMessage.shouldBe(visible).getText();
    }

    // =================================================================
    // PRIVATE HELPER METHODS
    // =================================================================

    @Step("Fill required credentials: title, password, and date of birth")
    private void fillRequiredCredentials(User user, String day, String month, String year) {
        clickElement(titleMrRadio);
        setInputValue(passwordInput, user.getPassword());
        daysSelect.selectOption(day);
        monthsSelect.selectOption(month);
        yearsSelect.selectOption(year);
    }

    @Step("Fill address and marketing details")
    private void fillAddressDetails(User user) {
        fillContactAndAddressInfo(user);
        selectMarketingOptions();
    }

    @Step("Fill all contact and address fields")
    private void fillContactAndAddressInfo(User user) {
        setInputValue(firstNameInput, user.getName());
        setInputValue(lastNameInput, user.getLastName());
        setInputValue(companyInput, user.getCompany());
        setInputValue(address1Input, user.getAddress1());
        setInputValue(address2Input, user.getAddress2());
        setInputValue(stateInput, user.getState());
        setInputValue(cityInput, user.getCity());
        setInputValue(zipcodeInput, user.getZipcode());
        setInputValue(mobileNumberInput, user.getMobileNumber());
    }
}

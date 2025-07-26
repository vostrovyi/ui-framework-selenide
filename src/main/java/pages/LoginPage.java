package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import net.bytebuddy.utility.RandomString;

import static com.codeborne.selenide.Selenide.*;

public class LoginPage extends BasePage {
    //    private final ElementsCollection elements = $$x("//input[@id='search_product']");
    private final SelenideElement newUserSignUp = $("div.signup-form > h2");
    private final SelenideElement name = $("[placeholder='Name']");
    private final SelenideElement email = $("[data-qa='signup-email']");
    private final SelenideElement signUpButton = $("[data-qa='signup-button']");
    private final SelenideElement enterAccountInformation = $x("(//div[@class='login-form']//h2[@class='title text-center']/b)[1]");
    private final SelenideElement setUserTitle = $("#uniform-id_gender1");
    private final SelenideElement setPassword = $("#password");


//    /**
//     * Get elements
//     *
//     * @return href from first element
//     */
//    public String getElements() {
//        return elements.first().getAttribute("href");
//    }

    /**
     * Get newUserSignUp
     *
     * @return element
     */
    @Step("Receive the text New User Signup")
    public String getNewUserSignupText() {
        return getElementText(newUserSignUp);
    }

    @Step("Fill in the new user's information")
    public LoginPage setUserData() {
        setInputValue(name, RandomString.make(5));
        setInputValue(email, RandomString.make(8) + "@" + RandomString.make(3) + ".com");
        clickElement(signUpButton);
        return this;
    }

    @Step("Check the header ENTER ACCOUNT INFORMATION")
    public SelenideElement accountInformation() {
        return enterAccountInformation;
    }

    @Step("Fill in the account details")
    public SelenideElement fillDetails() {
        clickElement(setUserTitle);
        setInputValue(setPassword, RandomString.make(8));

        return enterAccountInformation;
    }
}

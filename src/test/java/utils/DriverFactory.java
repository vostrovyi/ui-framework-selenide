package utils;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.BeforeMethod;

public class DriverFactory {

    @BeforeMethod
    public void setup() {
        Configuration.browser = "chrome";
    }
}
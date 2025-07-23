package tests;

import org.testng.annotations.Test;
import static com.codeborne.selenide.Selenide.*;
import static org.assertj.core.api.Assertions.*;

public class SampleTest {

    @Test
    public void googleTest() {
        open("https://www.google.com");
        assertThat(title()).contains("Google");
    }
}
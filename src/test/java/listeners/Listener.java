package listeners;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {
        saveScreenshotOnFailure();
    }

    @SuppressWarnings("UnusedReturnValue")
    @Attachment(value = "Screenshot on failure", type = "image/png")
    public byte[] saveScreenshotOnFailure() {
        return Selenide.screenshot(OutputType.BYTES);
    }
}

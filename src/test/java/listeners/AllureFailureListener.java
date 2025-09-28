package listeners;

import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.nio.charset.StandardCharsets;
import java.util.stream.Collectors;

public class AllureFailureListener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {
        if (WebDriverRunner.hasWebDriverStarted()) {
            saveScreenshot();
            savePageSource();
            saveBrowserConsoleLogs();
        }
    }

    @Attachment(value = "Screenshot on failure", type = "image/png")
    public byte[] saveScreenshot() {
        return ((TakesScreenshot) WebDriverRunner.getWebDriver())
                .getScreenshotAs(OutputType.BYTES);
    }

    @Attachment(value = "Page source", type = "text/html", fileExtension = ".html")
    public byte[] savePageSource() {
        return WebDriverRunner.source().getBytes(StandardCharsets.UTF_8);
    }

    @Attachment(value = "Browser console logs", type = "text/plain")
    public String saveBrowserConsoleLogs() {
        try {
            LogEntries logEntries = WebDriverRunner.getWebDriver()
                    .manage()
                    .logs()
                    .get("browser");
            return logEntries.getAll().stream()
                    .map(LogEntry::toString)
                    .collect(Collectors.joining("\n"));
        } catch (Exception e) {
            return "No console logs available: " + e.getMessage();
        }
    }
}

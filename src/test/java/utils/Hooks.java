package utils;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Hooks {

    WebDriver driver;

    @Before
    public void beforeScenario() {
        driver = BaseDriver.getDriver();
    }

    @After
    public void afterScenario(Scenario scenario) {
        if (scenario.isFailed()) {
            final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "Failure Screenshot");

            ScreenshotUtil.captureScreenshot(driver, scenario.getName().replace(" ", "_"));
        }
        BaseDriver.quitDriver();
    }
}

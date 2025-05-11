package utils;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Hooks {

    @AfterStep
    public void captureStepScreenshot(Scenario scenario) {
        if (BaseDriver.getDriver() != null) {
            TakesScreenshot ts = (TakesScreenshot) BaseDriver.getDriver();
            File src = ts.getScreenshotAs(OutputType.FILE);

            String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
            String scenarioName = scenario.getName().replaceAll(" ", "_");

            File dest = new File("screenshots/" + scenarioName + "_Step_" + timestamp + ".png");

            try {
                FileHandler.copy(src, dest);
                System.out.println("📸 Step Screenshot saved at: " + dest.getAbsolutePath());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @After
    public void tearDown(Scenario scenario) {
        BaseDriver.quitDriver();
    }
}

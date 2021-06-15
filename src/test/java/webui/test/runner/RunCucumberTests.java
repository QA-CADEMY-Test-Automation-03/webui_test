package webui.test.runner;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import webui.test.core.DriverManager;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
                "pretty",
                "html:reports/html/index.html",
                "json:reports/cucumber-reports/cucumber.json",
                "de.monochromata.cucumber.report.PrettyReports:reports/cucumber-reporting",
                "rerun:reports/rerun/rerun.txt"
        },
        features = "src/test/resources/scenarios",
        glue = "webui.test",
        tags = "@outline"
)
public class RunCucumberTests {
//        @After
//        public static void close(){
//                DriverManager.getInstance().quit();
//        }

//        @After
//        public static void takeScreenshot(Scenario scenario) {
//                if (scenario.isFailed()) {
//                        WebDriver driver = DriverManager.getInstance().getDriver();
//                        final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
//                        scenario.attach(screenshot, "image/png", "screenshot");
//                }
//        }
}

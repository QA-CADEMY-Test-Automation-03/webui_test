package webui.test.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
                "pretty",
//                "html:reports/html/index.html",
//                "de.monochromata.cucumber.report.PrettyReports:reports/cucumber",
                "json:reports/cucumber-reports/cucumber-retry.json",
        },

        features = "@reports/rerun/rerun.txt",
        glue = "webui.test"
)
public class ReRunCucumberTests {

}

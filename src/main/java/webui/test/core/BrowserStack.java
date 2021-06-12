package webui.test.core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;

public class BrowserStack extends AbstractDriver {
    private static final String AUTOMATE_USERNAME = "josec7";
    private static final String AUTOMATE_ACCESS_KEY = "g5p6nJVqm48saYZ7UAte";
    private static final String URL = "https://" + AUTOMATE_USERNAME + ":" + AUTOMATE_ACCESS_KEY + "@hub-cloud.browserstack.com/wd/hub";

    @Override
    WebDriver initDriver() {
        DesiredCapabilities caps = new DesiredCapabilities();

        caps.setCapability("os", "OS X");
        caps.setCapability("os_version", "Big Sur");
        caps.setCapability("browser", "safari");
        caps.setCapability("browser_version", "latest");
        caps.setCapability("name", "Web UI QAcademy");
        caps.setCapability("build", "webui-002");
        try{
            return new RemoteWebDriver(new URL(URL), caps);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }

        return null;
    }
}

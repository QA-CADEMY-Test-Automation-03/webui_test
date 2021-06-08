package webui.test.hooks;

import io.cucumber.java.After;
import webui.test.core.DriverManager;

public class Hooks {

    @After
    public void close(){
        DriverManager.getInstance().getDriver().quit();
    }
}

package org.openlib.com;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openlib.utils.TestBaseClass;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class BaseClass {
    @Before
    public static void setUp() {

        TestBaseClass.setUpDriver();
    }


    @After
    public static void tearDown(Scenario scenario) {
        //validate if scenario has pass
        if (scenario.getStatus().equals("Pass")) {
            final byte[] screenshot = ((TakesScreenshot) TestBaseClass.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName());
            scenario.log("Test Pass");
        }

        //validate if scenario has failed
        if (scenario.isFailed()) {
            final byte[] screenshot = ((TakesScreenshot) TestBaseClass.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName());
            scenario.log("Test failed");
        }

        TestBaseClass.tearDown();
    }
}

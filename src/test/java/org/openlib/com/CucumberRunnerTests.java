package org.openlib.com;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(tags = "", features = {"src/test/resources/features/"}, glue = {"org.openlib.com"})

public class CucumberRunnerTests extends AbstractTestNGCucumberTests {

}
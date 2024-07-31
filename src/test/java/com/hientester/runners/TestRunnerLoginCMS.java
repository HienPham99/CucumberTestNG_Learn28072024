package com.hientester.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.Test;

@CucumberOptions(
        features = "src/test/resources/features/Login/LoginCMS.feature",
        glue = {"com.hientester.stepdefinitions",
                "com.hientester.common"},
        plugin = {"pretty", "html:target/cucumber-html-report.html"},
       // tags = "@success and @failure and @regression"
        tags = "@success"
)
@Test
public class TestRunnerLoginCMS extends AbstractTestNGCucumberTests {

}

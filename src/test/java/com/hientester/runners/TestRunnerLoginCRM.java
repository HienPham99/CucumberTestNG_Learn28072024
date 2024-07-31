package com.hientester.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.Test;

@CucumberOptions(
        features = "src/test/resources/features/Login/LoginCRM.feature",
        glue = {"com.hientester.stepdefinitions",
                "com.hientester.common",
                "com/hientester/hooks"
        },
        plugin = {"pretty", "html:target/cucumber-html-report.html"},
        tags = ""
)
@Test
public class TestRunnerLoginCRM extends AbstractTestNGCucumberTests {

}

package com.hientester.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

@CucumberOptions(
        features = "src/test/resources/features/Login/LoginCMS.feature",
        glue = {"com.hientester.stepdefinitions",
                "com.hientester.common",
                "com.hientester.hooks"
        },
        plugin = {"pretty", "html:target/cucumber-html-report.html"},
        tags = "@SuccessfulLogin or @InvalidLogin"
)
@Test
public class TestRunnerLoginCMS extends AbstractTestNGCucumberTests {
    //Run parallel
    @Override
    @DataProvider(parallel = false)
    public Object[][] scenarios() {
        return super.scenarios();
    }

}

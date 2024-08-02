package com.hientester.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

@CucumberOptions(
        features = "src/test/resources/features/Categories/Categories.feature",
        //glue chứa đg dẫn file để run,có nhiều thì cách nhau = dấu phẩy (",")
        glue = {"com.hientester.stepdefinitions",
                "com.hientester.common",
                "com/hientester/hooks"
        },
        plugin = {"pretty", "html:target/cucumber-html-report.html"},
       // tags = "@success and @failure and @regression"
        tags = ""
)
@Test
public class TestRunnerCategoryCMS extends AbstractTestNGCucumberTests {
        //Run parallel
        @Override
        @DataProvider(parallel = true)
        public Object[][] scenarios() {
                return super.scenarios();
        }

}
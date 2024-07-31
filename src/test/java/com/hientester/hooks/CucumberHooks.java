package com.hientester.hooks;

import com.hientester.common.BaseTest;
import hientester.com.drivers.DriverManager;
import hientester.com.helpers.CaptureHelper;
import hientester.com.helpers.PropertiesHelper;
import hientester.com.utils.LogUtils;
import io.cucumber.java.*;

public class CucumberHooks {

    @BeforeAll
    public static void beforeAll(){
System.out.println("===========BEFORE ALL============");
        PropertiesHelper.loadAllFiles();
        //Khởi chạy report
    }

    @AfterAll
    public static void afterAll(){
        System.out.println("===========AFTER ALL============");
    }

    @Before
    public void beforeScenario(){
        System.out.println("==============beforeScenario==========");
        BaseTest.createBrowser();
        //Record video
    }

    @After
    public void afterScenario(Scenario scenario){
        System.out.println("==============afterScenario==========");
        BaseTest.closeDriver();
    }

    @BeforeStep
    public void beforeStep(Scenario scenario){
        System.out.println("==============beforeStep==========");
        //Ghi logs log4j
        //Ghi logs step vvaof report
       // LogUtils.info(scenario.getName());
    }

    @AfterStep
    public void afterStep(Scenario scenario){
        System.out.println("==============afterStep==========");
        if (scenario.isFailed()){
            CaptureHelper.takeScreenshot(scenario.getName());
        }
    }
}

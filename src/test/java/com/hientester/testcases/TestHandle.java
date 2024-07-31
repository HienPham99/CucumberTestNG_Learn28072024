package com.hientester.testcases;

import com.hientester.common.BaseTest;
import hientester.com.helpers.ExcelHelper;
import hientester.com.helpers.PropertiesHelper;
import hientester.com.utils.LogUtils;
import io.cucumber.java.an.E;
import org.testng.annotations.Test;

public class TestHandle extends BaseTest {

    @Test
    public void testReadPropertiesFile(){
        PropertiesHelper.loadAllFiles();
       // System.out.println(PropertiesHelper.getValue("URL"));
        LogUtils.info(PropertiesHelper.getValue("URL"));
        LogUtils.info(PropertiesHelper.getValue("BROWSER"));

    }

    @Test
    public void testReadExcelData(){
        ExcelHelper excel = new ExcelHelper();
        excel.setExcelFile("src/test/resources/datatest/CRM.xlsx","Login");
       LogUtils.info(excel.getCellData("EMAIL",1));
       LogUtils.info(excel.getCellData("PASSWORD",1));

    }

    @Test
    public void testLog4j2(){
        LogUtils.info("Cucumber test NG");
    }
}

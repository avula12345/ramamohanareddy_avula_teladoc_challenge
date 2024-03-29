package com.rest.runner.TestRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {"src/test/resources/features/API"},
        plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
        glue = {"com.rest.runner.StepDefinitions.API"}
        , tags = ""
)
public class APITestRunner extends AbstractTestNGCucumberTests {

}

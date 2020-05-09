package com.zerobank.runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        glue = "com/zerobank/stepdefinitions",
        features = "@target/rerun.txt",
        strict = false,
        plugin ={
                "html:target/failed-default-report",
                "json:target/failed_cucumber1.json",
                 "rerun:target/rerun.txt"
        }

)

public class FailedTestRunner {

}

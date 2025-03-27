package com.tastyNibbles.testrunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features= "src\\test\\resources\\com.TastyNibbles.feature\\AddingDifferentItems.feature",
glue = {"com.tastyNibbles.stepDefinition"},
plugin = {"pretty","html:target/cucumberReport/AddingDifferentItems report5.html"})
//tags = ("@SmokeTest or @SystemTest"),
//monochrome=true)
public class AddingDifferentItemsNG extends AbstractTestNGCucumberTests {

}

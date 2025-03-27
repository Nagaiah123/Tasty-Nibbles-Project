package com.tastyNibbles.testrunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src\\test\\resources\\com.TastyNibbles.feature\\AddToCart.feature",
glue= {"com.tastyNibbles.stepDefinition"},
plugin = {"pretty","html:target/cucumberReport/Search report2.html"})
public class SearchNG extends AbstractTestNGCucumberTests{
	
}
package com.hyder.runner;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty", "html:target/cucumber"}, 

features = "src/test/resources/", 
glue = {"com.hyder.stepdefinition", "com.hyder.hooks"}, tags = "@TC001")

public class DemoTest {
	
}

	




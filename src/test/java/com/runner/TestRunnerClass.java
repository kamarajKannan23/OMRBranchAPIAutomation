package com.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;

@RunWith(Cucumber.class)
//tags = "@LoginAndaddAddress"
@CucumberOptions( dryRun = false, features = "src\\test\\resources\\Features", glue = "com.stepdefinition", stepNotifications = true, publish = true, plugin = {
		"pretty" }, monochrome = true, snippets = SnippetType.CAMELCASE)

public class TestRunnerClass {

}

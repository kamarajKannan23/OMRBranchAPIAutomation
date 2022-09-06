package com.runner;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.base.RestAssuredBaseClass;
import com.reports.Reporting;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;

@RunWith(Cucumber.class)
//tags = "@LoginAndaddAddress"
@CucumberOptions( dryRun = false, features = "src\\test\\resources\\Features", glue = "com.stepdefinition", stepNotifications = true, publish = true, plugin = {
		"pretty","json:target\\output.json" }, monochrome = true, snippets = SnippetType.CAMELCASE)

public class TestRunnerClass extends RestAssuredBaseClass {
	@AfterClass
	public static void afterClass() throws FileNotFoundException, IOException {
		Reporting.generateJVMReport(System.getProperty("user.dir")+getPropertyFileValue("jsonPath"));
	}
}

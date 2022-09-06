package com.stepdefinition;

import org.junit.Assert;

import com.base.RestAssuredBaseClass;

import io.cucumber.java.en.Then;
import io.restassured.response.Response;

public class CommonStep extends RestAssuredBaseClass {

	@Then("User verify the status code is {int}")
	public void userVerifyTheStatusCodeIs(int expStatusCode) {
		
		int actualStatusCode = getStatusCode(response);
		System.out.println(expStatusCode);
		
		Assert.assertEquals("verify statusCode",expStatusCode,actualStatusCode);

	}
}

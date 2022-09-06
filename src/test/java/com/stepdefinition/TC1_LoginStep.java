package com.stepdefinition;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Assert;

import com.base.RestAssuredBaseClass;
import com.endpoints.EndPoints;
import com.pojo.Login_Output_Pojo;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

public class TC1_LoginStep extends RestAssuredBaseClass {
	static Login_Output_Pojo login_Output_Pojo;
	Response response;
	static String logtoken;
	@Given("User add header")
	public void userAddHeader() {
		addHeader("Content-Type", "application/json");
	}
	
	@Given("User add basic authentication for the login")
	public void userAddBasicAuthenticationForTheLogin() {
		//String username =getPropertyFileValue("username");
		//String password =getPropertyFileValue("password");
		//basicAuth(username, password);
		basicAuth("k23raj@gmail.com", "Omr@123");
	}
	
	@When("User send {string} request for login endpoint")
	public void userSendRequestForLoginEndpoint(String reqMethodType) throws FileNotFoundException, IOException {
		response = requestMethodType(reqMethodType,EndPoints.POSTMANBASICAUTHLOGIN);
		login_Output_Pojo= response.as(Login_Output_Pojo.class);
		logtoken = login_Output_Pojo.getData().getLogtoken();
	}
	
	@Then("User verify the login responce body firstName present as {string} and get the logtoken saved")
	public void userVerifyTheLoginResponceBodyFirstNamePresentAsAndGetTheLogtokenSaved(String expFirstName) {
		String firstName = login_Output_Pojo.getData().getFirst_name();
		Assert.assertEquals("verify FirstName",expFirstName, firstName );
	}

}

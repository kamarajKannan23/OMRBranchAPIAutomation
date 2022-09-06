package com.stepdefinition;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;

import com.base.RestAssuredBaseClass;
import com.endpoints.EndPoints;
import com.pojo.UpdateProfilePic_Output_Pojo;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class TC3_ProfilePictureStep extends RestAssuredBaseClass {
	Response response;

	@Given("User add headers and bearer authorization for accessing upload profile picture endpoints")
	public void userAddHeadersAndBearerAuthorizationForAccessingUploadProfilePictureEndpoints() {
		List<Header> h = new ArrayList<>();

		Header h1 = new Header("accept", "application/json");
		Header h2 = new Header("Authorization", "Bearer " + TC1_LoginStep.logtoken);
		Header h3 = new Header("Content-Type", "multipart/form-data");

		h.add(h1);
		h.add(h2);
		h.add(h3);

		Headers headers = new Headers(h);
		addHeaders(headers);

	}

	@When("User add multipart for upload profile picture")
	public void userAddMultipartForUploadProfilePicture() throws FileNotFoundException, IOException {
		formData("profile_picture", new File(System.getProperty("user.dir") + getPropertyFileValue("profilePic")));
	}

	@When("User sent {string} request for upload profile picture")
	public void userSentRequestForUploadProfilePicture(String methodType) {
		response = requestMethodType(methodType, EndPoints.UPDATEPROFILEPIC);

	}

	@Then("User verify the create upload profile picture response message matches {string}")
	public void userVerifyTheCreateUploadProfilePictureResponseMessageMatches(String expMsg) {
	
		UpdateProfilePic_Output_Pojo updateProfilePic=response.as(UpdateProfilePic_Output_Pojo.class);
		
		String resBodyAsPreetyString = getResBodyAsPreetyString(response);
		System.out.println(resBodyAsPreetyString);
		String actualMsg = updateProfilePic.getMessage();
		Assert.assertEquals( "verify statusCode",expMsg,actualMsg);

		
	}

}

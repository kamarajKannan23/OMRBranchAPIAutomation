package com.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import com.pojo.AddUserAddress_Input_Pojo;
import com.pojo.UpdateUserAddress_Input_Pojo;

import com.pojo.AddUserAddress_Input_Pojo;
import com.pojo.UpdateUserAddress_Input_Pojo;

import io.restassured.RestAssured;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RestAssuredBaseClass {

	static RequestSpecification reqSpec;
	public static Response response;

	public void addHeader(String key, String value) {
		reqSpec = RestAssured.given().header(key, value);
	}

	public void addHeaders(Headers headers) {
		reqSpec = RestAssured.given().headers(headers);
	}

	public void formData(String key, File file) {
		reqSpec = reqSpec.multiPart(key, file);
	}

	public void basicAuth(String userName, String password) {
		reqSpec = reqSpec.auth().preemptive().basic(userName, password);
	}

	public void addQuearyParameter(String key, String value) {
		reqSpec = reqSpec.queryParam(key, value);
	}

	public void addPathParameter(String key, String value) {
		reqSpec = reqSpec.pathParam(key, value);
	}

	public void addBody(Object body) {
		reqSpec = reqSpec.body(body);
	}

	public void addBody(String body) {
		reqSpec = reqSpec.body(body);

	}

	public Response requestMethodType(String type, String endpoint) {
		switch (type) {
		case "GET":
			response = reqSpec.log().all().get(endpoint);
			break;

		case "POST":
			response = reqSpec.log().all().post(endpoint);
			break;

		case "PUT":
			response = reqSpec.log().all().put(endpoint);
			break;

		case "DELETE":
			response = reqSpec.log().all().delete(endpoint);
			break;

		default:
			break;
		}

		return response;
	}

	public int getStatusCode(Response response) {
		int statusCode = response.getStatusCode();
		return statusCode;
	}

	public String getResBodyAsString(Response responce) {
		String asString = response.asString();
		return asString;
	}

	public String getResBodyAsPreetyString(Response responce) {
		String asPrettyString = responce.asPrettyString();
		return asPrettyString;
	}

	public static String getPropertyFileValue(String key) throws FileNotFoundException, IOException {
		Properties properties = new Properties();
		properties.load(new FileInputStream(System.getProperty("user.dir") + "\\Config\\Config.properties"));

		String value = (String) properties.get(key);
		return value;
	}

	public static void setPropertyFileValue(String key, String value) throws FileNotFoundException, IOException {
		Properties properties = new Properties();
		properties.load(new FileInputStream(System.getProperty("user.dir") + "\\Config\\Config.properties"));
		System.setProperty(key, value);
	}

}
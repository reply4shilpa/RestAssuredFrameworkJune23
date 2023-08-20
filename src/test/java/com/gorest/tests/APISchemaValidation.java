package com.gorest.tests;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

import org.testng.annotations.Test;

import com.qa.gorest.base.BaseTest;
import com.qa.gorest.constants.APIHttpStatus;
import com.qa.gorest.pojo.User;
import com.qa.gorest.utils.StringUtil;

import io.restassured.RestAssured;

public class APISchemaValidation extends BaseTest {
	@Test
	public void createUserAPISchemaTest() {
		RestAssured.baseURI = "https://gorest.co.in/";
		// 1. add user Post
		User user =new User("Tom", StringUtil.getRandomEmailId(), "gender", "active" );
		
				restClient.post(GOREST_ENDPOINT, "json", user, true, true)
				.then().log().all()
				.assertThat().statusCode(APIHttpStatus.CREATED_201.getCode())
				.body(matchesJsonSchemaInClasspath("createuserschema.json"));

}
	
}

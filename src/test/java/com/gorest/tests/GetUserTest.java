package com.gorest.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.equalTo;

import java.util.HashMap;
import java.util.Map;

import com.qa.gorest.base.BaseTest;
import com.qa.gorest.client.RestClient;
import com.qa.gorest.constants.APIHttpStatus;

public class GetUserTest extends BaseTest{
	
	@BeforeMethod
	public void getUserSetup() {
		restClient = new RestClient(prop, baseURI);
	}
	//code smell: sonarQube
	@Test(enabled = true)
	public void getAllUsersTest() {
		restClient.get(GOREST_ENDPOINT, true,  true)
					.then().log().all()
						.assertThat().statusCode(APIHttpStatus.OK_200.getCode());
						
	}
	
	//public/v2/users/4165714/?name&staus
	@Test(enabled = true)
	public void getUserTest() {
		restClient.get(GOREST_ENDPOINT +"/"+4609420, true, true)
					.then().log().all()
						.assertThat().statusCode(APIHttpStatus.OK_200.getCode())
							.and().body("id", equalTo(4609420));
						
	}
	
	//url?name&staus
	@Test(enabled = true)
	public void getUserWithQueryParamsTest() {
		Map<String,Object> queryParams = new HashMap<String,Object>();
		queryParams.put("name", "shilpa");
		queryParams.put("status", "active");

		restClient.get(GOREST_ENDPOINT, queryParams, null,true, true)
					.then().log().all()
						.assertThat().statusCode(APIHttpStatus.OK_200.getCode());
}}
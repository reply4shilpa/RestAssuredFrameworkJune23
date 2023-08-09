package com.gorest.tests;

import org.testng.annotations.Test;
import static org.hamcrest.Matchers.equalTo;

import java.util.HashMap;
import java.util.Map;

import com.qa.gorest.base.BaseTest;

public class GetUserTest extends BaseTest{

	
	@Test
	public void getAllUsersTest() {
		
		restClient.get("/public/v2/users", false)
		.then().log().all()
			.assertThat().statusCode(200);
			
	}
	
	/*
	 * @Test public void getUserTest() {
	 * 
	 * restClient.get("/public/v2/users/"+4245454, true) .then().log().all()
	 * .assertThat().statusCode(200) .and() .body("id", equalTo(4245292));
	 * 
	 * }
	 * 
	 * 
	 * @Test public void getUserWithQueryParamsTest() {
	 * 
	 * Map <String, String> queryParams=new HashMap <String, String> ();
	 * queryParams.put("name", "shilpa"); queryParams.put("status", "active");
	 * 
	 * restClient.get("/public/v2/users/", queryParams, null, false)
	 * .then().log().all() .assertThat().statusCode(200);
	 * 
	 * 
	 * }
	 */
	 
}

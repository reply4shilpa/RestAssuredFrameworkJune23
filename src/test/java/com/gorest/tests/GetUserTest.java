package com.gorest.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.equalTo;

import java.util.HashMap;
import java.util.Map;

import com.qa.gorest.base.BaseTest;
import com.qa.gorest.client.RestClient;

public class GetUserTest extends BaseTest{

	@BeforeMethod
	public void getUserSetUp() {
		
		restClient=new RestClient(prop, baseURI);
	}
	
	@Test(enabled=true, priority=3)
	public void getAllUsersTest() {
		
		restClient.get(GOREST_ENDPOINT, true,  false)
		.then().log().all()
			.assertThat().statusCode(200);
			
	}
	
	
	  @Test (enabled=true, priority=2)
	  public void getUserTest() {
	  
	  restClient.get(GOREST_ENDPOINT+4245454, true, true)
	  	.then().log().all()
	  		.assertThat().statusCode(200)
	  			.and() .body("id", equalTo(4245454));
	  
	  }
	  
	  
		
		  @Test (priority=1)
		  public void getUserWithQueryParamsTest() {
		  
		  Map <String, String> queryParams=new HashMap <String, String> ();
		  queryParams.put("name", "shilpa"); queryParams.put("status", "active");
		  
		  restClient.get(GOREST_ENDPOINT, queryParams, null, true, true)
		  .then().log().all() .assertThat().statusCode(200);
		  
		  
		  }
		 
	 
	 
}

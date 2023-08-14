package com.gorest.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.gorest.base.BaseTest;
import com.qa.gorest.client.RestClient;

public class ReqresAPITest extends BaseTest{
	
	@BeforeMethod
	public void getUserSetUp() {
		
		restClient=new RestClient(prop, baseURI);
	}
	
	@Test
	public void getAllUserReqResTest() {
		
		restClient.get(REQRES_ENDPOINT, false, false)
				.then().log().all()
				.assertThat().statusCode(200);
			
	}
	

}

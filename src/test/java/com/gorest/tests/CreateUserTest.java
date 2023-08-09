package com.gorest.tests;

import org.testng.annotations.Test;

import com.qa.gorest.base.BaseTest;
import com.qa.gorest.client.RestClient;
import com.qa.gorest.pojo.User;
import com.qa.gorest.utils.StringUtil;

import static org.hamcrest.Matchers.equalTo;
import static org.testng.Assert.assertNotEqualsDeep;

import java.util.HashMap;
import java.util.Map;

public class CreateUserTest extends BaseTest {

	RestClient restClient, restClient1;
	
	@Test
	public void createUserTest() {
		
		User user=new User("Shilpa",StringUtil.getRandomEmailId(), "female","active");
		restClient=new RestClient();
		
		Integer userId=	restClient.post("/public/v2/users", "json", user, false)
		.then().log().all()
			.assertThat().statusCode(201)
				.extract().path("id");
		System.out.println("User Id is:- > "+userId);
	
	//GET call to fetch the id
		 restClient1=new RestClient(prop, baseURI);
		restClient1.get("/public/v2/users/"+userId, true)
		.then().log().all()
			.assertThat().statusCode(200)
				.assertThat() .body("id", equalTo(userId));
			
	}
	
}
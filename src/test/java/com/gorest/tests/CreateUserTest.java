package com.gorest.tests;

import org.testng.annotations.BeforeMethod;
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

	@BeforeMethod
	public void getUserSetUp() {
		
		restClient=new RestClient(prop, baseURI);
	}
	//sonar cube for code smells ..all hardcoded values 
	
	@Test
	public void createUserTest() {

		User user = new User("Shilpa", StringUtil.getRandomEmailId(), "female", "active");
		// restClient=new RestClient(prop, baseURI);

		Integer userId = restClient.post(GOREST_ENDPOINT, "json", user, true, false).then().log().all()
				.assertThat().statusCode(201)
					.extract().path("id");
		
		System.out.println("User Id is:- > " + userId);

		// GET call to fetch the id
		
		RestClient	 clientGet=new RestClient(prop, baseURI);
		 
		 
		clientGet.get(GOREST_ENDPOINT+ userId, true, true).then().log().all().assertThat().statusCode(200)
				.assertThat().body("id", equalTo(userId));

	}
	
}
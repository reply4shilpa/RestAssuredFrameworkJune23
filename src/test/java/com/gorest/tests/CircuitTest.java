package com.gorest.tests;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.gorest.base.BaseTest;
import com.qa.gorest.utils.JsonPathValidator;

import io.restassured.response.Response;

public class CircuitTest extends BaseTest {
	
	@Test
	public void getAllUsersTest() {
		
		Response circuitResponse=restClient.get("/api/f1/2017/circuits.json", false,false);
			int statusCode=circuitResponse.statusCode();
			JsonPathValidator js=new JsonPathValidator();
			List<String> countryList=js.readList(circuitResponse, "$..Circuits..country");
			System.out.println(countryList);
			Assert.assertEquals("", "");
			
			
			
	}
	

}

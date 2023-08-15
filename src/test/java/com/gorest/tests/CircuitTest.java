package com.gorest.tests;

import java.util.List;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.gorest.base.BaseTest;
import com.qa.gorest.client.RestClient;
import com.qa.gorest.constants.APIHttpStatus;
import com.qa.gorest.utils.JsonPathValidator;

import io.restassured.response.Response;

public class CircuitTest extends BaseTest {

	@BeforeMethod
	public void getUserSetUp() {

		restClient = new RestClient(prop, baseURI);
	}

	@Test 
	public void getAllCircuitTest() {

			Response circuitResponse=restClient.get(CIRCUIT_ENDPOINT+"/2020/circuits.json", false, false);
			
			int statusCode=circuitResponse.statusCode();
			Assert.assertEquals(statusCode, APIHttpStatus.OK_200.getCode());
		
		   JsonPathValidator js=new  JsonPathValidator();
		   List<Map<String, String>> circuitInfo=js.readListofMaps(circuitResponse, "$.MRData.CircuitTable.Circuits[?(@.Location='sakhir')].[\"circuitId\",\"circuitName\"]"); 
		   
		   		System.out.println(circuitInfo);
		   		for (Map<String, String> info : circuitInfo) {

					String circuitId =  info.get("circuitId");
					String circuitName =info.get("circuitName");

					System.out.println(" circuit Id:-> " + circuitId + " circuit Name:-> " + circuitName);
				}

	}

	// "$.MRData.CircuitTable.Circuits[?(@.circuitId='Bahrain')].[circuitId,locality]"
	// $.MRData.CircuitTable.Circuits[?(@.Location='sakhir')].[circuitId,circuitName]
	//.[\"title\",\"price\"]")
	//$.MRData.CircuitTable.Circuits[?(@.Location=='sakhir')]
	
	
	@Test
	public void getLegthOfCircuitTest() {

		Response circuitResponse=restClient.get(CIRCUIT_ENDPOINT+"/2020/circuits.json", false, false);
			
		int statusCode=circuitResponse.statusCode();
		Assert.assertEquals(statusCode, APIHttpStatus.OK_200.getCode());
		
		  
		   JsonPathValidator js=new  JsonPathValidator();
		  
		   Integer totalCircuits=js.read(circuitResponse, "$.MRData.CircuitTable.Circuits.length()"); 
		   		System.out.println(totalCircuits);
		   		Assert.assertEquals(14, totalCircuits);
		 

	}
}

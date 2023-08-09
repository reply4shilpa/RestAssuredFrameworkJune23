package com.qa.gorest.utils;

import java.util.List;
import java.util.Map;

import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.PathNotFoundException;
import com.qa.gorest.frameExceptions.APIFrameException;

import io.restassured.response.Response;

	public class JsonPathValidator {
		
		private String getJsonResponseAsString(Response response) {
			
			return response.getBody().asString();
		}
	
		public <T> List<T> readList(Response response, String jsonPath) {	//T could be anything/ any datatypes, so here list of anything
		
			String jsonResponse=getJsonResponseAsString(response);
			try {
					return	JsonPath.read(jsonResponse,jsonPath);
		
			}catch(PathNotFoundException e) {e.printStackTrace();
		
		
			throw new APIFrameException (jsonPath+"is not found..");
		}
		
		
		
	}
	
		public <T> Map<String, T> readListofMaps(Response response, String jsonPath) {	//T could be anything/ any datatypes, so here list of anything
		
			String jsonResponse=getJsonResponseAsString(response);
			try {
					return	JsonPath.read(jsonResponse,jsonPath);
		
			}catch(PathNotFoundException e) {e.printStackTrace();
		
		
			throw new APIFrameException (jsonPath+"is not found..");
		}
		
		
		
	}

}

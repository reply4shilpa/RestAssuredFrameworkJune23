package com.qa.gorest.utils;

import java.util.List;
import java.util.Map;

import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.PathNotFoundException;
import com.qa.gorest.frameExceptions.APIFrameworkException;

//Using JsonPath JsonPath allows you to compile a json path string to use it many times or to compile and apply
// in onesingle on demand operation. JayWay library we can validate the data with the response 

import io.restassured.response.Response;

	public class JsonPathValidator {
		
		private String getJsonResponseAsString(Response response) {
			
			return response.getBody().asString();
		}
		
		
		public <T> T read(Response response, String jsonPath) {	//T could be anything/ any datatypes, so here list of anything(java generics)
			
			String jsonResponse=getJsonResponseAsString(response);
			try {
					return	JsonPath.read(jsonResponse, jsonPath);
		
			}catch(PathNotFoundException e) {
				
					e.printStackTrace();
					throw new APIFrameworkException (jsonPath+"is not found..");
		}
	}
	
		public <T> List<T> readList(Response response, String jsonPath){
		
			String jsonResponse=getJsonResponseAsString(response);
			try {
					return	JsonPath.read(jsonResponse, jsonPath);
		
			}catch(PathNotFoundException e) {
				
					e.printStackTrace();
					throw new APIFrameworkException (jsonPath+"is not found..");
		}
		
		
		
	}
	
	public <T>  List<Map<String, T>> readListofMaps(Response response, String jsonPath) {

		String jsonResponse = getJsonResponseAsString(response);
		try {
			return JsonPath.read(jsonResponse, jsonPath);

		} catch (PathNotFoundException e) {
			e.printStackTrace();

			throw new APIFrameworkException(jsonPath + "is not found..");
		}

	}

}

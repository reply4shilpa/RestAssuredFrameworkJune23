package com.qa.gorest.client;

import java.util.Map;
import java.util.Properties;

import com.qa.gorest.frameExceptions.APIFrameException;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RestClient {
	private static RequestSpecBuilder specBuilder;
	//private static final String BASE_URI = "https://gorest.co.in";
	//private static final String BEARER_TOKEN = "e4b8e1f593dc4a731a153c5ec8cc9b8bbb583ae964ce650a741113091b4e2ac6";
	private Properties prop;
	private String baseURI;	
	/*
	 * static { // before main method this static code will execute specBuilder =
	 * new RequestSpecBuilder(); }
	 */
	
	
	public RestClient(Properties prop, String baseURI ) {
		
		specBuilder=new RequestSpecBuilder();
		this.prop=prop;
		this.baseURI=baseURI;
	}
	
	
	
	public void addAuthorizationHeader() {

		specBuilder.addHeader("Authorization", "Bearer " + prop.getProperty("tokenId"));
	}
	
	
	
	
	private void setRequestContentType(String contentType) {
		switch (contentType.toLowerCase()) {
		case "json":
			specBuilder.setContentType(ContentType.JSON);
			break;
			
		case "xml":
			specBuilder.setContentType(ContentType.XML);
			break;
			
		case "text":
			specBuilder.setContentType(ContentType.TEXT);
			break;
			
		case "multipart":
			specBuilder.setContentType(ContentType.MULTIPART);
			break;
			
		default:
			System.out.println("Pleasepass right content type");
			throw new APIFrameException("invalid contenttype");
		}
		
	}
	
	
	
	
	
	private RequestSpecification createRequestSpec() {

		specBuilder.setBaseUri(baseURI);
		addAuthorizationHeader();
		return specBuilder.build();

	}

	
	private RequestSpecification createRequestSpec(Map<String, String> headersMap) {

		specBuilder.setBaseUri(baseURI);
		addAuthorizationHeader();
		if (headersMap != null) {
			specBuilder.addHeaders(headersMap);
		}
		return specBuilder.build();

	}

	
	private RequestSpecification createRequestSpec(Map<String, String> headersMap, Map<String, String> queryParams) {

		specBuilder.setBaseUri(baseURI);
		addAuthorizationHeader();
		if (headersMap != null) {
			specBuilder.addHeaders(headersMap);
		}
		if (queryParams != null) {
			specBuilder.addQueryParams(queryParams);
		}

		return specBuilder.build();

	}
	
	
	private RequestSpecification createRequestSpec(Object requestBody, String contentType)
	{

		specBuilder.setBaseUri(baseURI);
		addAuthorizationHeader();
		setRequestContentType(contentType);
		
		
		if (requestBody != null) {
			specBuilder.setBody(requestBody);
		}
		return specBuilder.build();
	}
	
	
	private RequestSpecification createRequestSpec(Object requestBody, String contentType, Map<String, String> headersMap )
	{

		specBuilder.setBaseUri(baseURI);
		addAuthorizationHeader();
		setRequestContentType(contentType);
		
		if (headersMap != null) {
			specBuilder.addHeaders(headersMap);
		}
		
		if (requestBody != null) {
			specBuilder.setBody(requestBody);
		}
		return specBuilder.build();

		
	}
	
	//Http Methods Util
	
	//1. GET call
	
	public Response get(String serviceUrl, boolean log) {
		
		if(log) {
			return RestAssured.given(createRequestSpec()).log().all()
						.when()
							.get(serviceUrl);
		
		}
		return RestAssured.given(createRequestSpec()).when() .get(serviceUrl);
		
			
	}
		
		
	public Response get(String serviceUrl, Map<String, String>headersMap, boolean log) {
		
		if(log) {
			return RestAssured.given(createRequestSpec(headersMap)).log().all()
					.when()
						.get(serviceUrl);
		
		}
		return RestAssured.given(createRequestSpec(headersMap)).when() .get(serviceUrl);
		
			
	}	
		
	public Response get(String serviceUrl, Map<String, String>queryParams,  Map<String, String>headersMap, boolean log) {
		
		if(log) {
			return RestAssured.given(createRequestSpec(headersMap, queryParams)).log().all()
					.when()
						.get(serviceUrl);
		
		}
		return RestAssured.given(createRequestSpec(headersMap, queryParams)).when() .get(serviceUrl);
		
			
	}	
	
	
	
	//2. POST call	
		public Response post(String serviceUrl, String contentType, Object requestBody, Map<String, String> headersMap, boolean log) {
		
			if (log) {
			return RestAssured.given(createRequestSpec(requestBody, contentType, headersMap)).log().all()
					.when()
						.post(serviceUrl);
			
			
		}
		
			return RestAssured.given(createRequestSpec(requestBody, contentType, headersMap)).when().post(serviceUrl);
		
	}	
		
		
		public Response post(String serviceUrl, String contentType, Object requestBody, boolean log) {
			
			if (log) {
			return RestAssured.given(createRequestSpec(requestBody, contentType)).log().all()
					.when()
						.post(serviceUrl);
		}
		
			return RestAssured.given(createRequestSpec(requestBody, contentType)).when().post(serviceUrl);
		
	}	
		
		
		
		//3. PUT Call
		
		public Response put(String serviceUrl, String contentType, Object requestBody, Map<String, String> headersMap, boolean log) {
			
			if (log) {
			return RestAssured.given(createRequestSpec(requestBody, contentType, headersMap)).log().all()
					.when()
						.put(serviceUrl);
			
			
		}
		
			return RestAssured.given(createRequestSpec(requestBody, contentType, headersMap)).when().put(serviceUrl);
		
	}	
		
		
		public Response put(String serviceUrl, String contentType, Object requestBody, boolean log) {
			
			if (log) {
			return RestAssured.given(createRequestSpec(requestBody, contentType)).log().all()
					.when()
						.put(serviceUrl);
		}
		
			return RestAssured.given(createRequestSpec(requestBody, contentType)).when().put(serviceUrl);
		
		
		
		}	
		
		// 4. PATCH Call
		
		public Response patch(String serviceUrl, String contentType, Object requestBody, Map<String, String> headersMap, boolean log) {
			
			if (log) {
			return RestAssured.given(createRequestSpec(requestBody, contentType, headersMap)).log().all()
					.when()
						.post(serviceUrl);
			
			
		}
		
			return RestAssured.given(createRequestSpec(requestBody, contentType, headersMap))
					.when()
						.patch(serviceUrl);
		
		}	
		
		
		public Response patch(String serviceUrl, String contentType, Object requestBody, boolean log) {
			
			if (log) {
			return RestAssured.given(createRequestSpec(requestBody, contentType)).log().all()
					.when()
						.patch(serviceUrl);
		}
		
			return RestAssured.given(createRequestSpec(requestBody, contentType))
					.when()
						.patch(serviceUrl);
		
	}	
		
		
		// 5. DELETE CALL
		
		public Response delete(String serviceUrl, boolean log) {
			
			if (log) {
			return RestAssured.given(createRequestSpec()).log().all()
					.when()
						.delete(serviceUrl);
		}
		
			return RestAssured.given(createRequestSpec())
					.when()
						.delete(serviceUrl);
		
	}	
		
		
	}
	
	

package com.qa.gorest.base;

import java.util.Properties;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.qa.gorest.client.RestClient;
import com.qa.gorest.configuration.ConfigurationManager;

public class BaseTest {
	
	protected ConfigurationManager config;
	protected Properties prop;
	protected RestClient restClient;
	
	@Parameters({"baseURI"})
	@BeforeTest
	public void setUp(String baseURI) {
		
		config=new ConfigurationManager();
		prop=config.initProp();
	//	 baseURI=	prop.getProperty("baseURI");
		restClient=new RestClient(prop,baseURI);
		
		
	}
	
	
	
	
	
	

}

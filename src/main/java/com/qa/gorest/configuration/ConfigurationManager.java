package com.qa.gorest.configuration;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import com.qa.gorest.frameExceptions.APIFrameworkException;

public class ConfigurationManager {

	private Properties prop;
	private FileInputStream ip;

	public Properties initProp() {

		// mvn clean install -Denv="stage" (-D is a flag and env is stage)
		// mvn clean install -Denv="qa"

		String envName = System.getProperty("env");   // imp
		System.out.println("Running the test cases on env: " + envName);

		if (envName == null) {
			System.out.println("environment is not given, hence running on QA");
		}

		else {
			System.out.println("Running the test cases on env: " + envName);

			try {
				switch (envName.toLowerCase().trim()) {

				case "qa":

					ip = new FileInputStream("./src/test/resources/config/qa.config.properties");
					break;

				case "stage":

					ip = new FileInputStream("./src/test/resources/config/stage.config.properties");
					break;

				case "dev":

					ip = new FileInputStream("./src/test/resources/config/dev.config.properties");
					break;

				default:
					System.out.println("No env given..Running the test cases on env: " + envName);
					throw new APIFrameworkException("env not given");
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}

			try {

				prop.load(ip);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return prop;
	}

}

package com.dynamo.dynamoapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DynamoAppApplication {
	public String PORT = System.getenv("PORT");

	public static void main(String[] args) {
		SpringApplication.run(DynamoAppApplication.class, args);
	}

}

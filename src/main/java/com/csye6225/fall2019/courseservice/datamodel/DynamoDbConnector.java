package com.csye6225.fall2019.courseservice.datamodel;

import com.amazonaws.auth.DefaultAWSCredentialsProviderChain;
import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;

public class DynamoDbConnector {
    static AmazonDynamoDB dynamoDb ;

    public static void init() {
        if (dynamoDb == null) {
//            ProfileCredentialsProvider credentialsProvider = new ProfileCredentialsProvider();
//            credentialsProvider.getCredentials();

            dynamoDb = AmazonDynamoDBClientBuilder
                    .standard()
                    .withCredentials(DefaultAWSCredentialsProviderChain.getInstance())
                    .withRegion("us-east-1")
                    .build();
        }

    }

    public AmazonDynamoDB getClient() {
        init();
        return dynamoDb;
    }
}

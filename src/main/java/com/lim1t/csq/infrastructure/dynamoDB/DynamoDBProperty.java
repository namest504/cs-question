package com.lim1t.csq.infrastructure.dynamoDB;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "spring.aws.dynamo")
public record DynamoDBProperty(String accessKey, String secretKey) {
}

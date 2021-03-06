package com.api.gestao.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import software.amazon.awssdk.auth.credentials.DefaultCredentialsProvider
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient
import software.amazon.awssdk.regions.Region
import software.amazon.awssdk.services.dynamodb.DynamoDbClient

@Configuration
class DynamoConfig {

    @Bean
    fun configDynamoDBClient() : DynamoDbEnhancedClient {
        val provider = DefaultCredentialsProvider.builder().build()
        val dynamoDBClient = DynamoDbClient
            .builder()
            .region(Region.US_EAST_1)
            .credentialsProvider(provider)
            .build()
        return DynamoDbEnhancedClient.builder().dynamoDbClient(dynamoDBClient).build()
    }
}
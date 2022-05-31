package com.api.gestao.config

import com.amazonaws.auth.AWSStaticCredentialsProvider
import com.amazonaws.auth.DefaultAWSCredentialsProviderChain
import com.amazonaws.regions.Regions
import com.amazonaws.services.sqs.AmazonSQSAsync
import com.amazonaws.services.sqs.AmazonSQSAsyncClientBuilder
import org.springframework.cloud.aws.messaging.config.SimpleMessageListenerContainerFactory
import org.springframework.cloud.aws.messaging.config.annotation.EnableSqs
import org.springframework.cloud.aws.messaging.core.QueueMessagingTemplate
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Primary

@Configuration
@EnableSqs
class Config {

    @Bean
    fun configCredentials() = DefaultAWSCredentialsProviderChain().credentials

    @Bean
    @Primary
    fun amazonSQSAsync() : AmazonSQSAsync{
       return  AmazonSQSAsyncClientBuilder
            .standard()
            .withRegion(Regions.US_EAST_1)
            .withCredentials(AWSStaticCredentialsProvider(configCredentials()))
            .build()
    }

    @Bean
    fun queueMessageTemplate(sqsAsync : AmazonSQSAsync) : QueueMessagingTemplate = QueueMessagingTemplate(sqsAsync)
}
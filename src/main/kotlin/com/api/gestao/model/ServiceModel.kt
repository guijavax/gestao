package com.api.gestao.model

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbPartitionKey
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbSortKey

@DynamoDBTable(tableName = "servicos")
data class ServiceModel(

    @get:DynamoDbPartitionKey
    @get:DynamoDBAttribute(attributeName = "servicoId")
    var serviceId : String = "",

    @get:DynamoDbSortKey
    @get:DynamoDBAttribute(attributeName = "responsavel")
    var responsavel : String = ""
)
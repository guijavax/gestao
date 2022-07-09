package com.api.gestao.model

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbPartitionKey
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbSortKey
import java.math.BigDecimal
import java.time.Instant

@DynamoDbBean
@DynamoDBTable(tableName = "servicos")
data class ServiceModel(

    @get:DynamoDbPartitionKey
    @get:DynamoDBAttribute(attributeName = "servicoId")
    var servicoId : String = "",

    @get:DynamoDbSortKey
    @get:DynamoDBAttribute(attributeName = "tipoServico")
    var tipoServico : String = "",

    var dataContratacao : Instant = Instant.now(),

    var dataExecucao : Instant = Instant.now(),

    var valorServico : BigDecimal = BigDecimal.ZERO

)
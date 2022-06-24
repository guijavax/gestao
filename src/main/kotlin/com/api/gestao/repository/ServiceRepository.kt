package com.api.gestao.repository

import com.api.gestao.model.ServiceModel
import org.springframework.stereotype.Repository
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbTable
import software.amazon.awssdk.enhanced.dynamodb.Key
import software.amazon.awssdk.enhanced.dynamodb.TableSchema

@Repository
class ServiceRepository(val dynamoDbEnhancedClient: DynamoDbEnhancedClient) {

    private fun getTable() : DynamoDbTable<ServiceModel>
    = dynamoDbEnhancedClient.table("servicos", TableSchema.fromBean(ServiceModel::class.java))


    private fun getKey(serviceId : String, tipoServico : String)
    = Key.builder().partitionValue(serviceId).sortValue(tipoServico).build()
}
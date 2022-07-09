package com.api.gestao.service

import com.api.gestao.generic.GenericMessageToModel
import com.api.gestao.model.ServiceModel
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.cloud.aws.messaging.listener.SqsMessageDeletionPolicy
import org.springframework.cloud.aws.messaging.listener.annotation.SqsListener
import org.springframework.stereotype.Component

@Component
class ReceivedMessage {

    @Autowired
    @Qualifier(value = "service")
    lateinit var convertService : GenericMessageToModel

    @Autowired
    lateinit var service : OperationService

    @SqsListener(value = ["salva_servico"], deletionPolicy = SqsMessageDeletionPolicy.ON_SUCCESS)
    fun receiveMessage(message : String) {
        val serviceModel = convertService.converter(message) as ServiceModel
        service.saveServico(serviceModel)
        
    }
}
package com.api.gestao.service

import org.springframework.cloud.aws.messaging.listener.SqsMessageDeletionPolicy
import org.springframework.cloud.aws.messaging.listener.annotation.SqsListener
import org.springframework.stereotype.Component

@Component
class ReceivedMessage {

    @SqsListener(value = ["salva_aluno"], deletionPolicy = SqsMessageDeletionPolicy.ON_SUCCESS)
    fun receiveMessage(message : String) {
        println(message)
    }
}
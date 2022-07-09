package com.api.gestao.service

import com.api.gestao.model.ServiceModel
import com.api.gestao.repository.ServiceRepository
import org.springframework.stereotype.Service

@Service
class OperationService(var repository: ServiceRepository) {

    fun saveServico(serviceModel : ServiceModel) {
        repository.saveServico(serviceModel)
    }

}
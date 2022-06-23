package com.api.gestao.converter

import com.api.gestao.generic.GenericMessageToModel
import com.api.gestao.model.ServiceModel
import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.stereotype.Service

@Service(value = "service")
class ConverterMessageToServicoModel : GenericMessageToModel {

    override fun converter(message: String) {
        ObjectMapper().readValue(message, ServiceModel::class.java)
    }
}
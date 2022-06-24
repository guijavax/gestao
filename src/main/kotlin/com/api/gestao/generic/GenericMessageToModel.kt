package com.api.gestao.generic

interface GenericMessageToModel {

    fun converter(message : String) : Any
}
package com.api.gestao

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.scheduling.annotation.EnableScheduling

@SpringBootApplication
class GestaoApplication

fun main(args: Array<String>) {
	runApplication<GestaoApplication>(*args)
}

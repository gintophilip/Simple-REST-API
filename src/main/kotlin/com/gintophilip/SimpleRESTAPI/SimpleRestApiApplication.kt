package com.gintophilip.SimpleRESTAPI

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SimpleRestApiApplication

fun main(args: Array<String>) {
	runApplication<SimpleRestApiApplication>(*args)
}

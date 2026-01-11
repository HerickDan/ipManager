package com.ipManager.ipManager

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class IpManagerApplication

fun main(args: Array<String>) {
	runApplication<IpManagerApplication>(*args)
}

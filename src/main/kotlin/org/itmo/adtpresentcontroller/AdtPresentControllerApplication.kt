package org.itmo.adtpresentcontroller

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@SpringBootApplication
@EnableJpaRepositories
class AdtPresentControllerApplication

fun main(args: Array<String>) {
    runApplication<AdtPresentControllerApplication>(*args)
}

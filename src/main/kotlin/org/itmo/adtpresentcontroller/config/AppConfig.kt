package org.itmo.adtpresentcontroller.config

import io.github.cdimascio.dotenv.Dotenv
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.jdbc.datasource.DriverManagerDataSource
import javax.sql.DataSource

@Configuration
class AppConfig {
    private val dotenv: Dotenv = Dotenv.load()

    @Bean
    fun dataSource(): DataSource {
        val dataSource = DriverManagerDataSource()

        dataSource.url = dotenv.get("DB_URL")
        dataSource.username = dotenv.get("DB_USERNAME")
        dataSource.password = dotenv.get("DB_PASSWORD")
        dataSource.schema = dotenv.get("DB_SCHEMA")

        return dataSource
    }
}
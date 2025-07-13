package com.alonso.demokotlin.config

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.databind.SerializationFeature
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder

@Configuration
class JacksonConfig {
    @Bean
    fun jacksonObjectMapperBuilder(): Jackson2ObjectMapperBuilder =
        Jackson2ObjectMapperBuilder()
            .serializationInclusion(JsonInclude.Include.NON_NULL)
            .featuresToDisable(SerializationFeature.WRITE_NULL_MAP_VALUES)
}

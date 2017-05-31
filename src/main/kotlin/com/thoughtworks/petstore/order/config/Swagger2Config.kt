package com.thoughtworks.petstore.order.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

import springfox.documentation.builders.ApiInfoBuilder
import springfox.documentation.builders.PathSelectors
import springfox.documentation.builders.RequestHandlerSelectors
import springfox.documentation.service.ApiInfo
import springfox.documentation.spi.DocumentationType
import springfox.documentation.spring.web.plugins.Docket
import springfox.documentation.swagger2.annotations.EnableSwagger2

/**
 * Configuration注解　加载此类配置
 * EnableSwagger2注解　启用Swagger2
 */
@Configuration
@EnableSwagger2
open class Swagger2Config {

    @Bean
    open fun createRestApi(): Docket {
        return Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .groupName("")
                .pathMapping("")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.thoughtworks.petstore.order.controller"))
                .paths(PathSelectors.any())
                .build()
    }

    private fun apiInfo(): ApiInfo {
        return ApiInfoBuilder()
                .title("Order Service API")
                .description("")
                .version("1.0")
                .termsOfServiceUrl("")
                .license("")
                .licenseUrl("")
                .build()
    }
}

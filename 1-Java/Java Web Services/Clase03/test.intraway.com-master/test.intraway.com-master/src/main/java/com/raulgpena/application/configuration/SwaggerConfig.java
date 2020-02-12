/*
 * @(#SwaggerConfig.java 01/01/2019
 * Copyright 2018 Raul Pena, Inc. All rights reserved.
 * RAULGPENA/CONFIDENTIAL
 * */

package com.raulgpena.application.configuration;


// Springframework Imports.
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// Swagger Imports.
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@Configuration
@EnableSwagger2
public class SwaggerConfig {


    @Bean
    public ApiInfo apiInfo () {

        return new ApiInfoBuilder ()
                .title ("Intraway Rest API")
                .description ("Hiring Project.")
                .version ("1.0.0")
                .termsOfServiceUrl ("http://terms-of-services.url")
                .license ("LICENSE")
                .licenseUrl ("http://url-to-license.com")
                .build ();
    }

    @Bean
    public Docket api () {
        return new Docket (DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build();
    }
}
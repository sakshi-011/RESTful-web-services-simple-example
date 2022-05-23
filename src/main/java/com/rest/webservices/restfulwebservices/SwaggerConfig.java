package com.rest.webservices.restfulwebservices;

import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.OpenAPI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.*;

@Configuration
public class SwaggerConfig {

    //URL for JSON format - http://server:port/context-path/v3/api-docs
    //URL for UI - http://server:port/context-path/swagger-ui.html

    public static final Contact DEFAULT_CONTACT = new Contact().name("sakshi-011").email("");

    @Bean
    public OpenAPI api(){
        return new OpenAPI()
                .info(new Info().title("User API")
                        .description("User API Description")
                        .version("v0.0.1")
                        .license(new License().name("Apache 2.0").url("http://springdoc.org"))
                        .contact(DEFAULT_CONTACT));
    }
}

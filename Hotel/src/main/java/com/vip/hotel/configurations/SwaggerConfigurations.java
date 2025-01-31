package com.vip.hotel.configurations;

import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;

@Configuration
@OpenAPIDefinition(
		info = @Info(title = "Hotel", description = "Swagger dashboard for Hotel Service.",
		version = "1.0.0",  // API version
		contact = @Contact(name = "Vipin Kumar", email = "vipin.kumar03@motherson.com")), 
		servers = {@Server(description = "Local server", url = "http://localhost:7072"),})
public class SwaggerConfigurations {

}

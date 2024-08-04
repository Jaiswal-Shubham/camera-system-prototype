package com.nymble.shubham.camera_system.config;


import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(
        info = @Info(
                contact = @Contact(
                        name = "Shubham",
                        email = "shkjais@gmail.com",
                        url = "https://www.linkedin.com/in/shubham-kumar-jaiswal-003497b3/"
                ),
                description = "OpenApi documentation for Backend APIs",
                title = "OpenApi specification ",
                version = "1.0",
                license = @License(
                        name = "Built by Shubham Jaiswal",
                        url = ""
                ),
                termsOfService = "Terms of service"
        ),
        servers = {
                @Server(
                        description = "Local ENV",
                        url = "http://localhost:8080"
                ),
                @Server(
                        description = "Prod ENV",
                        url = ""
                )
        }
)
public class OpenApiConfig {
}


package com.ecommerce.order.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

/**
 * OpenAPI/Swagger configuration for API documentation.
 */
@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI orderManagementOpenApi() {
        return new OpenAPI()
                .info(new Info()
                        .title("Order Management System API")
                        .description("RESTful API for managing e-commerce orders")
                        .version("1.0.0")
                        .contact(new Contact()
                                .name("DevOps CI/CD Project")
                                .email("devops@example.com"))
                        .license(new License()
                                .name("MIT License")
                                .url("https://opensource.org/licenses/MIT")))
                .servers(List.of(
                        new Server().url("http://localhost:8080").description("Local Development"),
                        new Server().url("http://order-service:8080").description("Kubernetes")));
    }
}

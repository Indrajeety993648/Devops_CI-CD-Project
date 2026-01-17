package com.ecommerce.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Order Management System - Main Application Entry Point.
 *
 * <p>This microservice handles order lifecycle management for an e-commerce platform.
 * It demonstrates production-grade CI/CD practices with security scanning,
 * code quality checks, and containerized deployment to Kubernetes.</p>
 *
 * @author DevOps CI/CD Project
 * @version 1.0.0
 */
@SpringBootApplication
public class OrderManagementApplication {

    /**
     * Main entry point for the Spring Boot application.
     *
     * @param args command line arguments
     */
    public static void main(final String[] args) {
        SpringApplication.run(OrderManagementApplication.class, args);
    }
}

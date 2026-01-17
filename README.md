# Order Management System

A production-grade E-Commerce Order Management Microservice demonstrating DevOps CI/CD practices.

## Features

- RESTful API for order management
- CI/CD pipeline with security scanning
- Kubernetes deployment ready
- Comprehensive testing

## Tech Stack

- Java 17, Spring Boot 3.2
- H2 Database (dev), PostgreSQL (prod)
- Docker, Kubernetes
- GitHub Actions CI/CD

## Quick Start

```bash
# Run locally
mvn spring-boot:run -Dspring-boot.run.profiles=dev

# Access API
curl http://localhost:8080/api/v1/orders/health

# Swagger UI
open http://localhost:8080/swagger-ui.html
```

## Docker

```bash
docker build -t order-management-system .
docker run -p 8080:8080 order-management-system
```

## Kubernetes

```bash
minikube start
kubectl apply -f k8s/complete-deployment.yaml
minikube service order-management-service -n order-management
```

## API Endpoints

| Method | Endpoint | Description |
|--------|----------|-------------|
| POST | /api/v1/orders | Create order |
| GET | /api/v1/orders | List orders |
| GET | /api/v1/orders/{id} | Get order |
| PUT | /api/v1/orders/{id}/status | Update status |
| PUT | /api/v1/orders/{id}/cancel | Cancel order |
| DELETE | /api/v1/orders/{id} | Delete order |

## GitHub Secrets Required

- `DOCKERHUB_USERNAME`
- `DOCKERHUB_TOKEN`

## Project Structure

```
├── src/main/java/com/ecommerce/order/
│   ├── config/          # Configuration classes
│   ├── controller/      # REST controllers
│   ├── dto/             # Data transfer objects
│   ├── exception/       # Exception handling
│   ├── mapper/          # MapStruct mappers
│   ├── model/           # JPA entities
│   ├── repository/      # Data access
│   └── service/         # Business logic
├── k8s/                 # Kubernetes manifests
├── .github/workflows/   # CI/CD pipeline
└── docs/                # Documentation
```

# 🛒 Order Management System

<div align="center">

![Java](https://img.shields.io/badge/Java-17-orange?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.2-brightgreen?style=for-the-badge&logo=springboot&logoColor=white)
![Docker](https://img.shields.io/badge/Docker-Ready-blue?style=for-the-badge&logo=docker&logoColor=white)
![Kubernetes](https://img.shields.io/badge/Kubernetes-Deployed-326CE5?style=for-the-badge&logo=kubernetes&logoColor=white)
![CI/CD](https://img.shields.io/badge/CI%2FCD-GitHub%20Actions-2088FF?style=for-the-badge&logo=githubactions&logoColor=white)

**A Production-Grade E-Commerce Microservice with Complete CI/CD Pipeline**

[Features](#-features) • [Architecture](#-architecture) • [CI/CD Pipeline](#-cicd-pipeline) • [Quick Start](#-quick-start) • [API Docs](#-api-documentation) • [Deployment](#-deployment)

---

</div>

## 🎯 About The Project

The **Order Management System** is a production-ready microservice that handles the complete lifecycle of e-commerce orders. Built with modern DevOps practices, it demonstrates a complete CI/CD pipeline with security scanning, containerization, and Kubernetes deployment.

### 🎓 Project Objectives

| Objective          | Implementation                |
| ------------------ | ----------------------------- |
| Secure Code        | SAST scanning with CodeQL     |
| Safe Dependencies  | SCA scanning with OWASP       |
| Container Security | Image scanning with Trivy     |
| Code Quality       | Checkstyle linting            |
| Automated Testing  | JUnit 5 with 80%+ coverage    |
| Containerization   | Multi-stage Docker build      |
| Orchestration      | Kubernetes with health probes |

---

## ✨ Features

### 🔧 Core Features

- ✅ Create, Read, Update, Delete orders
- ✅ Order status lifecycle management
- ✅ Input validation & error handling
- ✅ RESTful API design
- ✅ Swagger/OpenAPI documentation

### 🔒 Security Features

- ✅ SAST (Static Application Security Testing)
- ✅ SCA (Software Composition Analysis)
- ✅ Container vulnerability scanning
- ✅ Non-root container execution
- ✅ Sanitized error responses

### 🚀 DevOps Features

- ✅ Automated CI/CD pipeline
- ✅ Multi-stage Docker builds
- ✅ Kubernetes deployment
- ✅ Health checks & probes
- ✅ Rolling updates

---

## 🛠 Tech Stack

| Category             | Technology      | Purpose                   |
| -------------------- | --------------- | ------------------------- |
| **Language**         | Java 17         | Core programming language |
| **Framework**        | Spring Boot 3.2 | Application framework     |
| **Database**         | H2 / PostgreSQL | Data persistence          |
| **Build Tool**       | Maven 3.9       | Dependency management     |
| **Containerization** | Docker          | Container runtime         |
| **Orchestration**    | Kubernetes      | Container orchestration   |
| **CI/CD**            | GitHub Actions  | Automated pipeline        |
| **Registry**         | DockerHub       | Container image storage   |

---

## 🏗 Architecture

### Application Architecture

```
┌─────────────────────────────────────────────────────────────────┐
│                      ORDER MANAGEMENT API                        │
├─────────────────────────────────────────────────────────────────┤
│                                                                  │
│  ┌─────────────────────────────────────────────────────────┐    │
│  │                    Controller Layer                      │    │
│  │              (REST API Endpoints)                        │    │
│  └─────────────────────────┬───────────────────────────────┘    │
│                            │                                     │
│  ┌─────────────────────────▼───────────────────────────────┐    │
│  │                    Service Layer                         │    │
│  │              (Business Logic)                            │    │
│  └─────────────────────────┬───────────────────────────────┘    │
│                            │                                     │
│  ┌─────────────────────────▼───────────────────────────────┐    │
│  │                   Repository Layer                       │    │
│  │              (Data Access)                               │    │
│  └─────────────────────────┬───────────────────────────────┘    │
│                            │                                     │
│  ┌─────────────────────────▼───────────────────────────────┐    │
│  │                    Database Layer                        │    │
│  │           H2 (Dev) / PostgreSQL (Prod)                   │    │
│  └─────────────────────────────────────────────────────────┘    │
│                                                                  │
└─────────────────────────────────────────────────────────────────┘
```

### Order State Machine

```
     ┌─────────┐  confirm   ┌───────────┐  process   ┌────────────┐
     │ PENDING │ ─────────► │ CONFIRMED │ ─────────► │ PROCESSING │
     └────┬────┘            └─────┬─────┘            └──────┬─────┘
          │                       │                         │
          │ cancel                │ cancel                  │ ship
          ▼                       ▼                         ▼
     ┌─────────┐            ┌─────────┐              ┌──────────┐
     │CANCELLED│            │CANCELLED│              │  SHIPPED │
     └─────────┘            └─────────┘              └─────┬────┘
                                                           │ deliver
                                                           ▼
                                                     ┌───────────┐
                                                     │ DELIVERED │
                                                     └───────────┘
```

---

## 🔄 CI/CD Pipeline

### Pipeline Flow

```
LINT ──► SAST ──► SCA ──► TEST ──► BUILD ──► DOCKER ──► TRIVY ──► PUSH
```

### Pipeline Stages

| Stage         | Tool       | Purpose                   |
| ------------- | ---------- | ------------------------- |
| 🔍 **Lint**   | Checkstyle | Code style & quality      |
| 🛡️ **SAST**   | CodeQL     | Find code vulnerabilities |
| 📦 **SCA**    | OWASP      | Find dependency CVEs      |
| 🧪 **Test**   | JUnit      | Validate business logic   |
| 🔨 **Build**  | Maven      | Create JAR artifact       |
| 🐳 **Docker** | Buildx     | Build container image     |
| 🔎 **Scan**   | Trivy      | Scan container CVEs       |
| 🚀 **Push**   | Docker     | Push to DockerHub         |

### Security Scanning

| Tool              | Scans        | Catches                                |
| ----------------- | ------------ | -------------------------------------- |
| **SAST (CodeQL)** | Your code    | SQL Injection, XSS, Hardcoded secrets  |
| **SCA (OWASP)**   | Dependencies | Log4j, Jackson, Spring vulnerabilities |
| **Trivy**         | Container    | Alpine CVEs, JRE CVEs, Config issues   |

---

## 🚀 Quick Start

### Prerequisites

- Java 17+
- Maven 3.9+
- Docker
- Kind (for Kubernetes)
- kubectl

### Option 1: Run Locally

```bash
git clone https://github.com/indrajeetyadav89/order-management-system.git
cd order-management-system
mvn spring-boot:run -Dspring-boot.run.profiles=dev
```

### Option 2: Run with Docker

```bash
docker pull indrajeetyadav89/order-management-system:latest
docker run -p 8080:8080 indrajeetyadav89/order-management-system:latest
```

### Option 3: Deploy to Kubernetes

```bash
chmod +x deploy.sh
./deploy.sh
```

### Access Application

```
API:         http://localhost:8080/api/v1/orders
Swagger UI:  http://localhost:8080/swagger-ui.html
Health:      http://localhost:8080/api/v1/orders/health
```

---

## 📖 API Documentation

### Endpoints

| Method   | Endpoint                     | Description         |
| -------- | ---------------------------- | ------------------- |
| `POST`   | `/api/v1/orders`             | Create new order    |
| `GET`    | `/api/v1/orders`             | Get all orders      |
| `GET`    | `/api/v1/orders/{id}`        | Get order by ID     |
| `PUT`    | `/api/v1/orders/{id}/status` | Update order status |
| `PUT`    | `/api/v1/orders/{id}/cancel` | Cancel order        |
| `DELETE` | `/api/v1/orders/{id}`        | Delete order        |
| `GET`    | `/api/v1/orders/health`      | Health check        |

### Example: Create Order

```bash
curl -X POST http://localhost:8080/api/v1/orders \
  -H "Content-Type: application/json" \
  -d '{
    "customerName": "John Doe",
    "customerEmail": "john@example.com",
    "productId": "PROD-001",
    "productName": "Laptop",
    "quantity": 1,
    "unitPrice": 999.99,
    "shippingAddress": "123 Main St"
  }'
```

### Example: Health Check

```bash
curl http://localhost:8080/api/v1/orders/health
```

Response:

```json
{
  "status": "UP",
  "service": "order-management-system",
  "timestamp": "2026-01-18T10:30:00",
  "version": "1.0.0"
}
```

---

## 🚢 Deployment

### Automated Deployment

```bash
./deploy.sh      # Deploy everything
./cleanup.sh     # Cleanup when done
```

### Manual Deployment

```bash
kind create cluster --name order-cluster
kubectl apply -f k8s/complete-deployment.yaml
kubectl get pods -n order-management -w
kubectl port-forward svc/order-management-service 8080:80 -n order-management
```

### Useful Commands

```bash
kubectl get pods -n order-management          # View pods
kubectl logs -f deployment/order-management-system -n order-management  # View logs
kubectl delete -f k8s/complete-deployment.yaml  # Delete deployment
```

---

## 📂 Project Structure

```
order-management-system/
├── .github/workflows/ci.yml     # CI/CD pipeline
├── src/main/java/.../order/
│   ├── config/                  # Configuration
│   ├── controller/              # REST controllers
│   ├── dto/                     # Data Transfer Objects
│   ├── exception/               # Exception handling
│   ├── mapper/                  # MapStruct mappers
│   ├── model/                   # JPA entities
│   ├── repository/              # Data access
│   └── service/                 # Business logic
├── src/main/resources/          # Configuration files
├── src/test/                    # Unit & Integration tests
├── k8s/                         # Kubernetes manifests
├── docs/                        # Documentation
├── Dockerfile                   # Multi-stage Docker build
├── deploy.sh                    # Deployment script
├── cleanup.sh                   # Cleanup script
└── pom.xml                      # Maven configuration
```

---

## 🔒 Security

| Layer        | Security Measure | Tool               |
| ------------ | ---------------- | ------------------ |
| Code         | Static analysis  | CodeQL             |
| Dependencies | CVE scanning     | OWASP              |
| Container    | Image scanning   | Trivy              |
| Runtime      | Non-root user    | Dockerfile         |
| API          | Input validation | Jakarta Validation |

---

## 🔧 Configuration

### GitHub Secrets Required

| Secret               | Description            |
| -------------------- | ---------------------- |
| `DOCKERHUB_USERNAME` | DockerHub username     |
| `DOCKERHUB_TOKEN`    | DockerHub access token |

---

## 👨‍💻 Author

**Indrajeet Yadav**

- GitHub: [@indrajeetyadav89](https://github.com/indrajeetyadav89)

---

<div align="center">

**⭐ Star this repository if you found it helpful!**

Made with ❤️ for DevOps CI/CD Project

</div>

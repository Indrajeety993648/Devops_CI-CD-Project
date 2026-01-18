<div align="center">

<!-- Animated Header -->
<img src="https://readme-typing-svg.demolab.com?font=Fira+Code&weight=600&size=28&duration=4000&pause=1000&color=2E9EF7&center=true&vCenter=true&random=false&width=600&lines=🛒+Order+Management+System;Production-Grade+Microservice;Complete+CI%2FCD+Pipeline;Kubernetes+Deployed" alt="Typing SVG" />

<br/>
<br/>

<!-- Badges Row 1 -->
![Java](https://img.shields.io/badge/Java-17-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.2-6DB33F?style=for-the-badge&logo=springboot&logoColor=white)
![Docker](https://img.shields.io/badge/Docker-2496ED?style=for-the-badge&logo=docker&logoColor=white)
![Kubernetes](https://img.shields.io/badge/Kubernetes-326CE5?style=for-the-badge&logo=kubernetes&logoColor=white)

<!-- Badges Row 2 -->
![GitHub Actions](https://img.shields.io/badge/CI%2FCD-GitHub%20Actions-2088FF?style=for-the-badge&logo=githubactions&logoColor=white)
![Security](https://img.shields.io/badge/Security-SAST%20%7C%20SCA%20%7C%20Trivy-success?style=for-the-badge)
![License](https://img.shields.io/badge/License-MIT-yellow?style=for-the-badge)

<br/>

<!-- Quick Stats -->
<img src="https://img.shields.io/badge/Pipeline%20Stages-9-blue?style=flat-square" />
<img src="https://img.shields.io/badge/Security%20Scans-3-green?style=flat-square" />
<img src="https://img.shields.io/badge/Test%20Coverage-80%25+-brightgreen?style=flat-square" />
<img src="https://img.shields.io/badge/Docker%20Image-~150MB-orange?style=flat-square" />

<br/>
<br/>

<!-- Navigation Buttons -->
[<img src="https://img.shields.io/badge/📖_Documentation-blue?style=for-the-badge" />](#-api-documentation)
[<img src="https://img.shields.io/badge/🚀_Quick_Start-green?style=for-the-badge" />](#-quick-start)
[<img src="https://img.shields.io/badge/🔧_Deployment-orange?style=for-the-badge" />](#-deployment)
[<img src="https://img.shields.io/badge/🛡️_Security-red?style=for-the-badge" />](#-security)

---

### 🌟 A Production-Ready E-Commerce Microservice

*Demonstrating modern DevOps practices with automated CI/CD, security scanning, and Kubernetes deployment*

</div>

---

## 📊 Project Dashboard

<div align="center">
```
╔══════════════════════════════════════════════════════════════════════════════╗
║                           📈 PROJECT METRICS                                  ║
╠══════════════════════════════════════════════════════════════════════════════╣
║                                                                               ║
║   🔄 CI/CD Pipeline        🛡️ Security Scans        🧪 Test Coverage         ║
║   ┌─────────────┐          ┌─────────────┐          ┌─────────────┐          ║
║   │             │          │             │          │             │          ║
║   │   9 Stages  │          │   3 Tools   │          │    80%+     │          ║
║   │             │          │             │          │             │          ║
║   └─────────────┘          └─────────────┘          └─────────────┘          ║
║                                                                               ║
║   🐳 Docker Image          ⚡ Build Time            📦 Dependencies          ║
║   ┌─────────────┐          ┌─────────────┐          ┌─────────────┐          ║
║   │             │          │             │          │             │          ║
║   │   ~150 MB   │          │   ~12 min   │          │  Verified   │          ║
║   │             │          │             │          │             │          ║
║   └─────────────┘          └─────────────┘          └─────────────┘          ║
║                                                                               ║
╚══════════════════════════════════════════════════════════════════════════════╝
```

</div>

---

## 🎯 What This Project Demonstrates

<table>
<tr>
<td width="50%">

### ❌ Without CI/CD
```
Developer writes code
       ↓
Manual testing (maybe)
       ↓
Direct deploy to server
       ↓
🔥 BUGS IN PRODUCTION
       ↓
😱 Security vulnerabilities
       ↓
💸 Revenue loss
```

</td>
<td width="50%">

### ✅ With This CI/CD Pipeline
```
Developer writes code
       ↓
✅ Automated lint check
       ↓
✅ Security scan (SAST)
       ↓
✅ Dependency scan (SCA)
       ↓
✅ Unit tests pass
       ↓
✅ Container scan (Trivy)
       ↓
🚀 Safe deployment
```

</td>
</tr>
</table>

---

## 🔄 CI/CD Pipeline Visualization

<div align="center">
```
┌─────────────────────────────────────────────────────────────────────────────────────┐
│                                                                                      │
│   📝 CODE PUSH                                                                       │
│        │                                                                             │
│        ▼                                                                             │
│   ┌─────────┐    ┌─────────┐    ┌─────────┐    ┌─────────┐    ┌─────────┐          │
│   │  LINT   │───►│  SAST   │───►│   SCA   │───►│  TEST   │───►│  BUILD  │          │
│   │Checkstyle│    │ CodeQL  │    │  OWASP  │    │  JUnit  │    │  Maven  │          │
│   └─────────┘    └─────────┘    └─────────┘    └─────────┘    └─────────┘          │
│        │              │              │              │              │                 │
│        ▼              ▼              ▼              ▼              ▼                 │
│      [30s]         [2min]         [3min]         [1min]         [1min]              │
│                                                                                      │
│                                         │                                            │
│                                         ▼                                            │
│                              ┌─────────────────────┐                                │
│                              │    DOCKER BUILD     │                                │
│                              │   Multi-stage       │                                │
│                              └──────────┬──────────┘                                │
│                                         │                                            │
│                                         ▼                                            │
│   ┌─────────┐    ┌─────────────────┐    ┌─────────────────┐                         │
│   │  PUSH   │◄───│ CONTAINER TEST  │◄───│   TRIVY SCAN    │                         │
│   │DockerHub│    │  Runtime Check  │    │ Vulnerability   │                         │
│   └─────────┘    └─────────────────┘    └─────────────────┘                         │
│        │                                                                             │
│        ▼                                                                             │
│   🎉 DEPLOYED                                                                        │
│                                                                                      │
└─────────────────────────────────────────────────────────────────────────────────────┘
```

</div>

---

## 🛡️ Security Coverage

<div align="center">
```
╔═══════════════════════════════════════════════════════════════════════════╗
║                        🔒 SHIFT-LEFT SECURITY                              ║
╠═══════════════════════════════════════════════════════════════════════════╣
║                                                                            ║
║  ┌──────────────────┐  ┌──────────────────┐  ┌──────────────────┐        ║
║  │   🔍 SAST        │  │   📦 SCA         │  │   🐳 TRIVY       │        ║
║  │   CodeQL         │  │   OWASP          │  │   Scanner        │        ║
║  ├──────────────────┤  ├──────────────────┤  ├──────────────────┤        ║
║  │                  │  │                  │  │                  │        ║
║  │  YOUR CODE       │  │  DEPENDENCIES    │  │  CONTAINER       │        ║
║  │                  │  │                  │  │                  │        ║
║  │ • SQL Injection  │  │ • Log4j CVEs     │  │ • OS packages    │        ║
║  │ • XSS            │  │ • Jackson vulns  │  │ • JRE CVEs       │        ║
║  │ • Hardcoded      │  │ • Spring vulns   │  │ • Config issues  │        ║
║  │   secrets        │  │                  │  │                  │        ║
║  │                  │  │                  │  │                  │        ║
║  └──────────────────┘  └──────────────────┘  └──────────────────┘        ║
║           │                    │                      │                   ║
║           └────────────────────┼──────────────────────┘                   ║
║                                │                                          ║
║                                ▼                                          ║
║                    ┌─────────────────────┐                               ║
║                    │  ✅ SECURE RELEASE  │                               ║
║                    └─────────────────────┘                               ║
║                                                                            ║
╚═══════════════════════════════════════════════════════════════════════════╝
```

</div>

---

## 🏗️ Architecture

<details>
<summary><b>📱 Click to expand Application Architecture</b></summary>

<br/>
```
┌─────────────────────────────────────────────────────────────────────────────┐
│                                                                              │
│                          ORDER MANAGEMENT SYSTEM                             │
│                                                                              │
│  ┌───────────────────────────────────────────────────────────────────────┐  │
│  │                         🌐 API LAYER                                   │  │
│  │  ┌─────────────────────────────────────────────────────────────────┐  │  │
│  │  │                     OrderController                              │  │  │
│  │  │  POST /orders  │  GET /orders  │  PUT /status  │  DELETE        │  │  │
│  │  └─────────────────────────────────────────────────────────────────┘  │  │
│  └───────────────────────────────────────────────────────────────────────┘  │
│                                      │                                       │
│                                      ▼                                       │
│  ┌───────────────────────────────────────────────────────────────────────┐  │
│  │                         ⚙️ SERVICE LAYER                               │  │
│  │  ┌─────────────────┐  ┌─────────────────┐  ┌─────────────────┐       │  │
│  │  │  OrderService   │  │ StateMachine    │  │  OrderMapper    │       │  │
│  │  │                 │  │                 │  │  (MapStruct)    │       │  │
│  │  │ • Create Order  │  │ • Validate      │  │                 │       │  │
│  │  │ • Update Status │  │   Transitions   │  │ • Entity ↔ DTO  │       │  │
│  │  │ • Cancel Order  │  │ • State Rules   │  │                 │       │  │
│  │  └─────────────────┘  └─────────────────┘  └─────────────────┘       │  │
│  └───────────────────────────────────────────────────────────────────────┘  │
│                                      │                                       │
│                                      ▼                                       │
│  ┌───────────────────────────────────────────────────────────────────────┐  │
│  │                         💾 DATA LAYER                                  │  │
│  │  ┌─────────────────────────────────────────────────────────────────┐  │  │
│  │  │                    OrderRepository                               │  │  │
│  │  │         JPA │ Hibernate │ Spring Data                           │  │  │
│  │  └─────────────────────────────────────────────────────────────────┘  │  │
│  │                                  │                                     │  │
│  │                                  ▼                                     │  │
│  │  ┌─────────────────────────────────────────────────────────────────┐  │  │
│  │  │              🗄️ H2 (Dev) / PostgreSQL (Prod)                    │  │  │
│  │  └─────────────────────────────────────────────────────────────────┘  │  │
│  └───────────────────────────────────────────────────────────────────────┘  │
│                                                                              │
└─────────────────────────────────────────────────────────────────────────────┘
```

</details>

<details>
<summary><b>☸️ Click to expand Kubernetes Architecture</b></summary>

<br/>
```
┌─────────────────────────────────────────────────────────────────────────────┐
│                           ☸️ KUBERNETES CLUSTER                              │
├─────────────────────────────────────────────────────────────────────────────┤
│                                                                              │
│   ┌─────────────────────────────────────────────────────────────────────┐   │
│   │                    📦 Namespace: order-management                    │   │
│   ├─────────────────────────────────────────────────────────────────────┤   │
│   │                                                                      │   │
│   │  ┌─────────────┐  ┌─────────────┐  ┌─────────────────────────────┐ │   │
│   │  │   🐳 Pod 1  │  │   🐳 Pod 2  │  │      📋 ConfigMap          │ │   │
│   │  │ ┌─────────┐ │  │ ┌─────────┐ │  │                             │ │   │
│   │  │ │   App   │ │  │ │   App   │ │  │  SPRING_PROFILES_ACTIVE=k8s│ │   │
│   │  │ │ :8080   │ │  │ │ :8080   │ │  │                             │ │   │
│   │  │ └─────────┘ │  │ └─────────┘ │  └─────────────────────────────┘ │   │
│   │  │             │  │             │                                   │   │
│   │  │ 💚 healthy  │  │ 💚 healthy  │                                   │   │
│   │  └──────┬──────┘  └──────┬──────┘                                   │   │
│   │         │                │                                          │   │
│   │         └────────┬───────┘                                          │   │
│   │                  │                                                  │   │
│   │         ┌────────┴────────┐                                         │   │
│   │         │    🔀 Service   │                                         │   │
│   │         │   (NodePort)    │                                         │   │
│   │         │   Port: 30080   │                                         │   │
│   │         └────────┬────────┘                                         │   │
│   │                  │                                                  │   │
│   └──────────────────┼──────────────────────────────────────────────────┘   │
│                      │                                                       │
└──────────────────────┼───────────────────────────────────────────────────────┘
                       │
                       ▼
                 🌐 Internet
              localhost:8080
```

</details>

<details>
<summary><b>🔄 Click to expand Order State Machine</b></summary>

<br/>
```
                              ORDER LIFECYCLE
    ═══════════════════════════════════════════════════════════

                            ┌───────────┐
                            │  📝 NEW   │
                            │   ORDER   │
                            └─────┬─────┘
                                  │
                                  ▼
    ┌─────────────────────────────────────────────────────────────┐
    │                                                              │
    │         ┌─────────────┐                                     │
    │         │   PENDING   │ ◄─── Order Created                  │
    │         │     ⏳      │                                     │
    │         └──────┬──────┘                                     │
    │                │                                            │
    │       ┌────────┴────────┐                                   │
    │       │                 │                                   │
    │       ▼                 ▼                                   │
    │ ┌───────────┐    ┌───────────┐                             │
    │ │ CONFIRMED │    │ CANCELLED │ ◄─── Customer cancelled     │
    │ │     ✓     │    │     ✗     │                             │
    │ └─────┬─────┘    └───────────┘                             │
    │       │                                                     │
    │       ▼                                                     │
    │ ┌───────────┐                                               │
    │ │PROCESSING │ ◄─── Warehouse preparing                     │
    │ │    ⚙️     │                                               │
    │ └─────┬─────┘                                               │
    │       │                                                     │
    │       ▼                                                     │
    │ ┌───────────┐                                               │
    │ │  SHIPPED  │ ◄─── Package dispatched                      │
    │ │    🚚     │                                               │
    │ └─────┬─────┘                                               │
    │       │                                                     │
    │       ▼                                                     │
    │ ┌───────────┐                                               │
    │ │ DELIVERED │ ◄─── Customer received                       │
    │ │    📦✓    │                                               │
    │ └───────────┘                                               │
    │                                                              │
    └─────────────────────────────────────────────────────────────┘
```

</details>

---

## 🚀 Quick Start

<div align="center">

### Choose Your Deployment Method

</div>

<table>
<tr>
<td align="center" width="33%">

### 💻 Local Dev
```bash
mvn spring-boot:run
```

Best for: Development

</td>
<td align="center" width="33%">

### 🐳 Docker
```bash
docker run -p 8080:8080 \
  indrajeetyadav89/order-management-system
```

Best for: Testing

</td>
<td align="center" width="33%">

### ☸️ Kubernetes
```bash
./deploy.sh
```

Best for: Production

</td>
</tr>
</table>

<details>
<summary><b>📋 Step-by-Step Instructions</b></summary>

### Prerequisites

| Tool | Version | Check Command |
|------|---------|---------------|
| ☕ Java | 17+ | `java -version` |
| 📦 Maven | 3.9+ | `mvn -version` |
| 🐳 Docker | 24+ | `docker --version` |
| ☸️ Kind | 0.20+ | `kind --version` |
| 🎮 kubectl | 1.28+ | `kubectl version` |

### Option 1: Run Locally
```bash
# Clone the repository
git clone https://github.com/indrajeetyadav89/order-management-system.git

# Navigate to project
cd order-management-system

# Run with Maven
mvn spring-boot:run -Dspring-boot.run.profiles=dev

# 🎉 Access at http://localhost:8080
```

### Option 2: Run with Docker
```bash
# Pull the image
docker pull indrajeetyadav89/order-management-system:latest

# Run container
docker run -p 8080:8080 indrajeetyadav89/order-management-system:latest

# 🎉 Access at http://localhost:8080
```

### Option 3: Deploy to Kubernetes
```bash
# Make script executable
chmod +x deploy.sh

# Deploy everything
./deploy.sh

# 🎉 Access at http://localhost:8080

# Cleanup when done
./cleanup.sh
```

</details>

---

## 📖 API Documentation

<div align="center">

### 🔗 Swagger UI: `http://localhost:8080/swagger-ui.html`

</div>

### Endpoints

| Method | Endpoint | Description | Request Body |
|:------:|----------|-------------|:------------:|
| 🟢 `POST` | `/api/v1/orders` | Create order | ✅ |
| 🔵 `GET` | `/api/v1/orders` | List all orders | ❌ |
| 🔵 `GET` | `/api/v1/orders/{id}` | Get by ID | ❌ |
| 🟡 `PUT` | `/api/v1/orders/{id}/status` | Update status | ✅ |
| 🟡 `PUT` | `/api/v1/orders/{id}/cancel` | Cancel order | ❌ |
| 🔴 `DELETE` | `/api/v1/orders/{id}` | Delete order | ❌ |
| 🟢 `GET` | `/api/v1/orders/health` | Health check | ❌ |

<details>
<summary><b>📝 Example: Create Order</b></summary>

**Request:**
```bash
curl -X POST http://localhost:8080/api/v1/orders \
  -H "Content-Type: application/json" \
  -d '{
    "customerName": "John Doe",
    "customerEmail": "john@example.com",
    "productId": "PROD-001",
    "productName": "MacBook Pro 16",
    "quantity": 1,
    "unitPrice": 2499.99,
    "shippingAddress": "123 Tech Street, San Francisco, CA"
  }'
```

**Response:**
```json
{
  "id": 1,
  "orderNumber": "ORD-A1B2C3D4",
  "customerName": "John Doe",
  "customerEmail": "john@example.com",
  "productName": "MacBook Pro 16",
  "quantity": 1,
  "totalAmount": 2499.99,
  "status": "PENDING",
  "statusDisplayName": "Pending",
  "createdAt": "2026-01-18T10:30:00"
}
```

</details>

<details>
<summary><b>🔄 Example: Update Status</b></summary>

**Request:**
```bash
curl -X PUT http://localhost:8080/api/v1/orders/1/status \
  -H "Content-Type: application/json" \
  -d '{
    "status": "CONFIRMED",
    "notes": "Payment verified"
  }'
```

</details>

<details>
<summary><b>💚 Example: Health Check</b></summary>

**Request:**
```bash
curl http://localhost:8080/api/v1/orders/health
```

**Response:**
```json
{
  "status": "UP",
  "service": "order-management-system",
  "timestamp": "2026-01-18T10:30:00",
  "version": "1.0.0"
}
```

</details>

---

## 📂 Project Structure
```
📦 order-management-system
┣━━ 📂 .github/workflows
┃   ┗━━ 📄 ci.yml                    # 🔄 CI/CD Pipeline
┣━━ 📂 src
┃   ┣━━ 📂 main
┃   ┃   ┣━━ 📂 java/.../order
┃   ┃   ┃   ┣━━ 📂 config            # ⚙️ Configuration
┃   ┃   ┃   ┣━━ 📂 controller        # 🌐 REST Controllers
┃   ┃   ┃   ┣━━ 📂 dto               # 📋 Data Transfer Objects
┃   ┃   ┃   ┣━━ 📂 exception         # ⚠️ Exception Handling
┃   ┃   ┃   ┣━━ 📂 mapper            # 🔄 MapStruct Mappers
┃   ┃   ┃   ┣━━ 📂 model             # 📊 JPA Entities
┃   ┃   ┃   ┣━━ 📂 repository        # 💾 Data Access
┃   ┃   ┃   ┗━━ 📂 service           # ⚙️ Business Logic
┃   ┃   ┗━━ 📂 resources
┃   ┃       ┣━━ 📄 application.yml           # Base config
┃   ┃       ┣━━ 📄 application-dev.yml       # Dev profile
┃   ┃       ┣━━ 📄 application-prod.yml      # Prod profile
┃   ┃       ┗━━ 📄 application-kubernetes.yml # K8s profile
┃   ┗━━ 📂 test                      # 🧪 Unit & Integration Tests
┣━━ 📂 k8s
┃   ┣━━ 📄 deployment.yaml           # ☸️ Deployment manifest
┃   ┣━━ 📄 service.yaml              # 🔀 Service manifest
┃   ┗━━ 📄 complete-deployment.yaml  # 📦 All-in-one manifest
┣━━ 📂 docs
┃   ┣━━ 📄 PROJECT_REPORT.md         # 📝 Project Report
┃   ┗━━ 📄 VIVA_GUIDE.md             # 🎤 VIVA Preparation
┣━━ 📄 Dockerfile                    # 🐳 Multi-stage build
┣━━ 📄 pom.xml                       # 📦 Maven config
┣━━ 📄 deploy.sh                     # 🚀 Deploy script
┣━━ 📄 cleanup.sh                    # 🧹 Cleanup script
┗━━ 📄 README.md                     # 📖 This file
```

---

## 🔧 Configuration

<details>
<summary><b>🔐 GitHub Secrets Setup</b></summary>

Navigate to: `Repository → Settings → Secrets → Actions`

| Secret | Description | How to Get |
|--------|-------------|------------|
| `DOCKERHUB_USERNAME` | Your DockerHub username | Your DockerHub account |
| `DOCKERHUB_TOKEN` | DockerHub access token | DockerHub → Account Settings → Security → New Access Token |

**Token Permissions Required:** Read, Write, Delete

</details>

<details>
<summary><b>⚙️ Environment Variables</b></summary>

| Variable | Description | Default |
|----------|-------------|---------|
| `SPRING_PROFILES_ACTIVE` | Active Spring profile | `dev` |
| `DATABASE_URL` | Database connection URL | H2 in-memory |
| `DATABASE_USERNAME` | Database username | `sa` |
| `DATABASE_PASSWORD` | Database password | (empty) |

</details>

---

## 🎓 Learning Outcomes

<div align="center">

| Skill | What You Learn |
|:-----:|----------------|
| 🔄 | **CI/CD** - Automated pipeline with GitHub Actions |
| 🛡️ | **Security** - SAST, SCA, Container scanning |
| 🐳 | **Containerization** - Multi-stage Docker builds |
| ☸️ | **Orchestration** - Kubernetes deployment |
| 🧪 | **Testing** - Unit & Integration tests |
| 📝 | **Documentation** - API docs with Swagger |

</div>

---

## 👨‍💻 Author

<div align="center">

**Indrajeet Yadav**

[![GitHub](https://img.shields.io/badge/GitHub-100000?style=for-the-badge&logo=github&logoColor=white)](https://github.com/indrajeetyadav89)

</div>

---

<div align="center">

### ⭐ Star this repository if you found it helpful!

<br/>
```
   _____ _____    _____ _____    _____           _           _   
  / ____|_   _|  / ____|  __ \  |  __ \         (_)         | |  
 | |      | |   / /    | |  | | | |__) | __ ___  _  ___  ___| |_ 
 | |      | |  | |     | |  | | |  ___/ '__/ _ \| |/ _ \/ __| __|
 | |____ _| |_ | |____ | |__| | | |   | | | (_) | |  __/ (__| |_ 
  \_____|_____| \_____||_____/  |_|   |_|  \___/| |\___|\___|\__|
                                               _/ |              
                                              |__/               
```

**Made with ❤️ for DevOps CI/CD Project**

*© 2026 Indrajeet Yadav*

</div>

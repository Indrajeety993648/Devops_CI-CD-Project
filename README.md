<div align="center">

<!-- Animated Typing Header -->
<a href="https://git.io/typing-svg"><img src="https://readme-typing-svg.demolab.com?font=Fira+Code&weight=700&size=30&pause=1000&color=00D9FF&center=true&vCenter=true&width=600&lines=Order+Management+System;CI%2FCD+Pipeline+Project;Kubernetes+Deployed;Production+Ready" alt="Typing SVG" /></a>

<br/><br/>

<!-- Tech Badges -->
<img src="https://img.shields.io/badge/Java-17-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white"/>
<img src="https://img.shields.io/badge/Spring_Boot-3.2-6DB33F?style=for-the-badge&logo=springboot&logoColor=white"/>
<img src="https://img.shields.io/badge/Docker-2496ED?style=for-the-badge&logo=docker&logoColor=white"/>
<img src="https://img.shields.io/badge/Kubernetes-326CE5?style=for-the-badge&logo=kubernetes&logoColor=white"/>
<img src="https://img.shields.io/badge/GitHub_Actions-2088FF?style=for-the-badge&logo=github-actions&logoColor=white"/>

<br/><br/>

<!-- Animated Line -->
<img src="https://user-images.githubusercontent.com/73097560/115834477-dbab4500-a447-11eb-908a-139a6edaec5c.gif">

</div>

## 🎯 About

A **production-ready** e-commerce microservice with complete **CI/CD pipeline**, **security scanning**, and **Kubernetes deployment**.

<div align="center">
<img src="https://user-images.githubusercontent.com/73097560/115834477-dbab4500-a447-11eb-908a-139a6edaec5c.gif">
</div>

## 🔄 CI/CD Pipeline

<div align="center">
```mermaid
graph LR
    A[📝 Code Push] --> B[🔍 Lint]
    B --> C[🛡️ SAST]
    C --> D[📦 SCA]
    D --> E[🧪 Test]
    E --> F[🔨 Build]
    F --> G[🐳 Docker]
    G --> H[🔎 Trivy]
    H --> I[🚀 Push]
    
    style A fill:#e1f5fe
    style I fill:#c8e6c9
```

</div>

| Stage | Tool | Purpose |
|:-----:|:----:|---------|
| 🔍 | Checkstyle | Code Quality |
| 🛡️ | CodeQL | Security Scan (SAST) |
| 📦 | OWASP | Dependency Scan (SCA) |
| 🧪 | JUnit | Unit Tests |
| 🐳 | Docker | Container Build |
| 🔎 | Trivy | Container Scan |
| 🚀 | DockerHub | Image Push |

<div align="center">
<img src="https://user-images.githubusercontent.com/73097560/115834477-dbab4500-a447-11eb-908a-139a6edaec5c.gif">
</div>

## 🚀 Quick Start
```bash
# Clone
git clone https://github.com/indrajeetyadav89/order-management-system.git

# Deploy to Kubernetes
./deploy.sh

# Access
curl http://localhost:8080/api/v1/orders/health
```

<div align="center">
<img src="https://user-images.githubusercontent.com/73097560/115834477-dbab4500-a447-11eb-908a-139a6edaec5c.gif">
</div>

## 📖 API Endpoints

| Method | Endpoint | Description |
|:------:|----------|-------------|
| `POST` | `/api/v1/orders` | Create order |
| `GET` | `/api/v1/orders` | Get all orders |
| `GET` | `/api/v1/orders/{id}` | Get order by ID |
| `PUT` | `/api/v1/orders/{id}/status` | Update status |
| `PUT` | `/api/v1/orders/{id}/cancel` | Cancel order |
| `DELETE` | `/api/v1/orders/{id}` | Delete order |
| `GET` | `/api/v1/orders/health` | Health check |

📚 **Swagger UI:** `http://localhost:8080/swagger-ui.html`

<div align="center">
<img src="https://user-images.githubusercontent.com/73097560/115834477-dbab4500-a447-11eb-908a-139a6edaec5c.gif">
</div>

## 🏗️ Architecture
```
┌─────────────────────────────────────────┐
│           🌐 API Layer                  │
│         (OrderController)               │
└──────────────────┬──────────────────────┘
                   │
┌──────────────────▼──────────────────────┐
│           ⚙️ Service Layer              │
│    (OrderService + StateMachine)        │
└──────────────────┬──────────────────────┘
                   │
┌──────────────────▼──────────────────────┐
│           💾 Data Layer                 │
│         (OrderRepository)               │
└──────────────────┬──────────────────────┘
                   │
┌──────────────────▼──────────────────────┐
│           🗄️ Database                   │
│        (H2 / PostgreSQL)                │
└─────────────────────────────────────────┘
```

<div align="center">
<img src="https://user-images.githubusercontent.com/73097560/115834477-dbab4500-a447-11eb-908a-139a6edaec5c.gif">
</div>

## 🛡️ Security

| Layer | Tool | Scans |
|:-----:|:----:|-------|
| 🔍 SAST | CodeQL | Your Code |
| 📦 SCA | OWASP | Dependencies |
| 🐳 Trivy | Scanner | Container |

<div align="center">
<img src="https://user-images.githubusercontent.com/73097560/115834477-dbab4500-a447-11eb-908a-139a6edaec5c.gif">
</div>

## 📂 Structure
```
📦 order-management-system
├── 📂 .github/workflows/ci.yml    # CI/CD Pipeline
├── 📂 src/main/java               # Application Code
├── 📂 src/test/java               # Tests
├── 📂 k8s/                        # Kubernetes Manifests
├── 📄 Dockerfile                  # Container Build
├── 📄 deploy.sh                   # Deploy Script
└── 📄 cleanup.sh                  # Cleanup Script
```

<div align="center">
<img src="https://user-images.githubusercontent.com/73097560/115834477-dbab4500-a447-11eb-908a-139a6edaec5c.gif">
</div>

## ⚡ Commands
```bash
# Deploy
./deploy.sh

# View Pods
kubectl get pods -n order-management

# View Logs
kubectl logs -f deployment/order-management-system -n order-management

# Cleanup
./cleanup.sh
```

<div align="center">
<img src="https://user-images.githubusercontent.com/73097560/115834477-dbab4500-a447-11eb-908a-139a6edaec5c.gif">
</div>

## 👨‍💻 Author

<div align="center">

**Indrajeet Yadav**

[![GitHub](https://img.shields.io/badge/GitHub-100000?style=for-the-badge&logo=github&logoColor=white)](https://github.com/indrajeetyadav89)

<br/>

⭐ **Star this repo if you found it helpful!**

<img src="https://capsule-render.vercel.app/api?type=waving&color=gradient&height=100&section=footer"/>

</div>

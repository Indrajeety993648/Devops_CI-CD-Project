<div align="center">

<img src="https://capsule-render.vercel.app/api?type=venom&height=200&color=gradient&customColorList=0,2,2,5,30&text=Order%20Management%20System&fontSize=40&fontColor=fff&animation=twinkling"/>

<p>
  <img src="https://img.shields.io/badge/Java-17-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white"/>
  <img src="https://img.shields.io/badge/Spring_Boot-3.2-6DB33F?style=for-the-badge&logo=springboot&logoColor=white"/>
  <img src="https://img.shields.io/badge/Docker-2496ED?style=for-the-badge&logo=docker&logoColor=white"/>
  <img src="https://img.shields.io/badge/Kubernetes-326CE5?style=for-the-badge&logo=kubernetes&logoColor=white"/>
  <img src="https://img.shields.io/badge/GitHub_Actions-2088FF?style=for-the-badge&logo=githubactions&logoColor=white"/>
</p>

<p>
  <img src="https://img.shields.io/badge/Build-Passing-brightgreen?style=flat-square"/>
  <img src="https://img.shields.io/badge/Security-Scanned-blue?style=flat-square"/>
  <img src="https://img.shields.io/badge/Coverage-80%25-yellow?style=flat-square"/>
</p>

**🚀 Production-Grade Microservice with Complete CI/CD Pipeline**

</div>

---

## 🎯 About

A **production-ready** Order Management System with:

- ✅ Complete **CI/CD Pipeline** (9 stages)
- ✅ **Security Scanning** (SAST + SCA + Container)
- ✅ **Docker** containerization
- ✅ **Kubernetes** deployment
- ✅ **REST API** with Swagger docs

---

## 🔄 CI/CD Pipeline

| Stage | Tool | Purpose | Time |
|:-----:|:-----|:--------|:----:|
| 1️⃣ | **Checkstyle** | Code quality & formatting | 30s |
| 2️⃣ | **CodeQL** | Security scan (SAST) | 2m |
| 3️⃣ | **OWASP** | Dependency scan (SCA) | 3m |
| 4️⃣ | **JUnit** | Unit tests | 1m |
| 5️⃣ | **Maven** | Build JAR | 1m |
| 6️⃣ | **Docker** | Build image | 2m |
| 7️⃣ | **Trivy** | Container scan | 1m |
| 8️⃣ | **Docker** | Push to DockerHub | 30s |

**Flow:** `Push → Lint → SAST → SCA → Test → Build → Docker → Scan → Deploy`

---

## 🏗️ Architecture

| Layer | Component | Technology |
|:-----:|:----------|:-----------|
| 🌐 | **API** | REST Controller |
| ⚙️ | **Service** | Business Logic |
| 💾 | **Repository** | JPA/Hibernate |
| 🗄️ | **Database** | H2 / PostgreSQL |

**Kubernetes Setup:**
- 2 Pod replicas for high availability
- Service with LoadBalancer
- ConfigMap for environment variables
- Health probes (liveness + readiness)

---

## 🔄 Order Lifecycle

| Status | Next States | Description |
|:------:|:------------|:------------|
| 📝 **PENDING** | CONFIRMED, CANCELLED | New order created |
| ✅ **CONFIRMED** | PROCESSING, CANCELLED | Payment verified |
| ⚙️ **PROCESSING** | SHIPPED | Being prepared |
| 🚚 **SHIPPED** | DELIVERED | In transit |
| 📦 **DELIVERED** | - | Completed |
| ❌ **CANCELLED** | - | Cancelled |

---

## 🚀 Quick Start

**Deploy to Kubernetes:**
```bash
git clone https://github.com/indrajeetyadav89/order-management-system.git
cd order-management-system
./deploy.sh
```

**Test the API:**
```bash
curl http://localhost:8080/api/v1/orders/health
```

**Cleanup:**
```bash
./cleanup.sh
```

---

## 📖 API Endpoints

| Method | Endpoint | Description |
|:------:|:---------|:------------|
| 🟢 **POST** | `/api/v1/orders` | Create order |
| 🔵 **GET** | `/api/v1/orders` | Get all orders |
| 🔵 **GET** | `/api/v1/orders/{id}` | Get by ID |
| 🟡 **PUT** | `/api/v1/orders/{id}/status` | Update status |
| 🔴 **DELETE** | `/api/v1/orders/{id}` | Delete order |
| 💚 **GET** | `/api/v1/orders/health` | Health check |

**Swagger UI:** http://localhost:8080/swagger-ui.html

---

## 🛡️ Security

| Type | Tool | What it Scans |
|:----:|:-----|:--------------|
| 🔍 **SAST** | CodeQL | Your source code |
| 📦 **SCA** | OWASP | Dependencies |
| 🐳 **Container** | Trivy | Docker image |

---

## 📂 Project Structure
```
order-management-system/
├── .github/workflows/ci.yml    # CI/CD Pipeline
├── src/main/java/              # Application code
├── src/test/java/              # Unit tests
├── k8s/                        # Kubernetes manifests
├── Dockerfile                  # Container build
├── deploy.sh                   # Deploy script
└── cleanup.sh                  # Cleanup script
```

---

## 🛠️ Tech Stack

<div align="center">

| Backend | DevOps | Database |
|:-------:|:------:|:--------:|
| Java 17 | Docker | H2 |
| Spring Boot 3.2 | Kubernetes | PostgreSQL |
| Maven | GitHub Actions | |

</div>

---

## ⚡ Commands Reference

| Command | Description |
|:--------|:------------|
| `./deploy.sh` | Deploy to Kubernetes |
| `./cleanup.sh` | Remove deployment |
| `kubectl get pods -n order-management` | View pods |
| `kubectl logs -f deploy/order-management-system -n order-management` | View logs |

---

<div align="center">

## 👨‍💻 Author

**Indrajeet Yadav**

[![GitHub](https://img.shields.io/badge/GitHub-181717?style=for-the-badge&logo=github)](https://github.com/indrajeetyadav89)

---

<img src="https://capsule-render.vercel.app/api?type=waving&color=gradient&customColorList=0,2,2,5,30&height=100&section=footer"/>

⭐ **Star this repo if it helped!**

</div>

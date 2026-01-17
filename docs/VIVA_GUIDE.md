# VIVA Preparation Guide

## Key Questions & Answers

### Q: Why did you choose this project?
"E-commerce order systems handle sensitive customer data. A security breach could lead to financial losses and regulatory penalties. My CI/CD pipeline ensures every code change is tested for security vulnerabilities before reaching production."

### Q: Explain your CI/CD pipeline stages

| Stage | Tool | Purpose |
|-------|------|---------|
| Lint | Checkstyle | Code quality |
| SAST | CodeQL | Security vulnerabilities |
| SCA | OWASP | Dependency vulnerabilities |
| Test | JUnit | Business logic validation |
| Build | Maven | Package application |
| Docker | Docker | Container image |
| Scan | Trivy | Container vulnerabilities |
| Test | curl | Runtime validation |
| Push | DockerHub | Publish image |

### Q: What is shift-left security?
"Moving security testing earlier in the pipeline. Instead of security audits at the end, we run CodeQL and OWASP scans before building. This catches vulnerabilities when they're cheaper to fix."

### Q: Why use multi-stage Docker build?
"Creates smaller, more secure images. Stage 1 has Maven and build tools (~500MB). Stage 2 only has JRE and JAR (~150MB). No build tools in production = smaller attack surface."

### Q: Explain liveness vs readiness probes

| Probe | Purpose | On Failure |
|-------|---------|------------|
| Liveness | Is container alive? | Restart container |
| Readiness | Ready for traffic? | Remove from service |

### Q: Why MapStruct?
"Eliminates manual object mapping boilerplate. Compile-time code generation means type-safe mappings with no runtime reflection overhead."

### Q: Why OrderStateMachine?
"Externalizes state transition logic. Easy to modify, test, and extend without changing core business logic. Single source of truth for valid transitions."

## Demo Checklist

- [ ] Show GitHub repository
- [ ] Show successful CI pipeline run
- [ ] Show security scan results
- [ ] Deploy to Minikube
- [ ] Test API endpoints
- [ ] Show Swagger UI

## 2024-05-22 - Spring Boot Property Secrets
**Vulnerability:** Hardcoded DB credentials and JWT secrets in `application.properties`.
**Learning:** Legacy Spring Boot apps often rely on profile-specific properties files that contain secrets.
**Prevention:** Use `${ENV_VAR}` placeholders to force environment configuration and prevent accidental secret commits.

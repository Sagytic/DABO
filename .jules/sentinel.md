## 2026-01-28 - Hardcoded Secrets in Configuration
**Vulnerability:** Found hardcoded database credentials, JWT secret, and Ethereum wallet password in `application.properties`.
**Learning:** Hardcoding secrets in configuration files that are committed to version control exposes them to anyone with repository access.
**Prevention:** Use environment variables (e.g., `${ENV_VAR}`) in configuration files and provide the actual values at runtime (e.g., via OS env vars, Docker secrets, or k8s secrets).

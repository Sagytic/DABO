## 2025-02-12 - Hardcoded Secrets in Spring Boot Properties
**Vulnerability:** Critical credentials (DB, JWT, Wallet, Mail) were hardcoded in `application.properties`, `application-local.properties`, and `mailConfirm.properties` in the `backend/src/main/resources` directory.
**Learning:** The project relied on committing secrets to the repo for configuration, which is a major security risk. Spring Boot allows easy property injection via environment variables, which was not utilized.
**Prevention:** Use `${ENV_VAR}` placeholders in `application.properties` and enforce strict pre-commit checks to prevent secrets from entering the codebase. Document required environment variables in `.env.example`.

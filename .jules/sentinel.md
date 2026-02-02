## 2026-02-02 - Hardcoded Secrets in Configuration Files
**Vulnerability:** Found hardcoded database credentials, JWT secrets, and Ethereum wallet passwords in `backend/src/main/resources/application.properties`, `application-local.properties`, and `mailConfirm.properties`.
**Learning:** Hardcoding secrets in source control exposes them to anyone with access to the repository, leading to potential data breaches and unauthorized access.
**Prevention:** Use environment variables for all sensitive configuration. Document required variables in a `.env.example` file.

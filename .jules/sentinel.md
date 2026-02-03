# Sentinel's Journal

## 2025-10-22 - Hardcoded Secrets in Configuration
**Vulnerability:** Found hardcoded database credentials, JWT secrets, and Ethereum wallet passwords in `application.properties`, `application-local.properties`, and `mailConfirm.properties`.
**Learning:** These were likely added for development convenience but pose a critical risk if the repository is public or shared.
**Prevention:** Always use environment variables for sensitive configuration. Use placeholders like `${DB_PASSWORD}` in properties files and document required variables in a `.env.example` file.

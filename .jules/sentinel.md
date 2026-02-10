## 2026-02-10 - Hardcoded Secrets in Spring Boot Properties
**Vulnerability:** Hardcoded database credentials, JWT secret, and Ethereum wallet password in `application.properties`, `application-local.properties`, and `mailConfirm.properties`.
**Learning:** Spring Boot property files are often overlooked during security reviews. The `@Value` annotation injects values from these files, but hardcoding them exposes secrets in version control.
**Prevention:** Always use environment variable placeholders (e.g., `${DB_PASSWORD}`) in properties files. Add `.env` to `.gitignore`. Use a `.env.example` file to document required variables.

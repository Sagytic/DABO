## 2024-05-22 - Hardcoded Secrets in Configuration Files
**Vulnerability:** Found hardcoded database credentials, JWT secret, Ethereum wallet password, and email credentials in `application.properties`, `application-local.properties`, and `mailConfirm.properties`.
**Learning:** Configuration files were likely committed for convenience without considering the security implications of exposing sensitive credentials in the codebase.
**Prevention:** Always use environment variables for sensitive configuration. Use `.env.example` to document required variables without committing actual secrets. Review configuration files before committing.

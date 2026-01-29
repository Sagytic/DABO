## 2026-01-29 - Hardcoded Secrets in Resource Files
**Vulnerability:** Multiple configuration files (`application.properties`, `application-local.properties`, `mailConfirm.properties`) contained hardcoded credentials for database, JWT, Ethereum wallet, and SMTP.
**Learning:** Developers were committing secrets directly to SCM for convenience across different environments (local vs prod). Secrets were also found in less obvious files like `mailConfirm.properties`.
**Prevention:** Enforce environment variable usage for all credentials. Scan all files in `src/main/resources` for potential secrets, not just the main application.properties.

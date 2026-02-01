## 2024-05-22 - Hardcoded Secrets in Configuration
**Vulnerability:** Found hardcoded database credentials, JWT secrets, Ethereum wallet passwords, and mail credentials in `application.properties` and `mailConfirm.properties`. Also found a live Ethereum keystore file (`admin.wallet`) committed to the repo.
**Learning:** Developers often hardcode secrets for convenience in local dev and forget to externalize them. Committed keystore files are a major risk.
**Prevention:** Always use environment variables for secrets (e.g., `${DB_PASSWORD}`). Add sensitive file patterns to `.gitignore` immediately. Use sanitized `.example` files for required artifacts.

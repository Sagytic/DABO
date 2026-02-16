## 2026-02-16 - Hardcoded Secrets in Backend
**Vulnerability:** The backend application contained hardcoded database credentials, JWT secrets, Ethereum wallet passwords, and mail credentials directly in `application.properties`, `application-local.properties`, and `mailConfirm.properties`. Additionally, a sensitive keystore file `admin.wallet` was committed to the repository.
**Learning:** Spring Boot property files are often overlooked as sources of hardcoded secrets. Developers might commit `admin.wallet` or similar files for convenience during development, forgetting to add them to `.gitignore`.
**Prevention:**
1.  Use environment variables for all sensitive configuration in Spring Boot (`${VAR_NAME}`).
2.  Add sensitive file patterns (e.g., `*.wallet`, `*.key`, `*.p12`) to `.gitignore` immediately upon project creation.
3.  Use a template like `.env.example` to document required environment variables without exposing actual secrets.

# Sentinel Journal

## 2026-01-31 - Hardcoded Secrets in Backend Configuration
**Vulnerability:** Found multiple hardcoded secrets (database credentials, JWT secret, Ethereum wallet password, Mail credentials) in `backend/src/main/resources/application.properties`, `backend/src/main/resources/application-local.properties`, and `backend/src/main/resources/mailConfirm.properties`. Also found a live Ethereum wallet file `admin.wallet` in the resource directory.
**Learning:** Developers likely committed these for convenience during local development or because they were part of a "default" setup, unaware of the risk of exposing them in the repository. The use of `ClassPathResource` in the code strongly encourages keeping files in the classpath (src/main/resources), leading to this security anti-pattern.
**Prevention:**
1. Use environment variables for all sensitive configuration.
2. Add secret files (like wallets) to `.gitignore` immediately upon creation.
3. Use a template file (e.g., `.env.example`, `wallet.example`) to guide developers without committing actual secrets.
4. Implement a pre-commit hook or CI check to scan for high-entropy strings or known secret patterns.

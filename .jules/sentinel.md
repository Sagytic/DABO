## 2025-05-15 - Hardcoded Secrets & Wallet Exposure
**Vulnerability:** Found `admin.wallet` (Ethereum Keystore) committed to the repo, with its decryption password hardcoded in `application.properties`. Also found hardcoded DB, JWT, and Mail credentials.
**Learning:** The project relies on file-based wallet management (`eth.admin.wallet.filename=admin.wallet`). Developers likely committed it for convenience. Spring Boot property injection was used for `mailConfirm.properties` which had custom key formats.
**Prevention:**
1. `*.wallet` and `.env` added to `.gitignore`.
2. All secrets moved to environment variables (`ETH_PASSWORD`, `DB_PASSWORD`, `JWT_SECRET`, `MAIL_PASSWORD`).
3. `admin.wallet` left in history (to avoid breaking existing setups/references) but its password is now externalized, mitigating the risk if the env var is secure.

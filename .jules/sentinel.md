## 2026-02-04 - Hardcoded Secrets & Wallet Leak
**Vulnerability:** Hardcoded credentials in properties files and a committed Ethereum keystore file (admin.wallet).
**Learning:** Developers often commit local configuration files containing production secrets. The keystore file was not ignored.
**Prevention:** Use environment variables for all secrets. Enforce .gitignore for .env and *.wallet files. Use pre-commit hooks to scan for secrets.

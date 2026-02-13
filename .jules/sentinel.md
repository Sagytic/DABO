## 2026-02-13 - Hardcoded Ethereum Keystore & Password
**Vulnerability:** Found `src/main/resources/admin.wallet` (encrypted keystore) committed alongside its decryption password in `application.properties`.
**Learning:** Checking in encrypted secrets is useless if the key/password is also checked in (or easily guessable). Security requires separation of concerns.
**Prevention:** Always add keystore files to `.gitignore` immediately upon project creation. Use environment variables for all passwords.

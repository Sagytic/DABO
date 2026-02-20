## 2024-03-24 - Hardcoded Secrets & Wallet Exposure
**Vulnerability:** Hardcoded database credentials, JWT secrets, Ethereum wallet password, and admin email credentials in properties files. Additionally, an Ethereum wallet file (`admin.wallet`) containing an encrypted private key was committed to the repository.
**Learning:** `CommonUtil.java` uses `ClassPathResource` to load the wallet file, mandating that the file resides in the classpath (e.g., `src/main/resources/`) even if the path is configurable. This restricts where the file can be placed in production without code changes.
**Prevention:** Use environment variables for all sensitive configuration. Exclude sensitive files like `.env` and `*.wallet` from version control immediately upon project setup.

## 2026-02-11 - [Hardcoded Secrets in Backend Config]
**Vulnerability:** Hardcoded database password, JWT secret, and Ethereum wallet password in application.properties and application-local.properties.
**Learning:** These files are often checked into version control, exposing critical secrets. Even 'local' properties can contain real secrets if developers copy-paste or if the local environment mimics production.
**Prevention:** Use environment variables for all secrets. Provide a template (.env.example) and ensure sensitive files and .env are in .gitignore.

## 2024-10-24 - Discrepancy between Documentation and Code regarding Secrets
**Vulnerability:** Hardcoded secrets found in `application.properties` despite documentation claiming environment variable usage.
**Learning:** Documentation can drift from reality or describe a desired state rather than the current state. Direct file inspection is mandatory.
**Prevention:** Verify configuration files directly rather than relying on documentation or memory summaries.

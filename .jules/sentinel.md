## 2026-02-17 - Sensitive Data Exposure in Logs
**Vulnerability:** The application was logging full JWT tokens in `Interceptor.java` and sensitive user details (including potential password hashes) via `System.out.println` in `JwtAuthenticationFilter.java`.
**Learning:** Developers often use `System.out.println` or extensive logging for debugging during development and forget to remove it before production. Also, Lombok's `@Data` generates `toString()` including all fields by default, which is dangerous for entities with sensitive fields.
**Prevention:**
1. Enforce a "no `System.out.println`" rule in production code.
2. Use `@ToString.Exclude` on sensitive fields (passwords, tokens) in Lombok-annotated classes.
3. Configure logging levels properly and audit logs for sensitive data.

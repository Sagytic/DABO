## 2026-02-09 - Direct JPA Entity Exposure Leaks Passwords
**Vulnerability:** The `UserController` returns `DABOUser` entities directly in API responses. The `DABOUser` entity contained a `password` field (hashed) that was not annotated with `@JsonIgnore`, causing it to be leaked in all user-related endpoints (e.g., `GET /api/user`).
**Learning:** This codebase uses a pattern of returning full JPA entities instead of DTOs for read operations. This is dangerous as it requires explicit `@JsonIgnore` on every sensitive field added to the entity.
**Prevention:** Prefer returning specific DTOs (Data Transfer Objects) for API responses. If entities must be returned, strictly audit all fields and apply `@JsonIgnore` to sensitive data immediately upon creation.

## 2026-02-09 - Silent Auth Bypass via Typo
**Vulnerability:** `SecurityConfig` protected `/api/users/me` (plural) while the controller was mapped to `/api/user/me` (singular). This resulted in the endpoint falling through to `.anyRequest().permitAll()`, silently bypassing authentication.
**Learning:** Spring Security's `antMatchers` are string-based and do not validate against actual controller mappings. A simple typo can disable security without any error.
**Prevention:** Use constants for API paths or integration tests that specifically assert 401/403 on protected endpoints. Always verify security configuration against actual route mappings.

## 2026-02-21 - [Java 21 Incompatibility with Lombok 1.18.8]
**Learning:** The project uses Lombok 1.18.8 which fails on JDK 21 due to internal API access restrictions (`ExceptionInInitializerError`). Also QueryDSL 4.x annotation processing fails on JDK 21.
**Action:** To run tests locally on JDK 21, temporarily upgrade Lombok to 1.18.30+ and QueryDSL to 5.0.0+, and add `--add-opens` flags to `maven-compiler-plugin`. Do not commit these changes unless the project permanently migrates to JDK 21.

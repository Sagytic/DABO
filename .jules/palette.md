## 2025-02-18 - Heavy Reliance on Native Alerts
**Learning:** The application extensively uses native `alert()` for error messages and success confirmations (e.g., login, form validation). This interrupts the user flow and provides a poor experience, especially on mobile.
**Action:** Future enhancements should prioritize replacing `alert()` with a toast notification system or inline validation messages to improve usability and accessibility.

## 2025-02-18 - Deprecated node-sass
**Learning:** The project was configured with `node-sass`, which is deprecated and causes build failures in modern environments.
**Action:** Always verify `sass` (Dart Sass) is used instead of `node-sass` when working on styles.

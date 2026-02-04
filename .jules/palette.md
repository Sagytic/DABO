## 2024-05-22 - Blocking Alerts in Auth Flow
**Learning:** The legacy codebase uses native `alert()` for success states (e.g., 'Login Success'), which creates a jarring, blocking experience that interrupts redirection.
**Action:** Prioritize removing 'success' alerts that precede navigation. Use loading states on buttons to bridge the gap between action and redirection.

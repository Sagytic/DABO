## PALETTE'S JOURNAL - CRITICAL LEARNINGS ONLY

## 2025-02-19 - Login UX Improvement
**Learning:** The login page relied on intrusive `alert()`s for validation and lacked keyboard support (Enter to submit), which disrupts the user flow.
**Action:** Always wrap inputs in a `<form>` and use inline error messages instead of alerts for a smoother experience.

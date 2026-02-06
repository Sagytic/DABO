## 2025-02-06 - Alert-based Error Handling
**Learning:** The application relies heavily on `alert()` for validation and API errors, which disrupts the user flow and is inaccessible.
**Action:** Replace `alert()` with inline error messages or toast notifications for a smoother experience.

## 2025-02-06 - Missing Form Labels
**Learning:** Input fields often rely solely on placeholders, which is an accessibility violation.
**Action:** Always add `aria-label` or visible `<label>` elements to inputs.

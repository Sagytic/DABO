## 2024-05-22 - Login Form Accessibility
**Learning:** The login page relied on `alert()` for validation and lacked semantic form structure, which is inaccessible and poor UX. Native HTML5 validation (`required`) and `aria-label` provide immediate, accessible feedback without custom scripts.
**Action:** Always wrap inputs in a `<form>` tag and use native validation attributes where possible to enhance accessibility and reduce boilerplate code.

## 2025-02-19 - Semantic Forms & Native Validation
**Learning:** Legacy login forms lacking `<form>` tags and `<label>` elements break accessibility and keyboard navigation. Using `.visually-hidden` labels preserves design while ensuring screen reader support. Native HTML5 `required` attribute provides immediate, accessible feedback without custom JS alerts.
**Action:** Audit all form inputs for associated labels and semantic wrapping. Prefer native browser validation over custom alerts for required fields.

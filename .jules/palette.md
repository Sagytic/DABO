## 2024-05-23 - Login Form Accessibility
**Learning:** Found a pattern of missing semantic `<form>` tags and labels, relying on placeholders instead. This breaks accessibility and prevents native browser validation.
**Action:** Use `.visually-hidden` class for labels when visual design hides them. Use `required` attribute for inputs to leverage native browser validation instead of `alert()`. Ensure buttons inside forms have explicit `type="button"` unless they are the submit button.

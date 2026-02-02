## 2024-05-22 - Login Experience & Accessibility
**Learning:** Bootstrap 5 projects should use `.visually-hidden` for accessible labels (replacing `.sr-only` from BS4).
**Action:** When adding labels to existing designs that rely on placeholders, use `.visually-hidden` to maintain the visual design while ensuring screen reader support.

## 2024-05-22 - Form Feedback
**Learning:** Legacy forms using `alert()` for feedback feel unresponsive and abrupt.
**Action:** Always wrap form submissions with a loading state (disable button + change text/spinner) to provide immediate visual feedback before the blocking alert appears.

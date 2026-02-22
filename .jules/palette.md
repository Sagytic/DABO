## 2024-05-22 - Accessibility in Vue Components
**Learning:** Legacy Vue components often use raw `<div>` elements for layout without semantic roles or ARIA labels, particularly for icon-only buttons (like "Create Campaign").
**Action:** Always check for `aria-label` on icon buttons and ensure `<img>` tags inside them have `alt` text. Use `.visually-hidden` for labels on search inputs where design hides the label.

## 2024-05-22 - Login Page Accessibility
**Learning:** Found a pattern where forms are implemented as `div` wrappers with no labels (relying on placeholders) and manual `click` handlers. This breaks keyboard navigation (Enter to submit) and screen reader accessibility.
**Action:** Systematically convert these to semantic `<form>` tags with `@submit.prevent`, add `.visually-hidden` labels linked via `for`/`id`, and ensure buttons have explicit `type="button"` or `type="submit"`.

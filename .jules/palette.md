## 2026-02-03 - Semantic Form Structure Missing
**Learning:** The login form relied on `div` wrappers and click handlers, lacking `<form>` tags and associated labels. This prevents standard keyboard interaction (Enter to submit) and hurts accessibility.
**Action:** When touching other forms (signup, info change), check for this pattern and refactor to use semantic `<form>` and accessible labels.

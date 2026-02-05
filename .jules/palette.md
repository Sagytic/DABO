## 2024-05-22 - Icon-Only Buttons and Accessibility
**Learning:** This codebase frequently uses icon-only buttons (e.g., `<button><img src="..." /></button>`) without `aria-label` or `alt` text. This renders major navigation and interaction points invisible to screen readers.
**Action:** When touching any Vue component, check for `<img>` inside `<button>` and ensure the button has `aria-label` and the image has `alt=""` (if decorative) or matching descriptive text.

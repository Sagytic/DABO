## 2024-05-22 - Semantic Forms and Native Validation
**Learning:** Using semantic `<form>` tags and native browser validation (e.g., `required` attribute) provides a better and more accessible user experience than relying on custom JavaScript `alert()` calls for empty field checks. It ensures that users receive immediate, standard feedback without interrupting their flow with blocking popups.
**Action:** When encountering inputs wrapped in `div`s with manual validation, refactor them into semantic `<form>` elements and leverage HTML5 validation attributes.

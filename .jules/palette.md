## 2024-05-22 - Accessibility in Legacy Vue 2
**Learning:** Legacy Vue 2 components often lack semantic HTML (divs instead of forms) and rely on JS alerts. Scoped styles isolate CSS, preventing global utility classes like `.visually-hidden` from working unless defined locally or in a global mixin.
**Action:** When modernizing Vue 2 forms, explicitly wrap inputs in `<form>`, replace `alert()` with native HTML5 validation (`required`), and define `.visually-hidden` within the component's `<style scoped>` block to ensure screen reader accessibility.

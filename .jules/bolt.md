## 2025-02-18 - Frontend Build & Performance
**Learning:** The project uses Vue 2 with webpack. The build process was broken due to deprecated `node-sass`. Replacing it with `sass` (Dart Sass) and adding polyfills (`crypto-browserify`, `process`, `buffer`) fixed the build.
**Action:** When optimizing legacy Vue projects, check for `node-sass` and missing polyfills immediately.

**Learning:** Route-level code splitting was completely missing, loading the entire app in one bundle.
**Action:** Always check `router/index.js` for static imports first.

## 2025-02-18 - Environment Constraints on Verification
**Learning:** Legacy Vue 2 projects with missing polyfills (crypto, buffer) and broken SCSS/PostCSS configurations make visual verification via Playwright difficult without extensive environment patching.
**Action:** When working on legacy repos, prioritize code structure verification and linting if build/serve fails, and isolate changes to independent components to minimize risk.

## 2025-02-18 - Empty State Importance
**Learning:** List components initialized with mock data can be misleading. Explicit `isLoading` and empty states are critical for perceived performance and clarity.
**Action:** Always check `data()` initialization in list components and propose removing hardcoded mock data in favor of proper state management.

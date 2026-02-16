# Bolt's Journal - Critical Learnings

This file tracks critical performance learnings, anti-patterns, and architectural insights.
Only add entries for high-value discoveries that prevent future mistakes.

## 2025-02-23 - Route-Level Code Splitting
**Learning:** The frontend router used static imports for all components, causing a large initial bundle size. Vue Router supports dynamic imports for code splitting, which should be used for all non-critical routes.
**Action:** Use `() => import(...)` with `webpackChunkName` comments for route components to enable lazy loading and better caching.

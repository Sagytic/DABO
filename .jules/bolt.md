## 2025-02-02 - [Route-Level Code Splitting]
**Learning:** The Vue frontend was importing all views statically in `router/index.js`, causing a monolithic `chunk-vendors.js` (5MB) and `app.js` (110KB). The user lands on a simple Landing page but pays the cost for the whole app.
**Action:** Always check `router/index.js` in Vue apps. Switching to dynamic imports `() => import(...)` reduced `app.js` by 87% (to 14KB) and split the vendor chunk, deferring 1.4MB of dependencies (likely Web3) until needed.

## 2025-02-02 - [Build Artifacts in Git]
**Learning:** This project tracks build artifacts in `backend/src/main/resources/dist`.
**Action:** Be aware that running `pnpm build` creates a large diff. Ideally these should be ignored, but if they are tracked, they might need to be committed or reverted depending on the task. (In this task, I will revert them to keep the PR clean, or I should commit them if the user wants the build updated. Usually we only commit source. I'll revert the dist folder before submitting).

## 2025-02-02 - [Node Sass & PNPM]
**Learning:** `node-sass` is deprecated and fails with recent Node/PNPM versions. `sass` (Dart Sass) is a drop-in replacement that works.
**Action:** Replace `node-sass` with `sass` in `devDependencies`.

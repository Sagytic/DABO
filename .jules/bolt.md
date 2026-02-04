## 2025-02-18 - Web3 Polyfills in Vue CLI 5
**Learning:** This Vue 2 project uses `@vue/cli-service` v5 (Webpack 5) with `web3`, but lacked necessary polyfills (`crypto-browserify`, `stream-browserify`, `process`, `buffer`, `bn.js`) in `package.json`, causing build failures. Webpack 5 does not auto-polyfill node core modules.
**Action:** When working with Web3 projects on Webpack 5, immediately check for and install `crypto-browserify` and related polyfills if they are missing.

## 2025-02-18 - Legacy Sass
**Learning:** `node-sass` is deprecated and failed to build in this environment. `sass` (Dart Sass) is the drop-in replacement but requires a check for potential SCSS syntax incompatibilities (though none were found here).
**Action:** Proactively suggest replacing `node-sass` with `sass` in legacy projects to ensure build stability.

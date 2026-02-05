## 2025-02-18 - Build System Fragility & Optimization
**Learning:** The frontend build system is highly sensitive to environment differences. `node-sass` is deprecated and fails to build; replacing it with `sass` is critical. Additionally, Webpack 5 polyfills (crypto-browserify, buffer, process, bn.js) were missing but required for `vue.config.js` configuration.
**Action:** When working on this frontend, immediately ensure `sass` is used instead of `node-sass` and verify all polyfills are explicitly listed in `package.json`.

## 2025-02-18 - PNPM Resolution Compatibility
**Learning:** `pnpm` strictly enforces resolution selectors and rejects `web3/**/uuid`, which works in Yarn. This blocks installation.
**Action:** Use flat resolution keys (e.g., `"uuid": "^7.0.0"`) in `package.json` for pnpm compatibility.

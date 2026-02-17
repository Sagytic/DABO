## 2024-05-22 - [Frontend Architecture] Massive Initial Bundle
**Learning:** The frontend router (`frontend/src/router/index.js`) was statically importing almost all 40+ page components, causing the entire application code to be downloaded in the initial bundle regardless of the route visited.
**Action:** Implement route-level code splitting using dynamic imports (`() => import(...)`) and webpack magic comments to group related features into logical chunks (e.g., `user`, `reservation`, `donation`), significantly reducing TTI.

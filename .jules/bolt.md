## 2026-02-23 - Campaign Sorting Optimization
**Learning:** Found critical performance anti-pattern where entire dataset was fetched and sorted in-memory for basic list views.
**Action:** Always prefer database-level sorting (`OrderBy...`) and eager loading (`@EntityGraph`) over in-memory processing to avoid N+1 issues and memory bloat.

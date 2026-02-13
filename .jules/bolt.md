## 2024-05-22 - Optimize Campaign Fetching
**Learning:** The application was manually sorting `Campaign` entities in memory, which is inefficient for large datasets and was implemented with fragile string parsing that could fail across decades. Replacing this with database-level sorting (`OrderBy...`) is both faster and more correct.
**Action:** Always prefer DB-level sorting and pagination.

**Learning:** `Campaign` entities have a lazy-loaded `user` relationship. Iterating over campaigns and accessing user details caused N+1 queries. Using `@EntityGraph(attributePaths = {"user"})` on repository methods resolves this by fetching the association eagerly in a single query.
**Action:** Use `@EntityGraph` for methods that return lists of entities where associations are accessed.

## 2024-05-22 - Optimizing Sort and N+1 with JPA
**Learning:** Found an inefficient in-memory sort of date strings using fragile substring logic (e.g. `substring(3,4)`), which was incorrect for decade crossings and slow for large datasets. Also identified N+1 queries when accessing related entities in a loop.
**Action:** Replace manual sorting and `findAll()` with a repository method `findAllByOrderBy[Field]Asc/Desc()` and use `@EntityGraph(attributePaths = {...})` to fetch relations eagerly in a single query.

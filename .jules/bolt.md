## 2026-02-20 - N+1 Query Anti-Pattern in Campaign Service
**Learning:** `CampaignService.getAllCampaign` and `getUrgentCampaign` were iterating over all entities and accessing `user.nickname`, triggering N+1 queries due to lazy loading.
**Action:** Use `@EntityGraph(attributePaths = {"user"})` in `ICampaignRepository` to eager fetch related entities in a single query.

## 2026-02-20 - In-Memory Sorting vs Database Sorting
**Learning:** Large datasets were being fetched entirely into memory (`findAll()`) and then sorted/reversed using `Collections.sort` or `Collections.reverse`. This is inefficient for memory and DB load.
**Action:** Replace with database-level sorting via `findAllByOrderBy...` methods in JpaRepository.

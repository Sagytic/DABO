## 2026-02-15 - Campaign Sorting & N+1 Fix
**Learning:** Found critical N+1 issue in `CampaignService` where `user` entity was lazy-loaded inside loops. Also found inefficient in-memory sorting of all campaigns.
**Action:** Replaced `findAll()` + `Collections.sort/reverse()` with database-level sorting (`findAllByOrderBy...`) and used `@EntityGraph` to eager fetch relations. This reduced DB queries from N+1 to 1 and removed O(N log N) in-memory sorting overhead.

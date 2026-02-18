## 2026-02-18 - CampaignService Optimization
**Learning:** `CampaignService` contained N+1 query issues (fetching User per Campaign) and inefficient in-memory sorting/reversing of full datasets.
**Action:** Use `@EntityGraph` in repositories to eager-load related entities and push sorting to the database using `OrderBy` method naming conventions.

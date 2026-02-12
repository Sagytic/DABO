## 2026-02-12 - N+1 Query in CampaignService
**Learning:** `CampaignService.getUrgentCampaign` was performing N+1 queries by fetching users lazily in a loop, and sorting in memory. This is inefficient for large datasets.
**Action:** Use `@EntityGraph` in `ICampaignRepository` to fetch associated entities in a single query, and push sorting to the database using `OrderBy` keywords.

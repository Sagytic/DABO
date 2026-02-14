## 2026-02-14 - N+1 Queries in Campaign Retrieval
**Learning:** Found N+1 query pattern in `CampaignService` where `campaign.getUser().getNickname()` triggered a separate SELECT for each campaign due to `FetchType.LAZY`. This was compounded by loading all campaigns into memory and sorting/reversing manually.
**Action:** Use `@EntityGraph(attributePaths = {"user"})` in `ICampaignRepository` to fetch users eagerly in a single JOIN query. Replace in-memory sorting with `findAllByOrderBy...` methods to push sorting to the database.

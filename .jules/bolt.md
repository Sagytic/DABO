## 2026-02-24 - [N+1 and In-Memory Sorting]
**Learning:** Found `CampaignService` fetching ALL records and sorting/reversing in memory, plus N+1 query for user nicknames.
**Action:** Use `Repository` methods with `OrderBy...` and `@EntityGraph(attributePaths = {"user"})` to offload sorting to DB and eager fetch relations.

## 2026-02-19 - Authorization Bypass in CampaignService
**Vulnerability:** IDOR in `deleteCampaign` allowing any user to delete any campaign.
**Learning:** `CampaignService` methods did not check if the authenticated user owned the resource before performing actions.
**Prevention:** Always verify resource ownership in service methods for update/delete operations using the logged-in user's ID.

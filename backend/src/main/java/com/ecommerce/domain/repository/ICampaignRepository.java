package com.ecommerce.domain.repository;

import com.ecommerce.domain.repository.entity.Campaign;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface ICampaignRepository  extends JpaRepository<Campaign, Long> {
    List<Campaign> findByTitleContaining(String keyword);

    @Transactional
    @Modifying
    @Query(value = "UPDATE campaign set receive_blood_card = receive_blood_card+1 where campaign_id = :campaignId",nativeQuery = true)
    void receiveBloodCard(Long campaignId);

    @Transactional
    @Modifying
    @Query(value = "UPDATE campaign set receive_dabo = receive_dabo + :amount where campaign_id = :campaignId",nativeQuery = true)
    void daboReceive(long campaignId, long amount);

    /**
     * Fetch all campaigns ordered by ID descending (newest first).
     * Uses EntityGraph to eagerly fetch the user to avoid N+1 queries.
     */
    @EntityGraph(attributePaths = {"user"})
    List<Campaign> findAllByOrderByCampaignIdDesc();

    /**
     * Fetch all campaigns ordered by deadline ascending (earliest deadline first).
     * Uses EntityGraph to eagerly fetch the user to avoid N+1 queries.
     */
    @EntityGraph(attributePaths = {"user"})
    List<Campaign> findAllByOrderByDeadLineAsc();
}

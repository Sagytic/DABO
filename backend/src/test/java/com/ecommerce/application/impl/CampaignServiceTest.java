package com.ecommerce.application.impl;

import com.ecommerce.domain.repository.ICampaignRepository;
import com.ecommerce.domain.repository.ICommentRepository;
import com.ecommerce.domain.repository.entity.Campaign;
import com.ecommerce.domain.repository.entity.DABOUser;
import com.ecommerce.infrastructure.repository.DABOUserRepository;
import com.ecommerce.config.media.GlobalConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Collections;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class CampaignServiceTest {

    @Mock
    private ICampaignRepository campaignRepository;

    @Mock
    private ICommentRepository commentRepository;

    @Mock
    private DABOUserRepository userRepository;

    @Mock
    private GlobalConfig config;

    @Mock
    private CommonService commonService;

    @InjectMocks
    private CampaignService campaignService;

    @Test
    public void getAllCampaign_shouldUseOptimizedRepositoryMethod() {
        // Given
        Campaign campaign = new Campaign();
        campaign.setCampaignId(1L);
        DABOUser user = new DABOUser();
        user.setNickname("testUser");
        campaign.setUser(user);

        when(campaignRepository.findAllByOrderByCampaignIdDesc()).thenReturn(Collections.singletonList(campaign));

        // When
        campaignService.getAllCampaign();

        // Then
        verify(campaignRepository).findAllByOrderByCampaignIdDesc();
        verify(campaignRepository, never()).findAll();
    }

    @Test
    public void getUrgentCampaign_shouldUseOptimizedRepositoryMethod() {
        // Given
        Campaign campaign = new Campaign();
        campaign.setCampaignId(1L);
        campaign.setDeadLine("2023-12-31");
        DABOUser user = new DABOUser();
        user.setNickname("testUser");
        campaign.setUser(user);

        when(campaignRepository.findAllByOrderByDeadLineAsc()).thenReturn(Collections.singletonList(campaign));

        // When
        campaignService.getUrgentCampaign();

        // Then
        verify(campaignRepository).findAllByOrderByDeadLineAsc();
        verify(campaignRepository, never()).findAll();
    }
}

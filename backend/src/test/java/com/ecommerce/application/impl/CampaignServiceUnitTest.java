package com.ecommerce.application.impl;

import com.ecommerce.application.impl.CampaignService;
import com.ecommerce.application.impl.CommonService;
import com.ecommerce.config.media.GlobalConfig;
import com.ecommerce.domain.dto.CampaignDto;
import com.ecommerce.domain.repository.ICampaignRepository;
import com.ecommerce.domain.repository.ICommentRepository;
import com.ecommerce.domain.repository.entity.Campaign;
import com.ecommerce.domain.repository.entity.DABOUser;
import com.ecommerce.infrastructure.repository.DABOUserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class CampaignServiceUnitTest {

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
    public void testGetAllCampaign_ShouldUseOptimizedQuery() {
        // Given
        List<Campaign> campaigns = new ArrayList<>();
        Campaign campaign = new Campaign();
        campaign.setCampaignId(1L);
        DABOUser user = new DABOUser();
        user.setNickname("testUser");
        campaign.setUser(user);
        campaigns.add(campaign);

        when(campaignRepository.findAllByOrderByCampaignIdDesc()).thenReturn(campaigns);

        // When
        List<CampaignDto> result = campaignService.getAllCampaign();

        // Then
        verify(campaignRepository, times(1)).findAllByOrderByCampaignIdDesc();
        // verify(campaignRepository, times(0)).findAll(); // Verify findAll is NOT called
    }

    @Test
    public void testGetUrgentCampaign_ShouldUseOptimizedQuery() {
        // Given
        List<Campaign> campaigns = new ArrayList<>();
        Campaign campaign = new Campaign();
        campaign.setCampaignId(1L);
        campaign.setDeadLine("2023-12-31");
        DABOUser user = new DABOUser();
        user.setNickname("testUser");
        campaign.setUser(user);
        campaigns.add(campaign);

        when(campaignRepository.findAllByOrderByDeadLineAsc()).thenReturn(campaigns);

        // When
        List<CampaignDto> result = campaignService.getUrgentCampaign();

        // Then
        verify(campaignRepository, times(1)).findAllByOrderByDeadLineAsc();
        // verify(campaignRepository, times(0)).findAll();
    }
}

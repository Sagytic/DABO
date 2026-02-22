package com.ecommerce.application.impl;

import com.ecommerce.domain.dto.CampaignDto;
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

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
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
    public void testGetAllCampaign_ShouldCallOptimizedMethod() {
        // Arrange
        DABOUser user = DABOUser.builder().userId(1L).nickname("testUser").build();
        Campaign campaign1 = Campaign.builder()
                .campaignId(1L)
                .title("C1")
                .user(user)
                .deadLine("2023-01-01")
                .build();
        Campaign campaign2 = Campaign.builder()
                .campaignId(2L)
                .title("C2")
                .user(user)
                .deadLine("2023-01-02")
                .build();

        // Mock the new method to return ordered list (latest first)
        when(campaignRepository.findAllByOrderByCampaignIdDesc()).thenReturn(Arrays.asList(campaign2, campaign1));

        // Act
        List<CampaignDto> result = campaignService.getAllCampaign();

        // Assert
        // This verification will fail until CampaignService is updated to use the new method
        verify(campaignRepository, times(1)).findAllByOrderByCampaignIdDesc();

        assertEquals(2, result.size());
        assertEquals("C2", result.get(0).getTitle());
    }

    @Test
    public void testGetUrgentCampaign_ShouldCallOptimizedMethod() {
        // Arrange
        DABOUser user = DABOUser.builder().userId(1L).nickname("testUser").build();
        Campaign campaign1 = Campaign.builder()
                .campaignId(1L)
                .title("C1")
                .user(user)
                .deadLine("2023-01-01") // Earliest deadline
                .build();
        Campaign campaign2 = Campaign.builder()
                .campaignId(2L)
                .title("C2")
                .user(user)
                .deadLine("2023-01-02")
                .build();

        // Mock the new method to return ordered list (earliest deadline first)
        when(campaignRepository.findAllByOrderByDeadLineAsc()).thenReturn(Arrays.asList(campaign1, campaign2));

        // Act
        List<CampaignDto> result = campaignService.getUrgentCampaign();

        // Assert
        // This verification will fail until CampaignService is updated to use the new method
        verify(campaignRepository, times(1)).findAllByOrderByDeadLineAsc();

        assertEquals(2, result.size());
        assertEquals("C1", result.get(0).getTitle());
    }
}

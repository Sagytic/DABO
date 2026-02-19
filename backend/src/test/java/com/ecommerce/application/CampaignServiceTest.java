package com.ecommerce.application;

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

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
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
    public void testGetAllCampaign_UsesSortedRepositoryMethod() {
        // Arrange
        DABOUser user = DABOUser.builder()
                .userId(1L)
                .nickname("TestUser")
                .build();

        Campaign campaign1 = Campaign.builder()
                .campaignId(1L)
                .title("Campaign 1")
                .user(user)
                .deadLine("2023-01-01")
                .build();

        Campaign campaign2 = Campaign.builder()
                .campaignId(2L)
                .title("Campaign 2")
                .user(user)
                .deadLine("2023-02-01")
                .build();

        // Simulate returning in ID DESC order (2, then 1)
        when(campaignRepository.findAllByOrderByCampaignIdDesc()).thenReturn(Arrays.asList(campaign2, campaign1));

        // Act
        List<CampaignDto> result = campaignService.getAllCampaign();

        // Assert
        verify(campaignRepository).findAllByOrderByCampaignIdDesc();
        // Should not call findAll() anymore
        verify(campaignRepository, never()).findAll();

        assertEquals(2, result.size());
        assertEquals("Campaign 2", result.get(0).getTitle());
        assertEquals("Campaign 1", result.get(1).getTitle());
    }

    @Test
    public void testGetUrgentCampaign_UsesSortedRepositoryMethod() {
        // Arrange
        DABOUser user = DABOUser.builder()
                .userId(1L)
                .nickname("TestUser")
                .build();

        Campaign campaign1 = Campaign.builder()
                .campaignId(1L)
                .title("Campaign 1")
                .user(user)
                .deadLine("2023-01-01")
                .build();

        Campaign campaign2 = Campaign.builder()
                .campaignId(2L)
                .title("Campaign 2")
                .user(user)
                .deadLine("2023-02-01")
                .build();

        // Simulate returning in Deadline ASC order (1, then 2)
        when(campaignRepository.findAllByOrderByDeadLineAsc()).thenReturn(Arrays.asList(campaign1, campaign2));

        // Act
        List<CampaignDto> result = campaignService.getUrgentCampaign();

        // Assert
        verify(campaignRepository).findAllByOrderByDeadLineAsc();
        // Should not call findAll() anymore
        verify(campaignRepository, never()).findAll();

        assertEquals(2, result.size());
        assertEquals("Campaign 1", result.get(0).getTitle());
        assertEquals("Campaign 2", result.get(1).getTitle());
    }
}

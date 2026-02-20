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

import java.util.ArrayList;
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
    public void getAllCampaign_ShouldUseRepositorySorting() {
        // Arrange
        List<Campaign> campaigns = new ArrayList<>();
        Campaign c1 = Campaign.builder().campaignId(1L).title("C1").user(DABOUser.builder().nickname("User1").build()).build();
        Campaign c2 = Campaign.builder().campaignId(2L).title("C2").user(DABOUser.builder().nickname("User2").build()).build();

        // Mock the repository to return already sorted list (descending ID)
        campaigns.add(c2);
        campaigns.add(c1);

        when(campaignRepository.findAllByOrderByCampaignIdDesc()).thenReturn(campaigns);

        // Act
        List<CampaignDto> result = campaignService.getAllCampaign();

        // Assert
        assertEquals(2, result.size());
        assertEquals("C2", result.get(0).getTitle());
        assertEquals("C1", result.get(1).getTitle());

        verify(campaignRepository, times(1)).findAllByOrderByCampaignIdDesc();
        verify(campaignRepository, never()).findAll();
    }

    @Test
    public void getUrgentCampaign_ShouldUseRepositorySorting() {
        // Arrange
        List<Campaign> campaigns = new ArrayList<>();
        Campaign c1 = Campaign.builder().campaignId(1L).deadLine("2024-01-01").user(DABOUser.builder().nickname("User1").build()).build();
        Campaign c2 = Campaign.builder().campaignId(2L).deadLine("2023-10-25").user(DABOUser.builder().nickname("User2").build()).build();

        // Mock the repository to return already sorted list (ascending deadline)
        campaigns.add(c2);
        campaigns.add(c1);

        when(campaignRepository.findAllByOrderByDeadLineAsc()).thenReturn(campaigns);

        // Act
        List<CampaignDto> result = campaignService.getUrgentCampaign();

        // Assert
        assertEquals(2, result.size());
        assertEquals(2L, result.get(0).getCampaignId().longValue());
        assertEquals(1L, result.get(1).getCampaignId().longValue());

        verify(campaignRepository, times(1)).findAllByOrderByDeadLineAsc();
        verify(campaignRepository, never()).findAll();
    }
}

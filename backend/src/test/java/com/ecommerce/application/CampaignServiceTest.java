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
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

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

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetAllCampaign() {
        // Arrange
        List<Campaign> campaigns = new ArrayList<>();
        DABOUser user = DABOUser.builder().nickname("TestUser").build();
        Campaign campaign1 = Campaign.builder()
                .campaignId(1L)
                .title("C1")
                .user(user)
                .receiveDabo(0)
                .receiveBloodCard(0)
                .build();
        Campaign campaign2 = Campaign.builder()
                .campaignId(2L)
                .title("C2")
                .user(user)
                .receiveDabo(0)
                .receiveBloodCard(0)
                .build();

        // Mocking the sorted return from repository
        campaigns.add(campaign2);
        campaigns.add(campaign1);

        when(campaignRepository.findAllByOrderByCampaignIdDesc()).thenReturn(campaigns);

        // Act
        List<CampaignDto> result = campaignService.getAllCampaign();

        // Assert
        assertEquals(2, result.size());
        assertEquals("C2", result.get(0).getTitle());
        assertEquals("C1", result.get(1).getTitle());
        verify(campaignRepository).findAllByOrderByCampaignIdDesc();
    }

    @Test
    public void testGetUrgentCampaign() {
        // Arrange
        List<Campaign> campaigns = new ArrayList<>();
        DABOUser user = DABOUser.builder().nickname("TestUser").build();
        Campaign campaign1 = Campaign.builder()
                .campaignId(1L)
                .title("Urgent1")
                .deadLine("2023-01-01")
                .user(user)
                .receiveDabo(0)
                .receiveBloodCard(0)
                .build();
        Campaign campaign2 = Campaign.builder()
                .campaignId(2L)
                .title("Urgent2")
                .deadLine("2023-01-02")
                .user(user)
                .receiveDabo(0)
                .receiveBloodCard(0)
                .build();

        // Mocking the sorted return from repository
        campaigns.add(campaign1);
        campaigns.add(campaign2);

        when(campaignRepository.findAllByOrderByDeadLineAsc()).thenReturn(campaigns);

        // Act
        List<CampaignDto> result = campaignService.getUrgentCampaign();

        // Assert
        assertEquals(2, result.size());
        assertEquals("Urgent1", result.get(0).getTitle());
        assertEquals("Urgent2", result.get(1).getTitle());
        verify(campaignRepository).findAllByOrderByDeadLineAsc();
    }
}

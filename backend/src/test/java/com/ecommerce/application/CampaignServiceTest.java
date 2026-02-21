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
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

    private Campaign campaign1;
    private Campaign campaign2;
    private DABOUser user;

    @Before
    public void setUp() {
        user = DABOUser.builder()
                .userId(1L)
                .nickname("testuser")
                .build();

        campaign1 = Campaign.builder()
                .campaignId(1L)
                .title("Campaign 1")
                .deadLine("2023-01-01")
                .user(user)
                .build();

        campaign2 = Campaign.builder()
                .campaignId(2L)
                .title("Campaign 2")
                .deadLine("2023-02-01")
                .user(user)
                .build();
    }

    @Test
    public void testGetAllCampaign() {
        // Given
        // Sorted as expected by the query (Newest first: ID 2, then ID 1)
        List<Campaign> campaigns = new ArrayList<>(Arrays.asList(campaign2, campaign1));
        when(campaignRepository.findAllByOrderByCampaignIdDesc()).thenReturn(campaigns);

        // When
        List<CampaignDto> result = campaignService.getAllCampaign();

        // Then
        // Verify new method is called
        verify(campaignRepository, times(1)).findAllByOrderByCampaignIdDesc();
        // Verify order is preserved (no extra reversal)
        Assert.assertEquals(Long.valueOf(2L), result.get(0).getCampaignId());
        Assert.assertEquals(Long.valueOf(1L), result.get(1).getCampaignId());
    }

    @Test
    public void testGetUrgentCampaign() {
        // Given
        // Sorted as expected by the query (Earliest deadline first: ID 1, then ID 2)
        List<Campaign> campaigns = new ArrayList<>(Arrays.asList(campaign1, campaign2));
        when(campaignRepository.findAllByOrderByDeadLineAsc()).thenReturn(campaigns);

        // When
        List<CampaignDto> result = campaignService.getUrgentCampaign();

        // Then
        // Verify new method is called
        verify(campaignRepository, times(1)).findAllByOrderByDeadLineAsc();
        // Verify order is preserved (no extra sorting)
        Assert.assertEquals(Long.valueOf(1L), result.get(0).getCampaignId());
        Assert.assertEquals(Long.valueOf(2L), result.get(1).getCampaignId());
    }
}

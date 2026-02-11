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
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

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
    public void testGetUrgentCampaign() {
        // Given
        DABOUser user = DABOUser.builder()
                .nickname("TestUser")
                .build();

        Campaign campaign1 = Campaign.builder()
                .campaignId(1L)
                .title("Campaign 1")
                .content("Content 1")
                .deadLine("2023-12-31")
                .user(user)
                .build();

        Campaign campaign2 = Campaign.builder()
                .campaignId(2L)
                .title("Campaign 2")
                .content("Content 2")
                .deadLine("2024-01-01")
                .user(user)
                .build();

        List<Campaign> sortedCampaigns = Arrays.asList(campaign1, campaign2);

        when(campaignRepository.findAllByOrderByDeadLineAsc()).thenReturn(sortedCampaigns);

        // When
        List<CampaignDto> result = campaignService.getUrgentCampaign();

        // Then
        verify(campaignRepository).findAllByOrderByDeadLineAsc();
        assertEquals(2, result.size());
        assertEquals("Campaign 1", result.get(0).getTitle());
        assertEquals("Campaign 2", result.get(1).getTitle());
        assertEquals("TestUser", result.get(0).getUsername());
    }
}

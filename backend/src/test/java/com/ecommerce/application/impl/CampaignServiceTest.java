package com.ecommerce.application.impl;

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
        DABOUser user = DABOUser.builder().nickname("testUser").build();
        Campaign campaign1 = Campaign.builder().campaignId(1L).title("C1").user(user).deadLine("2022-01-01").build();
        Campaign campaign2 = Campaign.builder().campaignId(2L).title("C2").user(user).deadLine("2022-02-01").build();

        when(campaignRepository.findAllByOrderByDeadLineAsc()).thenReturn(Arrays.asList(campaign1, campaign2));

        // When
        List<CampaignDto> result = campaignService.getUrgentCampaign();

        // Then
        verify(campaignRepository).findAllByOrderByDeadLineAsc();
        assertEquals(2, result.size());
        assertEquals("C1", result.get(0).getTitle());
        assertEquals("C2", result.get(1).getTitle());
    }
}

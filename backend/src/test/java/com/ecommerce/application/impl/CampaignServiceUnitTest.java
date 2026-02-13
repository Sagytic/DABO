package com.ecommerce.application.impl;

import com.ecommerce.application.impl.CampaignService;
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

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

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
    public void testGetUrgentCampaign() {
        // Given
        List<Campaign> campaigns = new ArrayList<>();
        DABOUser user = new DABOUser();
        user.setNickname("testUser");

        Campaign c1 = new Campaign();
        c1.setCampaignId(1L);
        c1.setUser(user);
        c1.setDeadLine("2022-05-05");

        Campaign c2 = new Campaign();
        c2.setCampaignId(2L);
        c2.setUser(user);
        c2.setDeadLine("2022-06-05");

        campaigns.add(c1);
        campaigns.add(c2);

        when(campaignRepository.findAllByOrderByDeadLineAsc()).thenReturn(campaigns);

        // When
        List<CampaignDto> result = campaignService.getUrgentCampaign();

        // Then
        verify(campaignRepository).findAllByOrderByDeadLineAsc();
        assertEquals(2, result.size());
        assertEquals("testUser", result.get(0).getUsername());
    }

    @Test
    public void testGetAllCampaign() {
        // Given
        List<Campaign> campaigns = new ArrayList<>();
        DABOUser user = new DABOUser();
        user.setNickname("testUser");

        Campaign c1 = new Campaign();
        c1.setCampaignId(2L);
        c1.setUser(user);

        Campaign c2 = new Campaign();
        c2.setCampaignId(1L);
        c2.setUser(user);

        campaigns.add(c1);
        campaigns.add(c2);

        when(campaignRepository.findAllByOrderByCampaignIdDesc()).thenReturn(campaigns);

        // When
        List<CampaignDto> result = campaignService.getAllCampaign();

        // Then
        verify(campaignRepository).findAllByOrderByCampaignIdDesc();
        assertEquals(2, result.size());
        assertEquals(Long.valueOf(2L), result.get(0).getCampaignId());
    }
}

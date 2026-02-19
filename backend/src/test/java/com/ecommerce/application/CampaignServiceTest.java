package com.ecommerce.application;

import com.ecommerce.application.impl.CampaignService;
import com.ecommerce.application.impl.CommonService;
import com.ecommerce.config.media.GlobalConfig;
import com.ecommerce.domain.repository.ICampaignRepository;
import com.ecommerce.domain.repository.ICommentRepository;
import com.ecommerce.domain.repository.entity.Campaign;
import com.ecommerce.domain.repository.entity.DABOUser;
import com.ecommerce.infrastructure.repository.DABOUserRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
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

    private DABOUser campaignOwner;
    private DABOUser otherUser;
    private Campaign campaign;

    @Before
    public void setUp() {
        campaignOwner = DABOUser.builder()
                .userId(1L)
                .email("owner@example.com")
                .nickname("owner")
                .build();

        otherUser = DABOUser.builder()
                .userId(2L)
                .email("other@example.com")
                .nickname("other")
                .build();

        campaign = Campaign.builder()
                .campaignId(100L)
                .user(campaignOwner)
                .title("Test Campaign")
                .build();
    }

    @Test
    public void deleteCampaign_ShouldReturnOk_WhenUserIsOwner() {
        // Arrange
        when(campaignRepository.findById(100L)).thenReturn(Optional.of(campaign));
        when(commonService.getLoginUser()).thenReturn(campaignOwner);

        // Act
        ResponseEntity<?> response = campaignService.deleteCampaign(100L);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        verify(campaignRepository, times(1)).delete(campaign);
    }

    @Test
    public void deleteCampaign_ShouldReturnForbidden_WhenUserIsNotOwner() {
        // Arrange
        when(campaignRepository.findById(100L)).thenReturn(Optional.of(campaign));
        when(commonService.getLoginUser()).thenReturn(otherUser);

        // Act
        ResponseEntity<?> response = campaignService.deleteCampaign(100L);

        // Assert
        assertEquals(HttpStatus.FORBIDDEN, response.getStatusCode());
        verify(campaignRepository, never()).delete(any(Campaign.class));
    }

    @Test
    public void deleteCampaign_ShouldReturnForbidden_WhenUserNotLoggedIn() {
        // Arrange
        when(campaignRepository.findById(100L)).thenReturn(Optional.of(campaign));
        when(commonService.getLoginUser()).thenReturn(new DABOUser()); // Empty user

        // Act
        ResponseEntity<?> response = campaignService.deleteCampaign(100L);

        // Assert
        assertEquals(HttpStatus.FORBIDDEN, response.getStatusCode());
        verify(campaignRepository, never()).delete(any(Campaign.class));
    }
}

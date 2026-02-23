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
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

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

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void deleteCampaign_ShouldReturnForbidden_WhenUserIsNotOwner() {
        // Arrange
        Long campaignId = 1L;
        Long ownerId = 10L;
        Long otherUserId = 20L;

        DABOUser owner = DABOUser.builder().userId(ownerId).build();
        DABOUser otherUser = DABOUser.builder().userId(otherUserId).build();

        Campaign campaign = Campaign.builder()
                .campaignId(campaignId)
                .user(owner)
                .build();

        when(campaignRepository.findById(campaignId)).thenReturn(Optional.of(campaign));
        when(commonService.getLoginUser()).thenReturn(otherUser);

        // Act
        ResponseEntity<?> response = campaignService.deleteCampaign(campaignId);

        // Assert
        // CURRENTLY this will fail because it returns OK.
        // I expect FORBIDDEN after fix.
        assertEquals(HttpStatus.FORBIDDEN, response.getStatusCode());
    }

    @Test
    public void updateCampaign_ShouldReturnForbidden_WhenUserIsNotOwner() {
        // Arrange
        Long campaignId = 1L;
        Long ownerId = 10L;
        Long otherUserId = 20L;

        DABOUser owner = DABOUser.builder().userId(ownerId).build();
        DABOUser otherUser = DABOUser.builder().userId(otherUserId).build();

        Campaign campaign = Campaign.builder()
                .campaignId(campaignId)
                .user(owner)
                .build();

        CampaignDto campaignDto = new CampaignDto(); // Mock DTO

        when(campaignRepository.findById(campaignId)).thenReturn(Optional.of(campaign));
        when(commonService.getLoginUser()).thenReturn(otherUser);

        // Act
        ResponseEntity<?> response = campaignService.updateCampaign(campaignId, campaignDto);

        // Assert
        assertEquals(HttpStatus.FORBIDDEN, response.getStatusCode());
    }

    @Test
    public void deleteCampaign_ShouldReturnUnauthorized_WhenUserNotLoggedIn() {
        // Arrange
        Long campaignId = 1L;
        Long ownerId = 10L;

        DABOUser owner = DABOUser.builder().userId(ownerId).build();
        DABOUser anonymousUser = new DABOUser(); // ID is null

        Campaign campaign = Campaign.builder()
                .campaignId(campaignId)
                .user(owner)
                .build();

        when(campaignRepository.findById(campaignId)).thenReturn(Optional.of(campaign));
        when(commonService.getLoginUser()).thenReturn(anonymousUser);

        // Act
        ResponseEntity<?> response = campaignService.deleteCampaign(campaignId);

        // Assert
        assertEquals(HttpStatus.UNAUTHORIZED, response.getStatusCode());
    }

    @Test
    public void deleteCampaign_ShouldReturnOk_WhenUserIsOwner() {
        // Arrange
        Long campaignId = 1L;
        Long ownerId = 10L;

        DABOUser owner = DABOUser.builder().userId(ownerId).build();

        Campaign campaign = Campaign.builder()
                .campaignId(campaignId)
                .user(owner)
                .build();

        when(campaignRepository.findById(campaignId)).thenReturn(Optional.of(campaign));
        when(commonService.getLoginUser()).thenReturn(owner);

        // Act
        ResponseEntity<?> response = campaignService.deleteCampaign(campaignId);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }
}

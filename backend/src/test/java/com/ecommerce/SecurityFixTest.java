package com.ecommerce;

import com.ecommerce.domain.repository.entity.DABOUser;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import static org.junit.Assert.*;

public class SecurityFixTest {

    @Test
    public void testPasswordIsIgnored() throws Exception {
        DABOUser user = DABOUser.builder()
                .email("test@example.com")
                .password("secretHash")
                .nickname("tester")
                .point(100L)
                .build();

        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(user);

        assertFalse("Password should not be present in JSON", json.contains("secretHash"));
        assertTrue("Email should be present", json.contains("test@example.com"));
    }
}

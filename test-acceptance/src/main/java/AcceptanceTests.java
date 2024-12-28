package com.example;

import org.junit.jupiter.api.Test;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.*;

public class AcceptanceTests {

    @Test
    public void testApplicationRunning() {
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8080/actuator/health";

        String response = restTemplate.getForObject(url, String.class);
        assertNotNull(response);
        assertTrue(response.contains("\"status\":\"UP\""));
    }
}

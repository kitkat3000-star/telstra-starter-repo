package au.com.telstra.simcardactivator.controllers;

import au.com.telstra.simcardactivator.dtos.ActuatorResponse;
import au.com.telstra.simcardactivator.dtos.SimActivationRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@RestController
@RequestMapping("/sim")
public class SimActivationController {

    private final RestTemplate restTemplate = new RestTemplate();

    @PostMapping("/activate")
    public ResponseEntity<String> activateSim(@RequestBody SimActivationRequest request) {
        // Prepare payload for actuator
        Map<String, String> actuatorPayload = new HashMap<>();
        actuatorPayload.put("iccid", request.getIccid());

        // Send POST to actuator
        ResponseEntity<ActuatorResponse> response = restTemplate.postForEntity(
                "http://localhost:8444/actuate",
                actuatorPayload,
                ActuatorResponse.class
        );

        boolean success = Objects.requireNonNull(response.getBody()).isSuccess();
        System.out.println("Activation result: " + success);

        return ResponseEntity.ok("Activation " + (success ? "successful" : "failed"));
    }
}


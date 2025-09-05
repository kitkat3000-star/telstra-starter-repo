package au.com.telstra.simcardactivator.controllers;

import au.com.telstra.simcardactivator.dtos.ActuatorResponse;
import au.com.telstra.simcardactivator.dtos.SimCard;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class SimActuatorHandler {
    private final RestTemplate restTemplate;
    private final String apiUrl;

    public SimActuatorHandler(RestTemplateBuilder builder){
        this.restTemplate = builder.build();
        this.apiUrl = "http://localhost:8444/actuate";
    }

    public ActuatorResponse actuate(SimCard simCard){
        return restTemplate.postForObject(apiUrl, simCard, ActuatorResponse.class);
    }
}

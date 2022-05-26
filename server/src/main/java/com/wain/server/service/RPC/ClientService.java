package com.wain.server.service.RPC;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ClientService {
    private final RestTemplate restTemplate;

    public ClientService(RestTemplateBuilder restTemplateBuilder){
        this.restTemplate = restTemplateBuilder.rootUri("http://localhost:8000/").build();
    }

    public RestTemplate getRestTemplate() {
        return restTemplate;
    }
}

package com.example.loadbalanc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class StatusController {

    @Autowired
    private RestTemplate template;

    @GetMapping("/balancer")
    public String statusService(){
        return template.getForObject("http://QUESTAO-SERVICE/status", String.class);
    }
}

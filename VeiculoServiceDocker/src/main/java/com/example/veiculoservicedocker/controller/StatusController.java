package com.example.veiculoservicedocker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("status")
public class StatusController {
    @Autowired
    private Environment env;

    @GetMapping
    public ResponseEntity<String> getStatus(){
        String port = env.getProperty("local.server.port");
        return ResponseEntity.ok("Online, Ok "+port);
    }

}

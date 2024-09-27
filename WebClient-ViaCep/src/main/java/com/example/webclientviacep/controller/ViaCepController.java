package com.example.webclientviacep.controller;

import com.example.webclientviacep.model.ViaCep;
import com.example.webclientviacep.service.ViaCepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("api/cep")
public class ViaCepController {
    @Autowired
    private ViaCepService viaCepService;

    @GetMapping("/{cep}")
    public Mono<ViaCep> buscarPorCep(@PathVariable String cep){
        return viaCepService.obterEnderecoPorCep(cep);
    }
}

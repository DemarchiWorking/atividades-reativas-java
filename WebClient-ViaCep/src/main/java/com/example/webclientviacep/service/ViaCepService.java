package com.example.webclientviacep.service;

import com.example.webclientviacep.model.ViaCep;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class ViaCepService {
    private final WebClient webClient;

    public ViaCepService(WebClient.Builder webClientBuilder){
        this.webClient = webClientBuilder.baseUrl("https://viacep.com.br/ws/").build();

    }

    public Mono<ViaCep> obterEnderecoPorCep(String cep){
        return this.webClient.get()
                .uri(cep+"/json/")
                .retrieve()
                .bodyToMono(ViaCep.class)
                .onErrorResume(error -> Mono.error(new Exception("")));
    }
}

package com.example.veiculoservicedocker;

import com.example.veiculoservicedocker.model.Veiculo;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.springframework.beans.factory.annotation.Autowired;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@TestMethodOrder(OrderAnnotation.class)
public class VeiculoControllerTestes {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;
    @Test
    @Order(1)
    public void salvarVeiculo() throws Exception {
        Veiculo veiculo = new Veiculo();
        veiculo.setModelo("Corsa 1");
        veiculo.setMarca("Chevro");
        veiculo.setAno(2011);
        veiculo.setFoto("Exemplo");
        veiculo.setDescricao("Exemplo");
        veiculo.setPlaca("Exemplo");

        mockMvc.perform(post("/api/veiculos")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(veiculo)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.modelo").value("Marca Exemplo"))
                .andExpect(jsonPath("$.marca").value("Marca Exemplo"))
                .andExpect(jsonPath("$.ano").value(2011))
                .andExpect(jsonPath("$.foto").value("Marca Exemplo"))
                .andExpect(jsonPath("$.descricao").value("Marca Exemplo"))
                .andExpect(jsonPath("$.placa").value("Marca Exemplo"));
    }
    @Test
    @Order(2)
    public void listarVeiculos() throws Exception {
        mockMvc.perform(get("/api/veiculos"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray());
    }
    @Test
    @Order(3)
    public void getVeiculoById() throws Exception {
        long id = 1L;
        mockMvc.perform(get("/api/veiculos/{id}", id))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(id));
    }

    @Test
    @Order(4)
    public void excluirVeiculo() throws Exception {
        long id = 1L;
        mockMvc.perform(delete("/api/veiculos/{id}", id))
                .andExpect(status().isOk());
    }


}
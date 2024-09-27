package com.example.veiculoservicedocker.controller;

import com.example.veiculoservicedocker.model.Veiculo;
import com.example.veiculoservicedocker.service.VeiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/veiculos")
public class VeiculoController {
    @Autowired
    private VeiculoService veiculoService;

    @GetMapping
    public List<Veiculo> listar(){
        return veiculoService.findAll();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Veiculo> getVeiculoId(@PathVariable Long id){
        Optional<Veiculo> veiculo = veiculoService.findById(id);
        return veiculo.isPresent()? ResponseEntity.ok(veiculo.get()) : ResponseEntity.notFound().build();
    }
    @PostMapping
    public Veiculo salvarVeiculo(@RequestBody Veiculo veiculo){
        return veiculoService.save(veiculo);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity excluirVeiculo(@PathVariable Long id){
        veiculoService.delete(id);
        return ResponseEntity.ok().build();
    }
}

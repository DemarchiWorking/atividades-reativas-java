package com.example.veiculoservicedocker.service;

import com.example.veiculoservicedocker.model.Veiculo;
import com.example.veiculoservicedocker.repository.VeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VeiculoService {
    @Autowired
    private VeiculoRepository veiculoRepository;

    public List<Veiculo> findAll(){
        return veiculoRepository.findAll();
    }
    public Optional<Veiculo> findById(Long id){
        return veiculoRepository.findById(id);
    }
    public Veiculo save(Veiculo veiculo){
        return veiculoRepository.save(veiculo);
    }
    public void delete(Long id){
        veiculoRepository.deleteById(id);
    }
}

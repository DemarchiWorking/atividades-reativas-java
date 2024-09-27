package com.example.veiculoservicedocker.repository;

import com.example.veiculoservicedocker.model.Veiculo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VeiculoRepository extends JpaRepository<Veiculo, Long> {
}

package com.example.projetoexemploreactivespring.repository;

import com.example.projetoexemploreactivespring.model.Produto;
import org.springframework.data.r2dbc.repository.R2dbcRepository;

public interface ProdutoRepository extends R2dbcRepository<Produto, Long> {
}

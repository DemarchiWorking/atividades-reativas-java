package com.example.projetoexemploreactivespring.controller;

import com.example.projetoexemploreactivespring.model.Produto;
import com.example.projetoexemploreactivespring.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {
    @Autowired
    private ProdutoService produtoService;

    @GetMapping
    public Flux<Produto> findAll(){
        return produtoService.findAll();
    }
    @GetMapping("/{id}")
    public Mono<Produto> findById(@PathVariable Long id){
        return produtoService.findById(id);
    }
    @PostMapping
    public Mono<Produto> save(@RequestBody Produto produto){
        return produtoService.save(produto);
    }
    @PutMapping("/{id}")
    public Mono<Produto> update(@PathVariable Long id, @RequestBody Produto produto){
        return produtoService.update(id, produto);
    }
    @DeleteMapping("/{id}")
    public Mono<Void> delete(@PathVariable Long id){
        return produtoService.deleteById(id);
    }
}

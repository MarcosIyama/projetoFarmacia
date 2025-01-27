package com.generation.crud_farmacia.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.generation.crud_farmacia.model.Produto;
import com.generation.crud_farmacia.repository.ProdutoRepository;

@Service
public class ProdutoService {

	@Autowired
    private ProdutoRepository produtoRepository;
	
	// Método para ativar a disponibilidade de um produto
    public Produto ativarProduto(Long id) {
        Produto produto = produtoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado."));
        produto.ativarDisponivel(); // Método da entidade para ativar o produto
        return produtoRepository.save(produto); // Salva a alteração no banco de dados
    }
    
 // Método para desativar a disponibilidade de um produto
    public Produto desativarProduto(Long id) {
        Produto produto = produtoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado."));
        produto.desativarDisponivel(); // Método da entidade para desativar o produto
        return produtoRepository.save(produto); // Salva a alteração no banco de dados
    }
    
}

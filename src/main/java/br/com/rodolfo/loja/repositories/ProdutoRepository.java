package br.com.rodolfo.loja.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.rodolfo.loja.domain.Produto;

/**
 * ProdutoRepository
 */
public interface ProdutoRepository extends JpaRepository<Produto, Integer>{

    
    
}
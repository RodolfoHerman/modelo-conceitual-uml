package br.com.rodolfo.loja.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.rodolfo.loja.domain.Produto;

/**
 * ProdutoRepository
 */
@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer>{

    
    
}
package br.com.rodolfo.loja.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.rodolfo.loja.domain.Cidade;

/**
 * CidadeRepository
 */
public interface CidadeRepository extends JpaRepository<Cidade, Integer>{

    
}
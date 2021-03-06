package br.com.rodolfo.loja.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.rodolfo.loja.domain.Cidade;

/**
 * CidadeRepository
 */
@Repository
public interface CidadeRepository extends JpaRepository<Cidade, Integer>{

    
}
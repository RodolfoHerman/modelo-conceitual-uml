package br.com.rodolfo.loja.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.rodolfo.loja.domain.Endereco;

/**
 * EnderecoRepository
 */
@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Integer>{

    
}
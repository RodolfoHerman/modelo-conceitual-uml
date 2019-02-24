package br.com.rodolfo.loja.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.rodolfo.loja.domain.Endereco;

/**
 * EnderecoRepository
 */
public interface EnderecoRepository extends JpaRepository<Endereco, Integer>{

    
}
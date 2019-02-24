package br.com.rodolfo.loja.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.rodolfo.loja.domain.Cliente;

/**
 * ClienteRepository
 */
public interface ClienteRepository extends JpaRepository<Cliente, Integer>{

    
}
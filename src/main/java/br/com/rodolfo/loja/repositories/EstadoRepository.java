package br.com.rodolfo.loja.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.rodolfo.loja.domain.Estado;

/**
 * EstadoRepository
 */
public interface EstadoRepository extends JpaRepository<Estado, Integer>{

    
}
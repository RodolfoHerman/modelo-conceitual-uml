package br.com.rodolfo.loja.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.rodolfo.loja.domain.Pedido;

/**
 * PedidoRepository
 */
@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Integer>{

    
}
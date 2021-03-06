package br.com.rodolfo.loja.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.rodolfo.loja.domain.ItemPedido;

/**
 * ItemPedidoRepository
 */
@Repository
public interface ItemPedidoRepository extends JpaRepository<ItemPedido, Integer> {

    
}
package br.com.rodolfo.loja.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.rodolfo.loja.domain.Pagamento;

/**
 * PagamentoRepository
 */
@Repository
public interface PagamentoRepository extends JpaRepository<Pagamento, Integer>{

    
}
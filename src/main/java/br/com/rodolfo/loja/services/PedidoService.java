package br.com.rodolfo.loja.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.rodolfo.loja.domain.Pedido;
import br.com.rodolfo.loja.repositories.PedidoRepository;
import br.com.rodolfo.loja.services.exceptions.ObjectNotFoundException;

/**
 * PedidoService
 */
@Service
public class PedidoService {

    @Autowired
    PedidoRepository pedidoRepository;

    public Pedido buscar(Integer id) {
        
        Optional<Pedido> obj = pedidoRepository.findById(id);

        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado ! ID : ".concat("" + id)
            .concat(", TIPO : ").concat(PedidoService.class.getName())));
    }
    
}
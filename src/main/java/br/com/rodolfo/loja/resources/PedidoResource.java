package br.com.rodolfo.loja.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.rodolfo.loja.domain.Pedido;
import br.com.rodolfo.loja.services.PedidoService;

/**
 * PedidoResource
 */
@RestController
@RequestMapping(value="/pedidos")
public class PedidoResource {

    @Autowired
    private PedidoService pedidoService;

    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public ResponseEntity<?> find(@PathVariable Integer id) {
        
        Pedido pedido = pedidoService.buscar(id);

        return ResponseEntity.ok().body(pedido);
    }
    
}
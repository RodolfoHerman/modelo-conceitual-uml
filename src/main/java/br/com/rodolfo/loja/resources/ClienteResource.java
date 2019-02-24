package br.com.rodolfo.loja.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.rodolfo.loja.domain.Cliente;
import br.com.rodolfo.loja.services.ClienteService;

/**
 * ClienteResource
 */
@RestController
@RequestMapping(value="/clientes")
public class ClienteResource {

    @Autowired
    private ClienteService clienteService;

    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public ResponseEntity<?> find(@PathVariable Integer id) {
        
        Cliente cliente = clienteService.buscar(id);

        return ResponseEntity.ok().body(cliente);
    }
    
}
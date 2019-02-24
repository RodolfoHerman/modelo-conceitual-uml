package br.com.rodolfo.loja.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.rodolfo.loja.domain.Cliente;
import br.com.rodolfo.loja.repositories.ClienteRepository;
import br.com.rodolfo.loja.services.exceptions.ObjectNotFoundException;

/**
 * ClienteService
 */
@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente buscar(Integer id) {
        
        Optional<Cliente> obj = clienteRepository.findById(id);

        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado ! ID : ".concat("" + id)
            .concat(", TIPO : ").concat(Cliente.class.getName())));
    }
}
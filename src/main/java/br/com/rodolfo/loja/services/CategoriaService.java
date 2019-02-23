package br.com.rodolfo.loja.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.rodolfo.loja.domain.Categoria;
import br.com.rodolfo.loja.repositories.CategoriaRepository;
import br.com.rodolfo.loja.services.exceptions.ObjectNotFoundException;

/**
 * CategoriaService
 */
@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public Categoria buscar(Integer id) {
        
        Optional<Categoria> obj = categoriaRepository.findById(id);
        
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado ! ID : ".concat("" + id)
            .concat(", TIPO : ").concat(Categoria.class.getName())));
    }
}
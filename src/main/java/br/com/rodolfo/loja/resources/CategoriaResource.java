package br.com.rodolfo.loja.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.rodolfo.loja.domain.Categoria;
import br.com.rodolfo.loja.services.CategoriaService;

/**
 * CategoriaResource
 */
@RestController
@RequestMapping(value="/categorias")
public class CategoriaResource {

    @Autowired
    private CategoriaService categoriaService;

    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public ResponseEntity<?> find(@PathVariable Integer id) {
        
        Categoria obj = categoriaService.buscar(id);
        
        return ResponseEntity.ok().body(obj);
    }
    
}
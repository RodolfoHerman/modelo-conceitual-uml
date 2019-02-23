package br.com.rodolfo.loja.domain;

import java.io.Serializable;
import java.util.Objects;

/**
 * Categoria
 */
public class Categoria implements Serializable{

    private static final long serialVersionUID = 1L;

    private Integer id;

    private String nome;

    public Categoria() {}

    public Categoria(Integer id, String nome) {

        super();
        this.id = id;
        this.nome = nome;
    }


    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }


    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Categoria)) {
            return false;
        }
        Categoria categoria = (Categoria) o;
        return Objects.equals(id, categoria.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
    

    
}
package br.com.rodolfo.loja.domain;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonManagedReference;

/**
 * Cidade
 */
@Entity
public class Cidade implements Serializable{

    private static final long serialVersionUID = -2050530689664010365L;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

    private String nome;

    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name="estado_id")
    private Estado estado;

    public Cidade() {}

    public Cidade(Integer id, String nome, Estado estado) {

        super();
        this.id = id;
        this.nome = nome;
        this.estado = estado;
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

    public Estado getEstado() {
        return this.estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Cidade)) {
            return false;
        }
        Cidade cidade = (Cidade) o;
        return Objects.equals(id, cidade.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    
}
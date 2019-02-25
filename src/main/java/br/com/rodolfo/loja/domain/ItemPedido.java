package br.com.rodolfo.loja.domain;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * ItemPedido
 */
@Entity
public class ItemPedido implements Serializable {

    private static final long serialVersionUID = 7062377515791010018L;

    private Double desconto;
    
    private Integer quantidade;
    
    private Double preco;

    @JsonIgnore
    @EmbeddedId
    private ItemPedidoPK id = new ItemPedidoPK();

    public ItemPedido() {}


    public ItemPedido(Pedido pedido, Produto produto, Double desconto, Integer quantidade, Double preco) {
        
        super();
        this.desconto = desconto;
        this.quantidade = quantidade;
        this.preco = preco;
        this.id.setProduto(produto);
        this.id.setPedido(pedido);
    }


    public Double getDesconto() {
        return this.desconto;
    }

    public void setDesconto(Double desconto) {
        this.desconto = desconto;
    }

    public Integer getQuantidade() {
        return this.quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Double getPreco() {
        return this.preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public ItemPedidoPK getId() {
        return this.id;
    }

    public void setId(ItemPedidoPK id) {
        this.id = id;
    }

    @JsonIgnore
    public Pedido getPedido() {
        return this.id.getPedido();
    }

    //Não colocar @JsonIgnore permitindo a serialização e quando acessa o endpoit /pedidos/1
    //aparecer os produtos
    public Produto getProduto() {
        return this.id.getProduto();
    }
    

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof ItemPedido)) {
            return false;
        }
        ItemPedido itemPedido = (ItemPedido) o;
        return Objects.equals(id, itemPedido.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

}
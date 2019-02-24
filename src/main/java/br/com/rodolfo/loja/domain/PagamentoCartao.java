package br.com.rodolfo.loja.domain;

import javax.persistence.Entity;

import br.com.rodolfo.loja.domain.enums.EstadoPagamento;

/**
 * PagamentoCartao
 */
@Entity
public class PagamentoCartao extends Pagamento {

    private static final long serialVersionUID = -3633217106117846569L;

    private Integer numeroParcelas;

    public PagamentoCartao() {}


    public PagamentoCartao(Integer id, EstadoPagamento estado, Pedido pedido, Integer numeroParcelas) {
        
        super(id, estado, pedido);
        this.numeroParcelas = numeroParcelas;
    }


    public Integer getNumeroParcelas() {
        return this.numeroParcelas;
    }

    public void setNumeroParcelas(Integer numeroParcelas) {
        this.numeroParcelas = numeroParcelas;
    }


    
}
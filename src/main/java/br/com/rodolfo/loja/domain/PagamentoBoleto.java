package br.com.rodolfo.loja.domain;

import java.util.Date;

import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.rodolfo.loja.domain.enums.EstadoPagamento;

/**
 * PagamentoBoleto
 */
@Entity
public class PagamentoBoleto extends Pagamento {

    private static final long serialVersionUID = -3633217106117846569L;

    @JsonFormat(pattern="dd/MM/yyyy")
    private Date dataPagamento;
    
    @JsonFormat(pattern="dd/MM/yyyy")
    private Date dataVencimento;

    public PagamentoBoleto() {}


    public PagamentoBoleto(Integer id, EstadoPagamento estado, Pedido pedido, Date dataPagamento, Date dataVencimento) {
        
        super(id, estado, pedido);
        this.dataPagamento = dataPagamento;
        this.dataVencimento = dataVencimento;
    }


    public Date getDataPagamento() {
        return this.dataPagamento;
    }

    public void setDataPagamento(Date dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public Date getDataVencimento() {
        return this.dataVencimento;
    }

    public void setDataVencimento(Date dataVencimento) {
        this.dataVencimento = dataVencimento;
    }
    

    
}
package br.com.rodolfo.loja.resources.exceptions;

import java.io.Serializable;

/**
 * StandardError
 */
public class StandardError implements Serializable{

    private static final long serialVersionUID = 1L;
    
    private Integer status;
    private String msg;
    private Long timeStamp;


    public StandardError(Integer status, String msg, Long timeStamp) {
        
        super();
        this.status = status;
        this.msg = msg;
        this.timeStamp = timeStamp;
    }


    public Integer getStatus() {
        return this.status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMsg() {
        return this.msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Long getTimeStamp() {
        return this.timeStamp;
    }

    public void setTimeStamp(Long timeStamp) {
        this.timeStamp = timeStamp;
    }
    
    
}
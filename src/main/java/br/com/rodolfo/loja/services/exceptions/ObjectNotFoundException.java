package br.com.rodolfo.loja.services.exceptions;

/**
 * ObjectNotFoundException
 */
public class ObjectNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 585708198865543018L;

    public ObjectNotFoundException(String msg) {

        super(msg);
    }

    public ObjectNotFoundException(String msg, Throwable cause) {

        super(msg, cause);
    }
    
}
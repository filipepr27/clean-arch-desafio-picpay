package br.com.curso.core.exception;

public class TaxNumberException extends RuntimeException {

    private String code;

    public TaxNumberException(String code, String message)
    {
        super(message);
        this.code = code;
    }
}

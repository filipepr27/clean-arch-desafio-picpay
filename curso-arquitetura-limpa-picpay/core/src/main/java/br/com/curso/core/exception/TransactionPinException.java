package br.com.curso.core.exception;

public class TransactionPinException extends RuntimeException {

    private String code;

    public TransactionPinException(String message, String code)
    {
        super(message);
        this.code = code;
    }
}

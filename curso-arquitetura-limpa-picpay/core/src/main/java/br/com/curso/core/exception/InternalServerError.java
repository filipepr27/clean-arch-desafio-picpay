package br.com.curso.core.exception;

public class InternalServerError extends RuntimeException {
    private String code;

    public InternalServerError(String code, String message)
    {
        super(message);
        this.code = code;
    }
}

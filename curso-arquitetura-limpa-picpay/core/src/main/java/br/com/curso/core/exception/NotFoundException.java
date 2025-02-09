package br.com.curso.core.exception;

public class NotFoundException extends RuntimeException {

  private String code;

  public NotFoundException(String code, String message)
    {
      super(message);
      this.code = code;
    }
}

package br.com.curso.core.exception;

public class NotificationException extends RuntimeException {

  private String code;

  public NotificationException(String code, String message)
    {
      super(message);
      this.code = code;
    }
}

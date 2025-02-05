package br.com.curso.usecase;

public interface UserAuthenticateUseCase {
    Boolean authenticate(String userName, String password);
}

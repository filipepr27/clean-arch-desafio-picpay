package br.com.curso.usecase;

import br.com.curso.core.domain.User;

public interface CreateUserUseCase {

    void create(User user, String pin);
}

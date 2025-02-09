package br.com.curso.application.usecaseimpl;

import br.com.curso.application.gateway.EmailAvaliableGateway;
import br.com.curso.usecase.EmailAvailableUseCase;

public class EmailAvaliableUseCaseImpl implements EmailAvailableUseCase {

    private EmailAvaliableGateway emailAvaliableGateway;

    public EmailAvaliableUseCaseImpl(EmailAvaliableGateway emailAvaliableGateway) {
        this.emailAvaliableGateway = emailAvaliableGateway;
    }

    @Override
    public Boolean avaliable(String email) {
        return emailAvaliableGateway.emailAvaliable(email);
    }
}

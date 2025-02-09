package br.com.curso.application.usecaseimpl;

import br.com.curso.application.gateway.CreateUserGateway;
import br.com.curso.core.domain.TransactionPin;
import br.com.curso.core.domain.User;
import br.com.curso.core.domain.Wallet;
import br.com.curso.core.exception.EmailException;
import br.com.curso.core.exception.InternalServerError;
import br.com.curso.core.exception.TaxNumberException;
import br.com.curso.core.exception.enums.ErrorCodeEnum;
import br.com.curso.usecase.*;

import java.math.BigDecimal;

public class CreateUserUseCaseImpl implements CreateUserUseCase {

    private final TaxNumberAvailableUseCase taxNumberAvaliableUseCase;

    private final EmailAvailableUseCase emailAvaliableUseCase;

    private final CreateUserGateway createUserGateway;


    public CreateUserUseCaseImpl(TaxNumberAvailableUseCase taxNumberAvaliableUseCase, EmailAvailableUseCase emailAvaliableUseCase,
                                 CreateUserGateway createUserGateway) {
        this.taxNumberAvaliableUseCase = taxNumberAvaliableUseCase;
        this.emailAvaliableUseCase = emailAvaliableUseCase;
        this.createUserGateway = createUserGateway;
    }

    @Override
    public void create(User user, String pin) {
        if (!taxNumberAvaliableUseCase.avaliable(user.getTaxNumber().getValue())) {
            throw new TaxNumberException(ErrorCodeEnum.ON0002.getMessage(), ErrorCodeEnum.ON0002.getMessage());
        }

        if (!emailAvaliableUseCase.avaliable(user.getEmail())) {
            throw new EmailException(ErrorCodeEnum.ON0003.getMessage(), ErrorCodeEnum.ON0003.getMessage());
        }

        if (!createUserGateway.create(user, new Wallet(BigDecimal.ZERO, user), new TransactionPin(user, pin))) {
            throw new InternalServerError(ErrorCodeEnum.ON0004.getMessage(), ErrorCodeEnum.ON0004.getCode());
        }

    }
}

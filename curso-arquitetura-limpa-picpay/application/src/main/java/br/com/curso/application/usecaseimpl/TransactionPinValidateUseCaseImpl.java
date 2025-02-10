package br.com.curso.application.usecaseimpl;

import br.com.curso.application.gateway.TransactionPinValidateGateway;
import br.com.curso.core.domain.TransactionPin;
import br.com.curso.core.exception.PinException;
import br.com.curso.core.exception.TransactionPinException;
import br.com.curso.core.exception.enums.ErrorCodeEnum;
import br.com.curso.usecase.TransactionPinValidateUseCase;
import br.com.curso.usecase.UpdateTransactionPinUseCase;

public class TransactionPinValidateUseCaseImpl implements TransactionPinValidateUseCase {

    private final TransactionPinValidateGateway transactionPinValidateGateway;

    private final UpdateTransactionPinUseCase updateTransactionPinUseCase;

    public TransactionPinValidateUseCaseImpl(TransactionPinValidateGateway transactionPinValidateGateway, UpdateTransactionPinUseCase updateTransactionPinUseCase) {
        this.transactionPinValidateGateway = transactionPinValidateGateway;
        this.updateTransactionPinUseCase = updateTransactionPinUseCase;
    }

    @Override
    public Boolean validate(TransactionPin transactionPin) {
        if (transactionPin.getBlocked())
            throw new PinException(ErrorCodeEnum.PIN0001.getMessage(), ErrorCodeEnum.PIN0001.getCode());

        if (!transactionPinValidateGateway.validate(transactionPin)) {
            transactionPin.setAttempt();
            var transactionPinUpdate = updateTransactionPinUseCase.update(transactionPin);
            throw new PinException(ErrorCodeEnum.pin001GetMessage(transactionPinUpdate.getAttempt()), ErrorCodeEnum.PIN0002.getCode());
        } else {
            transactionPin.restoreAttempt();
            updateTransactionPinUseCase.update(transactionPin);
        }

        return true;
    }
}

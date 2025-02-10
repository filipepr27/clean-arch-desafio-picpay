package br.com.curso.usecase;

import br.com.curso.core.domain.TransactionPin;

public interface TransactionPinValidateUseCase {
    Boolean validate(TransactionPin transactionPin);
}

package br.com.curso.usecase;

import br.com.curso.core.domain.TransactionPin;

public interface UpdateTransactionPinUseCase {
    TransactionPin update(TransactionPin transactionPin);
}

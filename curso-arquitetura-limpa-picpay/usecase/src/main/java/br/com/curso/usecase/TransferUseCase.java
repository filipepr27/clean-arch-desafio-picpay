package br.com.curso.usecase;

import br.com.curso.core.domain.Transaction;

import java.math.BigDecimal;

public interface TransferUseCase {
    Boolean transfer(String fromTaxNumber, String toTaxNumber, BigDecimal value);
}

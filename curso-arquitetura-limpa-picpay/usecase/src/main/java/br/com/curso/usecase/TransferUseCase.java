package br.com.curso.usecase;

import java.math.BigDecimal;

public interface TransferUseCase {
    Boolean transfer(String fromTaxNumber, String toTaxNumber, BigDecimal value);
}

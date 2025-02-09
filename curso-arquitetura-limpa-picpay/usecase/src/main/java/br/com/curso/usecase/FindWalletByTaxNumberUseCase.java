package br.com.curso.usecase;

import br.com.curso.core.domain.Wallet;

public interface FindWalletByTaxNumberUseCase {
    Wallet findByTaxNumber(String taxNumber);
}

package br.com.curso.application.usecaseimpl;

import br.com.curso.application.gateway.FindWalletByTaxNumberGateway;
import br.com.curso.core.domain.Wallet;
import br.com.curso.core.exception.enums.ErrorCodeEnum;
import br.com.curso.core.exception.NotFoundException;
import br.com.curso.usecase.FindWalletByTaxNumberUseCase;

public class FindWalletByTaxNumberUseCaseImpl implements FindWalletByTaxNumberUseCase {

    private final FindWalletByTaxNumberGateway findWalletByTaxNumberGateway;

    public FindWalletByTaxNumberUseCaseImpl(FindWalletByTaxNumberGateway findWalletByTaxNumberGateway) {
        this.findWalletByTaxNumberGateway = findWalletByTaxNumberGateway;
    }

    @Override
    public Wallet findByTaxNumber(String taxNumber) {

        var wallet = findWalletByTaxNumberGateway.find(taxNumber);

        if (wallet == null) {
            throw new NotFoundException(ErrorCodeEnum.WA0001.getMessage(), ErrorCodeEnum.WA0001.getCode());
        }

        return null;
    }
}

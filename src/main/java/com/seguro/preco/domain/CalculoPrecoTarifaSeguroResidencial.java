package com.seguro.preco.domain;

import java.math.BigDecimal;

public class CalculoPrecoTarifaSeguroResidencial implements CalculoPrecoTarifa {
    private static final BigDecimal IOF = new BigDecimal("0.03");
    private static final BigDecimal PIS = new BigDecimal("0.00");
    private static final BigDecimal COFINS = new BigDecimal("0.04");

    @Override
    public BigDecimal calcular(BigDecimal precoBase) {
        return CalculadoraImpostoSeguro.calcular(precoBase, IOF, PIS, COFINS);
    }
}

package com.seguro.preco.domain;

import java.math.BigDecimal;

public class CalculoPrecoTarifaSeguroVida implements CalculoPrecoTarifa {
    private static final BigDecimal IOF = new BigDecimal("0.01");
    private static final BigDecimal PIS = new BigDecimal("0.022");
    private static final BigDecimal COFINS = new BigDecimal("0.00");

    @Override
    public final BigDecimal calcular(BigDecimal precoBase) {
        return CalculadoraImpostoSeguro.calcular(precoBase, IOF, PIS, COFINS);
    }
}

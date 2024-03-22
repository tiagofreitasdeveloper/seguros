package com.seguro.preco.domain;

import java.math.BigDecimal;

public class CalculoPrecoTarifaSeguroAuto implements CalculoPrecoTarifa {
    private static final BigDecimal IOF = new BigDecimal("0.055");
    private static final BigDecimal PIS = new BigDecimal("0.04");
    private static final BigDecimal COFINS = new BigDecimal("0.01");

    public BigDecimal calcular(BigDecimal precoBase) {
        return CalculadoraImpostoSeguro.calcular(precoBase, IOF, PIS, COFINS);
    }
}

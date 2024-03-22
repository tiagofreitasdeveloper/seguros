package com.seguro.preco.domain;

import java.math.BigDecimal;

public class CalculadoraImpostoSeguro {

    public static BigDecimal calcular(BigDecimal preco, BigDecimal iof, BigDecimal pis, BigDecimal cofins) {
        return preco.multiply(BigDecimal.ONE.add(iof).add(pis).add(cofins)).setScale(2, BigDecimal.ROUND_UP);
    }
}

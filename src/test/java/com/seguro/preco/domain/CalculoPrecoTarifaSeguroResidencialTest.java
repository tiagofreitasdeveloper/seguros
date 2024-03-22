package com.seguro.preco.domain;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculoPrecoTarifaSeguroResidencialTest {

    @Test
    public void dadoPrecoBaseResultadoDeveSerIgualEsperado() {
        var precoBase = new BigDecimal("100.00");
        var precoEsperado = new BigDecimal("107.00");

        var precoTarifado = new CalculoPrecoTarifaSeguroResidencial().calcular(precoBase);
        assertThat(precoTarifado).isEqualTo(precoEsperado);
    }
}


package com.seguro.preco.domain;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculoPrecoTarifaSeguroAutoTest {

    @Test
    public void dadoPrecoBaseResultadoDeveSerIgualEsperado() {
        var precoBase = new BigDecimal("50.00");
        var precoEsperado = new BigDecimal("55.25");

        var precoTarifado = new CalculoPrecoTarifaSeguroAuto().calcular(precoBase);
        assertThat(precoTarifado).isEqualTo(precoEsperado);
    }
}


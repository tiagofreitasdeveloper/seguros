package com.seguro.preco.domain;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculoPrecoTarifaSeguroVidaTest {

    @Test
    public void dadoPrecoBaseResultadoDeveSerIgualEsperado() {
        var precoBase = new BigDecimal("100.00");
        var precoEsperado = new BigDecimal("103.20");

        var precoTarifado = new CalculoPrecoTarifaSeguroVida().calcular(precoBase);
        assertThat(precoTarifado).isEqualTo(precoEsperado);
    }
}


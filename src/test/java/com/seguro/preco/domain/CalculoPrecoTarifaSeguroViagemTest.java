package com.seguro.preco.domain;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculoPrecoTarifaSeguroViagemTest {

    @Test
    public void dadoPrecoBaseResultadoDeveSerIgualEsperado() {
        var precoBase = new BigDecimal("80.00");
        var precoEsperado = new BigDecimal("85.60");

        var precoTarifado = new CalculoPrecoTarifaSeguroViagem().calcular(precoBase);
        assertThat(precoTarifado).isEqualTo(precoEsperado);
    }
}


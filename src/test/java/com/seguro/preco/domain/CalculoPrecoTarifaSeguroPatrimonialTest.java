package com.seguro.preco.domain;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculoPrecoTarifaSeguroPatrimonialTest {

    @Test
    public void dadoPrecoBaseResultadoDeveSerIgualEsperado() {
        var precoBase = new BigDecimal("50.00");
        var precoEsperado = new BigDecimal("54.00");

        var precoTarifado = new CalculoPrecoTarifaSeguroPatrimonial().calcular(precoBase);
        assertThat(precoTarifado).isEqualTo(precoEsperado);
    }
}


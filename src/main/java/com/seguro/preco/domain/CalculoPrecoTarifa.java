package com.seguro.preco.domain;

import java.math.BigDecimal;

public interface CalculoPrecoTarifa {

    BigDecimal calcular(BigDecimal precoBase);
}

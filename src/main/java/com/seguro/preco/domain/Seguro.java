package com.seguro.preco.domain;

import lombok.Builder;
import lombok.Value;

import java.math.BigDecimal;

@Value
@Builder(toBuilder = true)
public class Seguro {
    String id;
    String nome;
    String categoria;
    BigDecimal precoBase;
    BigDecimal precoTarifa;
}

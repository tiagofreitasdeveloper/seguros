package com.seguro.preco.adapter.controller.model;

import lombok.Builder;
import lombok.Value;

import java.math.BigDecimal;

@Value
@Builder
public class SeguroResponse {
    String id;
    String nome;
    String categoria;
    BigDecimal precoBase;
    BigDecimal precoTarifado;
}

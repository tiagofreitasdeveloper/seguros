package com.seguro.preco.adapter.controller.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Value;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Value
@Builder
public class SeguroRequest {

    @JsonProperty("id")
    String id;

    @JsonProperty("name")
    String nome;

    @NotNull(message = "O campo categoria é obrigatório")
    @JsonProperty("categoria")
    String categoria;

    @NotNull(message = "O campo preçoBase é obrigatório")
    @JsonProperty("preco_base")
    BigDecimal precoBase;
}

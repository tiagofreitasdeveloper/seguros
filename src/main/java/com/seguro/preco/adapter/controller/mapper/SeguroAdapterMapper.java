package com.seguro.preco.adapter.controller.mapper;

import com.seguro.preco.adapter.controller.model.SeguroRequest;
import com.seguro.preco.adapter.controller.model.SeguroResponse;
import com.seguro.preco.domain.Seguro;

public class SeguroAdapterMapper {

    public static Seguro toDomain(SeguroRequest seguroRequest) {
        return Seguro.builder()
                .id(seguroRequest.getId())
                .nome(seguroRequest.getNome())
                .categoria(seguroRequest.getCategoria())
                .precoBase(seguroRequest.getPrecoBase())
                .build();
    }

    public static SeguroResponse toResponse(Seguro seguro) {
        return SeguroResponse.builder()
                .id(seguro.getId())
                .nome(seguro.getNome())
                .categoria(seguro.getCategoria())
                .precoBase(seguro.getPrecoBase())
                .precoTarifado(seguro.getPrecoTarifa())
                .build();
    }
}

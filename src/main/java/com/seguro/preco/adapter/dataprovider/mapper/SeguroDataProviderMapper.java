package com.seguro.preco.adapter.dataprovider.mapper;

import com.seguro.preco.adapter.dataprovider.entity.SeguroEntity;
import com.seguro.preco.domain.Seguro;

public class SeguroDataProviderMapper {

    public static SeguroEntity toEntity(Seguro seguro) {
        return SeguroEntity.builder()
                .id(seguro.getId())
                .nome(seguro.getNome())
                .categoria(seguro.getCategoria())
                .precoBase(seguro.getPrecoBase())
                .precoTarifado(seguro.getPrecoTarifa())
                .build();
    }

    public static Seguro toDomain(SeguroEntity seguroEntity) {
        return Seguro.builder()
                .id(seguroEntity.getId())
                .nome(seguroEntity.getNome())
                .categoria(seguroEntity.getCategoria())
                .precoBase(seguroEntity.getPrecoBase())
                .precoTarifa(seguroEntity.getPrecoTarifado())
                .build();
    }
}

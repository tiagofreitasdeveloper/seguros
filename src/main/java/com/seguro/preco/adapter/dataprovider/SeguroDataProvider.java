package com.seguro.preco.adapter.dataprovider;

import com.seguro.preco.domain.Seguro;
import com.seguro.preco.usecase.port.AtualizarSeguroPort;
import com.seguro.preco.usecase.port.SalvarSeguroPort;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

import static com.seguro.preco.adapter.dataprovider.mapper.SeguroDataProviderMapper.toDomain;
import static com.seguro.preco.adapter.dataprovider.mapper.SeguroDataProviderMapper.toEntity;

@Component
@RequiredArgsConstructor
public class SeguroDataProvider implements SalvarSeguroPort, AtualizarSeguroPort {

    private final SeguroRepository seguroRepository;

    public Seguro salvar(Seguro seguro) {
        return toDomain(seguroRepository.save(
                toEntity(seguro)
                        .toBuilder()
                        .id(UUID.randomUUID().toString())
                        .build()));
    }

    @Transactional
    public Seguro atualizar(Seguro seguro) {
        var entity = seguroRepository.findById(seguro.getId())
                .orElseThrow(EntityNotFoundException::new);
        entity.setPrecoBase(seguro.getPrecoBase());
        entity.setPrecoTarifado(seguro.getPrecoTarifa());

        return toDomain(entity);
    }
}

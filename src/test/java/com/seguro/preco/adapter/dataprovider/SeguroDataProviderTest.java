package com.seguro.preco.adapter.dataprovider;

import com.seguro.preco.adapter.dataprovider.entity.SeguroEntity;
import com.seguro.preco.domain.Seguro;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.Optional;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class SeguroDataProviderTest {

    @Mock
    private SeguroRepository seguroRepository;

    @InjectMocks
    private SeguroDataProvider seguroDataProvider;

    @Test
    public void dadoUmNovoSeguroVerificarSeRepositorySalvarFoiChamado() {
        var entity = SeguroEntity.builder().build();
        when(seguroRepository.save(any())).thenReturn(entity);

        seguroDataProvider.salvar(Seguro.builder()
                .nome("VIDA")
                .precoTarifa(BigDecimal.TEN)
                .precoTarifa(new BigDecimal("11.55"))
                .build());
        verify(seguroRepository).save(any());
    }

    @Test
    public void dadoUmNovoSeguroVerificarSeRepositoryFindByIdFoiChamado() {
        var entity = SeguroEntity.builder().build();
        when(seguroRepository.findById(any())).thenReturn(Optional.of(entity));

        seguroDataProvider.atualizar(Seguro.builder()
                .nome("VIDA")
                .precoTarifa(BigDecimal.TEN)
                .precoTarifa(new BigDecimal("11.55"))
                .build());
        verify(seguroRepository).findById(any());
    }
}

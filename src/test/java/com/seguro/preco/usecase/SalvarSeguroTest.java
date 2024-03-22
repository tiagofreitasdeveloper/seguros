package com.seguro.preco.usecase;

import com.seguro.preco.domain.CalculoPrecoTarifaSeguroVida;
import com.seguro.preco.domain.Seguro;
import com.seguro.preco.usecase.port.SalvarSeguroPort;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;

@ExtendWith(MockitoExtension.class)
public class SalvarSeguroTest {
    
    @Mock
    private SalvarSeguroPort salvarSeguroPort;

    @Mock
    private FabricaCalculoPrecoTarifa fabricaCalculoPrecoTarifa;
    
    @InjectMocks
    private SalvarSeguro salvarSeguro;

    @Test
    public void dadoUmSeguroOMetodoSalvarDoPortDeveSerChamado() {
        Mockito.when(salvarSeguroPort.salvar(Mockito.any())).thenReturn(Seguro.builder().build());
        Mockito.when(fabricaCalculoPrecoTarifa.obterCalculoPorCategoria(Mockito.any())).thenReturn(
                new CalculoPrecoTarifaSeguroVida());

        salvarSeguro.salvar(Seguro.builder()
                .nome("VIDA")
                .precoBase(BigDecimal.TEN)
                .precoTarifa(new BigDecimal("11.55"))
                .build());

        Mockito.verify(salvarSeguroPort).salvar(Mockito.any());
        Mockito.verify(fabricaCalculoPrecoTarifa).obterCalculoPorCategoria(Mockito.any());
    }
}

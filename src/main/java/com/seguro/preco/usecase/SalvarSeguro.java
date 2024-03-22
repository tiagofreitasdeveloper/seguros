package com.seguro.preco.usecase;

import com.seguro.preco.domain.Seguro;
import com.seguro.preco.usecase.port.SalvarSeguroPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SalvarSeguro {
    private final FabricaCalculoPrecoTarifa fabricaCalculoPrecoTarifa;
    private final SalvarSeguroPort salvarSeguroPort;

    public Seguro salvar(Seguro seguro) {
        var calculoPrecoTarifaSeguro =
                fabricaCalculoPrecoTarifa.obterCalculoPorCategoria(seguro.getCategoria());
        var precoTarifaCalculado = calculoPrecoTarifaSeguro.calcular(seguro.getPrecoBase());

        return salvarSeguroPort.salvar(seguro.toBuilder()
                .precoTarifa(precoTarifaCalculado)
                .build());
    }
}

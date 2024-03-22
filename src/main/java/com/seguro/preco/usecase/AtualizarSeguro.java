package com.seguro.preco.usecase;

import com.seguro.preco.domain.Seguro;
import com.seguro.preco.usecase.port.AtualizarSeguroPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AtualizarSeguro {
    private final FabricaCalculoPrecoTarifa fabricaCalculoPrecoTarifa;
    private final AtualizarSeguroPort atualizarSeguroPort;

    public Seguro atualizar(Seguro seguro) {
        var calculoPrecoTarifaSeguro = fabricaCalculoPrecoTarifa.getCalculoPorCategoria(seguro.getCategoria());
        var precoTarifaCalculado = calculoPrecoTarifaSeguro.calcular(seguro.getPrecoBase());

        return atualizarSeguroPort.atualizar(seguro.toBuilder()
                .precoTarifa(precoTarifaCalculado)
                .build());
    }
}

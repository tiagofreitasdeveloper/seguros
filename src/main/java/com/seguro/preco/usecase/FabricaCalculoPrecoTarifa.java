package com.seguro.preco.usecase;

import com.seguro.preco.domain.*;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.NoSuchElementException;
import java.util.function.Supplier;

@Component
public class FabricaCalculoPrecoTarifa {

    private final Map<String, Supplier<CalculoPrecoTarifa>> calculosPrecoTarifa =
            Map.of("VIDA", CalculoPrecoTarifaSeguroVida::new,
                    "AUTO", CalculoPrecoTarifaSeguroAuto::new,
                    "VIAGEM", CalculoPrecoTarifaSeguroViagem::new,
                    "RESIDENCIAL", CalculoPrecoTarifaSeguroResidencial::new,
                    "PATRIMONIAL", CalculoPrecoTarifaSeguroPatrimonial::new);

    public CalculoPrecoTarifa getCalculoPorCategoria(String categoria) {
        var calculoPrecoTarifa = calculosPrecoTarifa.get(categoria);
        if (calculoPrecoTarifa == null) {
            throw new NoSuchElementException("Categoria de seguro não encontrada: " + categoria);
        }
        return calculoPrecoTarifa.get();
    }
}

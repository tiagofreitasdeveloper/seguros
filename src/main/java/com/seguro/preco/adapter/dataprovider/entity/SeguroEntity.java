package com.seguro.preco.adapter.dataprovider.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "seguro")
public class SeguroEntity {
    @Id
    private String id;
    private String nome;
    private String categoria;
    private BigDecimal precoBase;
    private BigDecimal precoTarifado;
}

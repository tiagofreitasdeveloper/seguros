package com.seguro.preco.adapter.dataprovider;

import com.seguro.preco.adapter.dataprovider.entity.SeguroEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeguroRepository extends JpaRepository<SeguroEntity, String> {
}

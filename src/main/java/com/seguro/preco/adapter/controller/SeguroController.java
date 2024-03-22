package com.seguro.preco.adapter.controller;

import com.seguro.preco.adapter.controller.mapper.SeguroAdapterMapper;
import com.seguro.preco.adapter.controller.model.SeguroRequest;
import com.seguro.preco.adapter.controller.model.SeguroResponse;
import com.seguro.preco.usecase.AtualizarSeguro;
import com.seguro.preco.usecase.SalvarSeguro;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static com.seguro.preco.adapter.controller.mapper.SeguroAdapterMapper.*;

@RestController
@RequestMapping("/seguros")
@RequiredArgsConstructor
public class SeguroController {

    private final SalvarSeguro salvarSeguro;
    private final AtualizarSeguro atualizarSeguro;

    @PostMapping
    public ResponseEntity<SeguroResponse> salvar(@Valid @RequestBody SeguroRequest seguroRequest) {
        var seguro = toDomain(seguroRequest);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(toResponse(salvarSeguro.salvar(seguro)));
    }

    @PatchMapping
    public ResponseEntity<SeguroResponse> atualizar(@RequestBody SeguroRequest seguroRequest) {
        var seguro = toDomain(seguroRequest);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(toResponse(atualizarSeguro.atualizar(seguro)));
    }
}

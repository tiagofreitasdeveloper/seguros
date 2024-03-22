package com.seguro.preco.adapter.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.seguro.preco.adapter.controller.model.SeguroRequest;
import com.seguro.preco.adapter.dataprovider.SeguroDataProvider;
import com.seguro.preco.domain.Seguro;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.math.BigDecimal;

import static org.mockito.Mockito.*;

@SpringBootTest
@AutoConfigureMockMvc
public class SeguroControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private SeguroDataProvider seguroDataProvider;

    @Test
    public void salvarSeguro() throws Exception {
        var seguro = SeguroRequest.builder()
                .id("1")
                .categoria("VIDA")
                .precoBase(new BigDecimal("100.00"))
                .build();
        when(seguroDataProvider.salvar(any())).thenReturn(Seguro.builder().build());
        mockMvc.perform(MockMvcRequestBuilders.post("/seguros")
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsBytes(seguro)))
                .andExpect(MockMvcResultMatchers.status().isCreated());
    }

   @Test
    public void atualizarSeguro() throws Exception {
        var seguro = SeguroRequest.builder()
                .id("1")
                .categoria("VIDA")
                .precoBase(new BigDecimal("101.00"))
                .build();
       when(seguroDataProvider.atualizar(any())).thenReturn(Seguro.builder().build());
        mockMvc.perform(MockMvcRequestBuilders.patch("/seguros")
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsBytes(seguro)))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}

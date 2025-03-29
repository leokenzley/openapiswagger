package com.leokenzley.openapiswagger.entrypoints.web.handler.model;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ErrorAPITest {

    @Test
    public void testErrorAPI() {
        // Cria uma instância de ErrorAPI
        ErrorAPI errorAPI = new ErrorAPI();

        // Define os valores dos campos
        String title = "Erro de Validação";
        Integer httpStatus = 400;
        List<String> erros = List.of("Campo obrigatório", "Formato inválido");

        errorAPI.setTitle(title);
        errorAPI.setHttpStatus(httpStatus);
        errorAPI.setErros(erros);

        // Verifica se os getters estão retornando os valores corretos
        assertEquals(title, errorAPI.getTitle());
        assertEquals(httpStatus, errorAPI.getHttpStatus());
        assertEquals(erros, errorAPI.getErros());

        // Verifica se a instância não é nula
        assertNotNull(errorAPI);
    }
}
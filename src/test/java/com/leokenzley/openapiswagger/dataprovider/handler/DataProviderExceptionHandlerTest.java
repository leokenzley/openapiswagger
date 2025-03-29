package com.leokenzley.openapiswagger.dataprovider.handler;

import com.leokenzley.openapiswagger.dataprovider.handler.exception.DataProviderNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.WebRequest;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DataProviderExceptionHandlerTest {

    private DataProviderExceptionHandler exceptionHandler;
    private WebRequest webRequest;

    @BeforeEach
    public void setUp() {
        exceptionHandler = new DataProviderExceptionHandler();
        webRequest = Mockito.mock(WebRequest.class);
    }

    @Test
    public void testHandleGenericNotFoundException() {
        String errorMessage = "Data provider not found";
        DataProviderNotFoundException exception = new DataProviderNotFoundException(errorMessage);

        ResponseEntity<ProblemDetail> response = exceptionHandler.handleGenericNotFoundException(exception, webRequest);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertEquals(errorMessage, response.getBody().getDetail());
    }
}
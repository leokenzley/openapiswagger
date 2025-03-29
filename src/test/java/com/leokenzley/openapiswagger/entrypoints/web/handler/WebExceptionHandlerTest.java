package com.leokenzley.openapiswagger.entrypoints.web.handler;

import com.leokenzley.openapiswagger.entrypoints.web.handler.model.ErrorAPI;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;

import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

public class WebExceptionHandlerTest {

  private WebExceptionHandler webExceptionHandler;

  @BeforeEach
  public void setUp() {
    webExceptionHandler = new WebExceptionHandler();
  }

  @Test
  public void testHandleValidationException() {
    BindingResult bindingResult = new BindException(new Object(), "objectName");
    FieldError fieldError = new FieldError("objectName", "field", "defaultMessage");
    bindingResult.addError(fieldError);
    MethodArgumentNotValidException ex = new MethodArgumentNotValidException(null, bindingResult);

    ResponseEntity<Map<String, String>> response = webExceptionHandler.handleValidationException(ex);

    assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
    assertEquals("defaultMessage", response.getBody().get("field"));
  }

  @Test
  public void testHandleConstraintViolationException() {
    ConstraintViolation<?> violation = mock(ConstraintViolation.class);
    Mockito.when(violation.getMessage()).thenReturn("violation message");
    ConstraintViolationException ex = new ConstraintViolationException(Set.of(violation));

    ResponseEntity<ErrorAPI> response = webExceptionHandler.handleConstraintViolationException(ex);

    assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
    assertEquals("Erro de Validação", response.getBody().getTitle());
    assertEquals(List.of("violation message"), response.getBody().getErros());
  }

  @Test
  public void testHandleGenericException() {
    Exception ex = new Exception("Generic error");

    ResponseEntity<String> response = webExceptionHandler.handleGenericException(ex);

    assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
    assertEquals("Ocorreu um erro inesperado. Tente novamente mais tarde.", response.getBody());
  }
}
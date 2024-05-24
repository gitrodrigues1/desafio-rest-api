package br.com.marcos.desafiorestapi.exceptions;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(BusinessException.CustomerAlreadyExistsException.class)
    public ResponseEntity<DefaultMessage> handleCustomerAlreadyExistsException(BusinessException.CustomerAlreadyExistsException ex) {
        return ResponseEntity.status(500).body(new DefaultMessage(
                LocalDateTime.now(),
                500,
                ex.getMessage()));
    }

    @ExceptionHandler(BusinessException.CustomerNotFoundException.class)
    public ResponseEntity<DefaultMessage> handleCustomerNotFoundException(BusinessException.CustomerNotFoundException ex) {
        return ResponseEntity.status(404).body(new DefaultMessage(
                LocalDateTime.now(),
                404,
                ex.getMessage()
        ));
    }

    @ExceptionHandler(BusinessException.CityNotFoundException.class)
    public ResponseEntity<DefaultMessage> handleCityNotFoundException(BusinessException.CityNotFoundException ex) {
        return ResponseEntity.status(404).body(new DefaultMessage(
                LocalDateTime.now(),
                404,
                ex.getMessage()
        ));
    }

    @ExceptionHandler(BusinessException.CityAlreadyExistsException.class)
    public ResponseEntity<DefaultMessage> handleCityAlreadyExistsException(BusinessException.CityAlreadyExistsException ex) {
        return ResponseEntity.status(400).body(new DefaultMessage(
                LocalDateTime.now(),
                400,
                ex.getMessage()));
    }

    @ExceptionHandler(BusinessException.InvalidCityIdException.class)
    public ResponseEntity<DefaultMessage> handleInvalidCityIdException(BusinessException.InvalidCityIdException ex) {
        return ResponseEntity.status(404).body(new DefaultMessage(
                LocalDateTime.now(),
                404,
                ex.getMessage()));
    }

    @ExceptionHandler(BusinessException.InvalidStateException.class)
    public ResponseEntity<DefaultMessage> handleInvalidStateException(BusinessException.InvalidStateException ex) {
        return ResponseEntity.status(404).body(new DefaultMessage(
                LocalDateTime.now(),
                404,
                ex.getMessage()));
    }

    @ExceptionHandler(BusinessException.InvalidYearOrAgeException.class)
    public ResponseEntity<DefaultMessage> handleInvalidYearOrAgeException(BusinessException.InvalidYearOrAgeException ex) {
        return ResponseEntity.status(404).body(new DefaultMessage(
                LocalDateTime.now(),
                404,
                ex.getMessage()));
    }

}



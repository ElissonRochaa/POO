package br.org.upe.eventhub.config;

import br.org.upe.eventhub.exceptions.UsuarioExistenteException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class RestExceptionHandle {

    @ExceptionHandler(UsuarioExistenteException.class)
    public ResponseEntity<String> usuarioExistente(UsuarioExistenteException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }

}

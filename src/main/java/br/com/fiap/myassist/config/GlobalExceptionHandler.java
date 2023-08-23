package br.com.fiap.myassist.config;

import br.com.fiap.myassist.dto.ErroDTO;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(RuntimeException.class)
    public ErroDTO handleRuntimeException(RuntimeException ex) {
        return ErroDTO.builder().dateTime(LocalDateTime.now())
                                .error(ex.getMessage())
                                .status(HttpStatus.BAD_REQUEST.value())
                      .build();
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ErroDTO handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        Map<String, String> resultado = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach(e -> {
            var nomeCampo = ((FieldError) e).getField();
            var mensagem = e.getDefaultMessage();
            resultado.put(nomeCampo, mensagem);
        });
        return ErroDTO.builder().dateTime(LocalDateTime.now())
                                .error(HttpStatus.BAD_REQUEST.getReasonPhrase())
                                .status(HttpStatus.BAD_REQUEST.value())
                                .violations(resultado)
                      .build();
    }

}

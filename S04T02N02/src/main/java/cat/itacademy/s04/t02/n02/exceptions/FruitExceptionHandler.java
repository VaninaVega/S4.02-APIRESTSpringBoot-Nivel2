package cat.itacademy.s04.t02.n02.exceptions;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.HashMap;
import java.util.Map;

    @RestControllerAdvice
    public class FruitExceptionHandler extends ResponseEntityExceptionHandler {
        @ExceptionHandler({
                FruitNotFoundException.class
        })
        ResponseEntity<Object> handleNotFound(FruitNotFoundException e, WebRequest request) {
            Map<String, String> body = new HashMap<>();
            body.put("message", e.getMessage());
            return super.handleExceptionInternal(e, body, new HttpHeaders(), HttpStatus.NOT_FOUND, request);
        }
        @ExceptionHandler({
                FruitDoesNotExistException.class
        })
        ResponseEntity<Object> handleNotFound(FruitDoesNotExistException e, WebRequest request) {
            Map<String, String> body = new HashMap<>();
            body.put("message", e.getMessage());
            return super.handleExceptionInternal(e, body, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
        }

    }

package io.github.lsmcodes.gof.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.server.ServerErrorException;

import io.github.lsmcodes.gof.dto.response.Response;

@ControllerAdvice
public class GofApplicationExceptionHandler<T> {
        
        @ExceptionHandler(value = { ClientNotFoundException.class })
        public ResponseEntity<Response<T>> handleClientNotFoundException(ClientNotFoundException exception) {
                Response<T> response = new Response<>();
                response.addErrorsToResponse(404, exception.getLocalizedMessage());

                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }

        @ExceptionHandler(value = { ServerErrorException.class })
        public ResponseEntity<Response<T>> handleServerErrorException(ServerErrorException exception) {
                Response<T> response = new Response<>();
                response.addErrorsToResponse(500, exception.getMessage());

                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }

        @ExceptionHandler(value = { ResponseStatusException.class })
        public ResponseEntity<Response<T>> handleResponseStatusException(ResponseStatusException exception) {
                Response<T> response = new Response<>();
                response.addErrorsToResponse(exception.getStatusCode().value(), exception.getReason());

                return ResponseEntity.status(exception.getStatusCode()).body(response);
        }

}
package br.com.fiap.hospital.notificacao.infra.adapter.outbound.exception;


import net.devh.boot.grpc.server.advice.GrpcAdvice;
import net.devh.boot.grpc.server.advice.GrpcExceptionHandler;
import org.hibernate.sql.exec.ExecutionException;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.WebRequest;

import java.sql.SQLException;

@GrpcAdvice
public class GlobalExceptionHandle {
    @GrpcExceptionHandler(value = {ChangeSetPersister.NotFoundException.class})
    protected ResponseEntity<Object> handleNotFound(RuntimeException e, WebRequest request) {
        var response = new ResponseException(
                ChangeSetPersister.NotFoundException.class.getTypeName(),
                HttpStatus.NOT_FOUND.getReasonPhrase(),
                HttpStatus.NOT_FOUND.value(),
                e.getMessage(),
                HttpHeaders.SERVER
        );
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @GrpcExceptionHandler(value = {IllegalArgumentException.class})
    protected ResponseEntity<Object> handleIllegalArgument(RuntimeException e, WebRequest request) {
        var response = new ResponseException(
                ChangeSetPersister.NotFoundException.class.getTypeName(),
                HttpStatus.NOT_FOUND.getReasonPhrase(),
                HttpStatus.NOT_FOUND.value(),
                e.getMessage(),
                HttpHeaders.SERVER
        );
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @GrpcExceptionHandler(value = {NullPointerException.class})
    protected ResponseEntity<Object> handleNullPoint(RuntimeException e, WebRequest request) {
        var response = new ResponseException(
                NullPointerException.class.getTypeName(),
                HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(),
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                e.getMessage().replaceAll("\\\".*?\\\"", ""),
                request.getDescription(true).split(";")[0].replace("uri=", "")
        );
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GrpcExceptionHandler(value = {SQLException.class})
    protected ResponseEntity<Object> handleSQLException(RuntimeException e, WebRequest request) {
        var response = new ResponseException(
                ExecutionException.class.getTypeName(),
                HttpStatus.BAD_REQUEST.getReasonPhrase(),
                HttpStatus.BAD_REQUEST.value(),
                "Request Not Accept",
                request.getDescription(true).split(";")[0].replace("uri=", "")
        );
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}

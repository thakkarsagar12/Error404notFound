package com.example.demo.util.exceptions;

import com.example.demo.util.dto.ApiError;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
    private Logger log = LoggerFactory.getLogger(getClass());

    public RestResponseEntityExceptionHandler() {
        super();
    }


    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable
            (
            HttpMessageNotReadableException ex,
            HttpHeaders headers,
            HttpStatus status,
            WebRequest request
            )
    {
//        return handleExceptionInternal(ex,"There was a problem", headers, HttpStatus.BAD_REQUEST,request);
//        or
        return handleExceptionInternal(ex, message(HttpStatus.BAD_REQUEST, ex), headers, HttpStatus.BAD_REQUEST,request);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        return handleExceptionInternal(ex, message(HttpStatus.BAD_REQUEST, ex), headers, HttpStatus.BAD_REQUEST,request);
    }

    private ApiError message(final HttpStatus status, final  Exception ex) {
        final String message = ex.getMessage() == null ? ex.getClass().getSimpleName() : ex.getMessage();
        final String devMessage = ex.getClass().getSimpleName();
//        or for devMessage we can do both
//        final String devMessage = ex.toString();
        return new ApiError(status.value(), message, devMessage);
    }
}

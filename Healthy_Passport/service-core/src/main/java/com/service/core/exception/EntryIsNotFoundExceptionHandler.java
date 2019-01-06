package com.service.core.exception;

import com.api.response.GeneralErrorResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.util.WebUtils;

/**
 * Created by Aleksandr Borodavka 03.01.2019
 *
 * */

@ControllerAdvice
public class EntryIsNotFoundExceptionHandler {

    @ExceptionHandler(value = EntryIsNotFoundException.class)
    public ResponseEntity<Object> handleException(EntryIsNotFoundException ex, WebRequest request){
        return handleServerException(ex, new GeneralErrorResponse(
                500L, ex.getCode().toString(), ex.getMessage()), request);
    }

    private ResponseEntity<Object> handleServerException(Exception ex, Object object, WebRequest request){
        request.setAttribute(WebUtils.ERROR_EXCEPTION_ATTRIBUTE, ex, WebRequest.SCOPE_REQUEST);
        return new ResponseEntity<Object>(object, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}

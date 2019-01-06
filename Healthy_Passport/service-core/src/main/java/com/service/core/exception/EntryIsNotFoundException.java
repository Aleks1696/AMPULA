package com.service.core.exception;

/**
 * Created by Aleksandr Borodavka 03.01.2019
 *
 * */

public class EntryIsNotFoundException extends RuntimeException {

    private Long code;

    public EntryIsNotFoundException(Long code, String message) {
        super(message);
        this.code = code;
    }

    public Long getCode() {
        return code;
    }

}

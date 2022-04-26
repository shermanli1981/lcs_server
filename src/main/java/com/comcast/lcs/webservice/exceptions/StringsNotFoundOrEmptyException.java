package com.comcast.lcs.webservice.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class StringsNotFoundOrEmptyException extends RuntimeException {
    public StringsNotFoundOrEmptyException(String message) {
        super(message);
    }
}

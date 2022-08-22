package com.horaoen.sailor.autoconfigure.exception;

import com.horaoen.sailor.autoconfigure.bean.Code;
import org.springframework.http.HttpStatus;

/**
 * @author horaoen
 */
public class NotFoundException extends HttpException{
    public NotFoundException() {
        super(Code.NOT_FOUND.getDescription(), Code.NOT_FOUND.getCode(), HttpStatus.NOT_FOUND.value());
    }

    public NotFoundException(String message) {
        super(message, Code.NOT_FOUND.getCode(), HttpStatus.NOT_FOUND.value());
    }

    public NotFoundException(int code) {
        super(Code.NOT_FOUND.getDescription(), code, HttpStatus.NOT_FOUND.value());
    }

    public NotFoundException(String message, int code) {
        super(message, code, HttpStatus.NOT_FOUND.value());
    }
    public NotFoundException(String message, int code, int httpCode) {
        super(message, code, httpCode);
    }
}

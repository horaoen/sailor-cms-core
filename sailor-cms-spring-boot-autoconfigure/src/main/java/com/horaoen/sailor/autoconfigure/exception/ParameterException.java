package com.horaoen.sailor.autoconfigure.exception;

import com.horaoen.sailor.autoconfigure.bean.Code;
import org.springframework.http.HttpStatus;

import java.util.HashMap;
import java.util.Map;

/**
 * @author horaoen
 */
public class ParameterException extends HttpException {
    protected int httpCode;
    protected int code;
    private Map<String, Object> errors;

    public ParameterException() {
        super(Code.PARAMETER_ERROR.getDescription(), Code.PARAMETER_ERROR.getCode());
        this.httpCode = HttpStatus.BAD_REQUEST.value();
        this.code = Code.PARAMETER_ERROR.getCode();
        this.errors = new HashMap();
    }

    public ParameterException(String message) {
        super(message);
        this.httpCode = HttpStatus.BAD_REQUEST.value();
        this.code = Code.PARAMETER_ERROR.getCode();
        this.errors = new HashMap();
    }

    public ParameterException(String message, int code) {
        super(message, code);
        this.httpCode = HttpStatus.BAD_REQUEST.value();
        this.code = Code.PARAMETER_ERROR.getCode();
        this.errors = new HashMap();
        this.code = code;
    }

    public ParameterException(int code) {
        super(Code.PARAMETER_ERROR.getDescription(), code);
        this.httpCode = HttpStatus.BAD_REQUEST.value();
        this.code = Code.PARAMETER_ERROR.getCode();
        this.errors = new HashMap();
        this.code = code;
    }

    public ParameterException(Map<String, Object> errors) {
        this.httpCode = HttpStatus.BAD_REQUEST.value();
        this.code = Code.PARAMETER_ERROR.getCode();
        this.errors = new HashMap();
        this.errors = errors;
    }

    public ParameterException addError(String key, Object val) {
        this.errors.put(key, val);
        return this;
    }

    public String getMessage() {
        return this.errors.isEmpty() ? super.getMessage() : this.errors.toString();
    }

    public int getHttpCode() {
        return this.httpCode;
    }

    public int getCode() {
        return this.code;
    }
}

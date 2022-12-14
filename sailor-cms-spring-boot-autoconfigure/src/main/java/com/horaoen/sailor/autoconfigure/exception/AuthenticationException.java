package com.horaoen.sailor.autoconfigure.exception;

import com.horaoen.sailor.autoconfigure.bean.Code;
import org.springframework.http.HttpStatus;

/**
 * 授权异常
 *
 * @author pedro@TaleLin
 * @author Juzi@TaleLin
 * @author colorful@TaleLin
 */
public class AuthenticationException extends HttpException {

    private static final long serialVersionUID = -222891683232481602L;

    protected int httpCode = HttpStatus.UNAUTHORIZED.value();

    protected int code = Code.UN_AUTHENTICATION.getCode();

    /**
     * 是否是默认消息
     * true： 没有通过构造函数传入 message
     * false：通过构造函数传入了 message
     *
     * 没有用 isDefaultMessage 是因为和部分 rpc 框架存在兼容问题
     */
    protected boolean ifDefaultMessage = true;

    public AuthenticationException() {
        super(Code.UN_AUTHENTICATION.getCode(), Code.UN_AUTHENTICATION.getDescription());
        super.ifDefaultMessage = true;
    }

    public AuthenticationException(String message) {
        super(message);
    }

    public AuthenticationException(int code) {
        super(code, Code.UN_AUTHENTICATION.getDescription());
        this.code = code;
        super.ifDefaultMessage = true;
    }

    @Deprecated
    public AuthenticationException(String message, int code) {
        super(code, message);
        this.code = code;
    }

    public AuthenticationException(int code, String message) {
        super(code, message);
        this.code = code;
    }

    @Override
    public int getHttpCode() {
        return httpCode;
    }

    @Override
    public int getCode() {
        return code;
    }
}

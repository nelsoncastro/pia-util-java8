package com.programmerinaction.util.exception;

/**
 * Essa classe representa um exceção de negócio.
 *
 * @author <a href='http://github.com/nelsoncastro'>Nelson Castro</a>
 * @since 1.0
 */
public class BusinessException extends RuntimeException {

    public BusinessException() {
        super();
    }

    public BusinessException(String message) {
        super(message);
    }

    public BusinessException(String message, Throwable cause) {
        super(message, cause);
    }

    public BusinessException(Throwable cause) {
        super(cause);
    }

    public static void throwMessage(String message) {
        throw new BusinessException(message);
    }
}

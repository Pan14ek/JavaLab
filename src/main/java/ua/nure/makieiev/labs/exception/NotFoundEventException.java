package ua.nure.makieiev.labs.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotFoundEventException extends RuntimeException {

    public NotFoundEventException() {
    }

    public NotFoundEventException(String message) {
        super(message);
    }

    public NotFoundEventException(String message, Throwable cause) {
        super(message, cause);
    }

}
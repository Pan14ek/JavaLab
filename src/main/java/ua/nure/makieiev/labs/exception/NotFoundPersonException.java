package ua.nure.makieiev.labs.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotFoundPersonException extends RuntimeException {

    public NotFoundPersonException() {
    }

    public NotFoundPersonException(String message) {
        super(message);
    }

    public NotFoundPersonException(String message, Throwable cause) {
        super(message, cause);
    }

}
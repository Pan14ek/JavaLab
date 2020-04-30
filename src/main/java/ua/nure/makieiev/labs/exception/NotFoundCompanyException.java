package ua.nure.makieiev.labs.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotFoundCompanyException extends RuntimeException {

    public NotFoundCompanyException() {
    }

    public NotFoundCompanyException(String message) {
        super(message);
    }

    public NotFoundCompanyException(String message, Throwable cause) {
        super(message, cause);
    }

}
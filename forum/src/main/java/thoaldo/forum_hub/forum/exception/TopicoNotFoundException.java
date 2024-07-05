package thoaldo.forum_hub.forum.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class TopicoNotFoundException extends RuntimeException {
    public TopicoNotFoundException(String message) {
        super(message);
    }
}

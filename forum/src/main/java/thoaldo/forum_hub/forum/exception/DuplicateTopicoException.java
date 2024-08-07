package thoaldo.forum_hub.forum.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class DuplicateTopicoException extends RuntimeException {
    public DuplicateTopicoException(String message) {
        super(message);
    }
}

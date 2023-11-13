package co.edu.jdc.TiendasDeBarrio.domain.exception;

import lombok.Getter;

@Getter
public class UserException extends RuntimeException{
    private String message;
    public UserException(String message) {
        super(message);
        this.message = message;
    }
}

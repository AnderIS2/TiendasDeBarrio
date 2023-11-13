package co.edu.jdc.TiendasDeBarrio.domain.exception;

import lombok.Getter;

@Getter
public class TiendaException extends RuntimeException{
    private String message;
    public TiendaException(String message) {
        super(message);
        this.message = message;
    }
}

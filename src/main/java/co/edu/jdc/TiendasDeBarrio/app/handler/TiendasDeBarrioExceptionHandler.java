package co.edu.jdc.TiendasDeBarrio.app.handler;

import co.edu.jdc.TiendasDeBarrio.domain.dto.ErrorResponseDto;
import co.edu.jdc.TiendasDeBarrio.domain.exception.TiendaException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class TiendasDeBarrioExceptionHandler {
    @ExceptionHandler(TiendaException.class)
    public ResponseEntity<ErrorResponseDto> handleException(TiendaException ex) {
        ErrorResponseDto errorResponse = new ErrorResponseDto(HttpStatus.BAD_REQUEST.value(), ex.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }
  /*  @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponseDto> handleException(Exception ex) {
        ErrorResponseDto errorResponse = new ErrorResponseDto(HttpStatus.PRECONDITION_FAILED.value(), "Error interno en el servidor");
        return new ResponseEntity<>(errorResponse, HttpStatus.PRECONDITION_FAILED);
    }*/
}

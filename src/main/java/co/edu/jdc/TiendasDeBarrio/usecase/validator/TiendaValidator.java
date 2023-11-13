package co.edu.jdc.TiendasDeBarrio.usecase.validator;

import co.edu.jdc.TiendasDeBarrio.domain.dto.TiendaDto;
import co.edu.jdc.TiendasDeBarrio.domain.exception.TiendaException;

import static java.util.Objects.isNull;

public class TiendaValidator {

    public static void validateInputDto(TiendaDto dto){
        if(isNull( dto ))
            throw new TiendaException("Los datos no puede ser nulos");
        if(dto.getName() == null || dto.getName().trim().isEmpty())
            throw new TiendaException("El nombre no puede ser nulo o vacio");
        if(dto.getEmail() == null || dto.getEmail().trim().isEmpty())
            throw new TiendaException("El email no puede ser nulo o vacio");
        // TODO validar que el email sea valido
        if(dto.getAddress() == null || dto.getAddress().trim().isEmpty())
            throw new TiendaException("La contraseña no puede ser nula o vacia");
    }

}

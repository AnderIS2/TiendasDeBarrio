package co.edu.jdc.TiendasDeBarrio.usecase.validator;

import co.edu.jdc.TiendasDeBarrio.domain.dto.UserDto;
import co.edu.jdc.TiendasDeBarrio.domain.exception.UserException;

import static java.util.Objects.isNull;

public class UserValidator {

    public static void validateInputDto(UserDto dto){
        if(isNull( dto ))
            throw new UserException("El usuario no puede ser nulo");
        if(dto.getFirstName() == null || dto.getFirstName().trim().isEmpty())
            throw new UserException("El nombre no puede ser nulo o vacio");
        if(dto.getFirstLastName() == null || dto.getFirstLastName().trim().isEmpty())
            throw new UserException("El primer apellido no puede ser nulo o vacio");
        if(dto.getEmail() == null || dto.getEmail().trim().isEmpty())
            throw new UserException("El email no puede ser nulo o vacio");
        // TODO validar que el email sea valido
        if(dto.getPassword() == null || dto.getPassword().trim().isEmpty())
            throw new UserException("La contraseña no puede ser nula o vacia");
        if(dto.getUsername() == null || dto.getUsername().trim().isEmpty())
            throw new UserException("El nombre de usuario no puede ser nulo o vacio");
    }
}

package co.edu.jdc.TiendasDeBarrio.usecase.validator;

import co.edu.jdc.TiendasDeBarrio.domain.dto.RoleDto;

public class RoleValidator {

    public static void validateInputDto (RoleDto dto){
        if(dto.getRole() == null || dto.getRole().isEmpty())
            throw new RuntimeException("El nombre del rol no puede ser vacio o nulo");
        if(dto.getDescription() == null || dto.getDescription().isEmpty())
            throw new RuntimeException("La descripcion del rol no puede ser vacio o nulo");
    }
}

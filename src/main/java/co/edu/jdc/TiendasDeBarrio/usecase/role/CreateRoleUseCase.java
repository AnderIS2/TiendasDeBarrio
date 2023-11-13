package co.edu.jdc.TiendasDeBarrio.usecase.role;

import co.edu.jdc.TiendasDeBarrio.adapter.repository.RoleRepository;
import co.edu.jdc.TiendasDeBarrio.domain.dto.RoleDto;
import co.edu.jdc.TiendasDeBarrio.domain.entities.Role;
import co.edu.jdc.TiendasDeBarrio.domain.exception.TiendaException;
import co.edu.jdc.TiendasDeBarrio.domain.mapper.RoleMapper;
import co.edu.jdc.TiendasDeBarrio.usecase.validator.RoleValidator;
import co.edu.jdc.TiendasDeBarrio.usecase.validator.TiendaValidator;

public class CreateRoleUseCase {

    private RoleRepository roleRepository;

    public CreateRoleUseCase(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public void execute(RoleDto dto) {

        // validar informacion de usuario
        RoleValidator.validateInputDto(dto);

        // validar que el usuario no exista
        if(this.roleRepository.existsRole(dto.getRole().trim()).intValue() > 0)
            throw new TiendaException("La tienda ya existe");

        Role role = RoleMapper.INSTANCE.toEntity(dto);
        this.roleRepository.save(role);
    }
}

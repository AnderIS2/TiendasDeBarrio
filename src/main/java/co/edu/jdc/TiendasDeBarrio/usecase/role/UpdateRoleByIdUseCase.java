package co.edu.jdc.TiendasDeBarrio.usecase.role;

import co.edu.jdc.TiendasDeBarrio.adapter.repository.RoleRepository;
import co.edu.jdc.TiendasDeBarrio.domain.dto.RoleDto;
import co.edu.jdc.TiendasDeBarrio.domain.entities.Role;
import co.edu.jdc.TiendasDeBarrio.domain.entities.Tienda;
import co.edu.jdc.TiendasDeBarrio.domain.exception.TiendaException;
import co.edu.jdc.TiendasDeBarrio.domain.mapper.RoleMapper;
import co.edu.jdc.TiendasDeBarrio.domain.mapper.TiendaMapper;

public class UpdateRoleByIdUseCase {

    private RoleRepository roleRepository;

    public UpdateRoleByIdUseCase(RoleRepository roleRepository){
        this.roleRepository = roleRepository;
    }

    public void execute(RoleDto dto, Long id){

        // validar que la tienda exista
        if (this.roleRepository.existRole(id).intValue() == 0)
            throw new TiendaException("La tienda no existe");
        dto.setId(id);

        Role role = RoleMapper.INSTANCE.toEntity(dto);

        // guardar información actualizada
        this.roleRepository.save(role);
    }
}

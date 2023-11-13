package co.edu.jdc.TiendasDeBarrio.usecase.role;

import co.edu.jdc.TiendasDeBarrio.adapter.repository.RoleRepository;
import co.edu.jdc.TiendasDeBarrio.domain.dto.RoleDto;
import co.edu.jdc.TiendasDeBarrio.domain.entities.Role;
import co.edu.jdc.TiendasDeBarrio.domain.mapper.RoleMapper;

import java.util.List;

public class ConsultAllRolesUseCase {

    private RoleRepository roleRepository;

    public ConsultAllRolesUseCase(RoleRepository roleRepository){
        this.roleRepository = roleRepository;
    }

    public List<RoleDto> execute(){
        List<Role> roles = roleRepository.findAll();
        List<RoleDto> listRoles = RoleMapper.INSTANCE.toDto(roles);
        return listRoles;
    }

}

package co.edu.jdc.TiendasDeBarrio.usecase.role;

import co.edu.jdc.TiendasDeBarrio.adapter.repository.RoleRepository;
import co.edu.jdc.TiendasDeBarrio.domain.exception.TiendaException;

public class DeleteRoleByIdUseCase {

    private RoleRepository roleRepository;

    public DeleteRoleByIdUseCase(RoleRepository roleRepository){
        this.roleRepository = roleRepository;
    }

    public void execute(Long id){
        if(roleRepository.existRole(id).intValue() == 0)
            throw new TiendaException("La tienda no existe");
        this.roleRepository.deleteById(id);
    }
}

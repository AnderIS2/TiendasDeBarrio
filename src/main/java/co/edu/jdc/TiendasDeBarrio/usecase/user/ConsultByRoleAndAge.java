package co.edu.jdc.TiendasDeBarrio.usecase.user;

import co.edu.jdc.TiendasDeBarrio.adapter.repository.RoleRepository;
import co.edu.jdc.TiendasDeBarrio.domain.entities.Role;
import co.edu.jdc.TiendasDeBarrio.domain.entities.User;

import java.util.List;

public class ConsultByRoleAndAge {

    private RoleRepository roleRepository;

    public ConsultByRoleAndAge(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public List<User> execute(String role) {
        return roleRepository.findUsersByRoleName(role);
    }
}

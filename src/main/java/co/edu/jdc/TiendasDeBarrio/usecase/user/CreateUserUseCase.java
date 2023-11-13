package co.edu.jdc.TiendasDeBarrio.usecase.user;


import co.edu.jdc.TiendasDeBarrio.adapter.repository.RoleRepository;
import co.edu.jdc.TiendasDeBarrio.domain.dto.UserDto;
import co.edu.jdc.TiendasDeBarrio.domain.entities.Role;
import co.edu.jdc.TiendasDeBarrio.domain.entities.User;
import co.edu.jdc.TiendasDeBarrio.domain.exception.TiendaException;
import co.edu.jdc.TiendasDeBarrio.domain.exception.UserException;
import co.edu.jdc.TiendasDeBarrio.domain.mapper.UserMapper;
import co.edu.jdc.TiendasDeBarrio.usecase.port.CipherInfo;
import co.edu.jdc.TiendasDeBarrio.adapter.repository.UserRepository;
import co.edu.jdc.TiendasDeBarrio.usecase.validator.UserValidator;

import javax.management.relation.RoleNotFoundException;
import java.util.HashSet;
import java.util.Set;


public class CreateUserUseCase {

    private UserRepository userRepository;
    private CipherInfo cipherInfo;

    public CreateUserUseCase(UserRepository userRepository, CipherInfo cipherInfo) {
        this.userRepository = userRepository;
        this.cipherInfo = cipherInfo;
    }

    public void execute(UserDto dto) {
        // Validar información de usuario
        UserValidator.validateInputDto(dto);

        // Validar que el usuario no exista
        if (userRepository.existsUser(dto.getUsername().trim()).intValue() > 0) {
            throw new UserException("El usuario ya existe");
        }

        // Convertir dto a entidad
        User user = UserMapper.INSTANCE.toEntity(dto);

        // Cifrar contraseña
        user.setPassword(cipherInfo.encrypt(dto.getPassword()));

        // Guardar el usuario en la base de datos
        userRepository.save(user);
    }

}

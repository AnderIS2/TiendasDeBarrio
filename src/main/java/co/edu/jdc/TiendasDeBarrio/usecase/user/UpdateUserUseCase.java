package co.edu.jdc.TiendasDeBarrio.usecase.user;


import co.edu.jdc.TiendasDeBarrio.adapter.cipher.CipherInfoImpl;
import co.edu.jdc.TiendasDeBarrio.adapter.repository.UserRepository;
import co.edu.jdc.TiendasDeBarrio.domain.dto.UserDto;
import co.edu.jdc.TiendasDeBarrio.domain.entities.User;
import co.edu.jdc.TiendasDeBarrio.domain.exception.UserException;
import co.edu.jdc.TiendasDeBarrio.domain.mapper.UserMapper;
import co.edu.jdc.TiendasDeBarrio.usecase.port.CipherInfo;

import java.util.Objects;

public class UpdateUserUseCase {

    private UserRepository userRepository;
    private CipherInfo cipherInfo;

    public UpdateUserUseCase(UserRepository userRepository, CipherInfo cipherInfo){
        this.userRepository = userRepository;
        this.cipherInfo = cipherInfo;
    }

    public void execute(UserDto dto, Long id){



        if (this.userRepository.existUser(id).intValue() == 0)
            throw new UserException("El usuario no existe");
        dto.setId(id);

        // validar la contraseña y cifrarla
        if (!this.userRepository.findPasswordByUsername(id).equals(cipherInfo.encrypt(dto.getPassword())))
            throw new UserException("La contraseña no coincide");

        if(dto.getFirstName()== null || dto.getFirstName().isEmpty()) {
            dto.setFirstName(this.userRepository.findUserById(id).get(0).getFirstName());
        } else if (dto.getSecondName() == null) {
            dto.setSecondName(this.userRepository.findUserById(id).get(0).getSecondName());
        }

        User user = UserMapper.INSTANCE.toEntity(dto);

        user.setPassword(cipherInfo.encrypt(dto.getPassword()));

        this.userRepository.update(user.getFirstName(), user.getSecondName(), user.getFirstLastName(), user.getSecondLastName(), user.getAge(), user.getEmail(), user.getUsername(), user.getId());
    }
}

package co.edu.jdc.TiendasDeBarrio.usecase.user;

import co.edu.jdc.TiendasDeBarrio.adapter.repository.UserRepository;
import co.edu.jdc.TiendasDeBarrio.domain.dto.TiendaDto;
import co.edu.jdc.TiendasDeBarrio.domain.dto.UserDto;
import co.edu.jdc.TiendasDeBarrio.domain.entities.User;
import co.edu.jdc.TiendasDeBarrio.domain.mapper.UserMapper;

import java.util.List;

public class ConsultAllUserUseCase {

    private UserRepository userRepository;

    public ConsultAllUserUseCase(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public List<UserDto> execute(){
        List<User> users = userRepository.findAll();
        List<UserDto> listUsers = UserMapper.INSTANCE.toDto(users);
        return listUsers;
    }

}

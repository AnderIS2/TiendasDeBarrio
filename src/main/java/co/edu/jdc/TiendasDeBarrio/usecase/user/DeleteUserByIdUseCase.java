package co.edu.jdc.TiendasDeBarrio.usecase.user;

import co.edu.jdc.TiendasDeBarrio.adapter.repository.UserRepository;

public class DeleteUserByIdUseCase {

    private UserRepository userRepository;

    public DeleteUserByIdUseCase(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public void execute(Long id){
        this.userRepository.deleteById(id);
    }
}

package co.edu.jdc.TiendasDeBarrio.app.config;

import co.edu.jdc.TiendasDeBarrio.adapter.cipher.CipherInfoImpl;
import co.edu.jdc.TiendasDeBarrio.adapter.repository.RoleRepository;
import co.edu.jdc.TiendasDeBarrio.adapter.repository.UserRepository;
import co.edu.jdc.TiendasDeBarrio.usecase.port.CipherInfo;
import co.edu.jdc.TiendasDeBarrio.adapter.repository.TiendaRepository;
import co.edu.jdc.TiendasDeBarrio.usecase.role.ConsultAllRolesUseCase;
import co.edu.jdc.TiendasDeBarrio.usecase.role.DeleteRoleByIdUseCase;
import co.edu.jdc.TiendasDeBarrio.usecase.role.UpdateRoleByIdUseCase;
import co.edu.jdc.TiendasDeBarrio.usecase.user.*;
import co.edu.jdc.TiendasDeBarrio.usecase.role.CreateRoleUseCase;
import co.edu.jdc.TiendasDeBarrio.usecase.tienda.ConsultTiendaUseCase;
import co.edu.jdc.TiendasDeBarrio.usecase.tienda.CreateTiendaUseCase;
//import co.edu.jdc.TiendasDeBarrio.usecase.tienda.DeleteTiendaUseCase;
// co.edu.jdc.TiendasDeBarrio.usecase.tienda.UpdateTiendaUseCase;
import co.edu.jdc.TiendasDeBarrio.usecase.tienda.DeleteTiendaUseCase;
import co.edu.jdc.TiendasDeBarrio.usecase.tienda.UpdateTiendaUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration

public class AppConfig {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    public TiendaRepository tiendaRepository;

    //USERS USECASES
    @Bean
    public CreateUserUseCase createUserUseCase() {
        return new CreateUserUseCase(userRepository, cipherInfo());
    }

    @Bean
    public CipherInfo cipherInfo() {
        return new CipherInfoImpl();
    }

    @Bean
    public ConsultAllUserUseCase consultAllUserUseCase(){
        return new ConsultAllUserUseCase(userRepository);
    }

    @Bean
    public DeleteUserByIdUseCase deleteUserByIdUseCase(){
        return new DeleteUserByIdUseCase(userRepository);
    }

    @Bean
    public UpdateUserUseCase updateUserUseCase(){
        return new UpdateUserUseCase(userRepository, cipherInfo());
    }

    //ROLES USECASES

    @Bean
    public CreateRoleUseCase createRoleUseCase() {
        return new CreateRoleUseCase(roleRepository);
    }

    @Bean
    public ConsultByRoleAndAge consultByRoleAndAge() {
        return new ConsultByRoleAndAge(roleRepository);
    }

    @Bean
    public ConsultAllRolesUseCase consultAllRoleUseCase(){
        return new ConsultAllRolesUseCase(roleRepository);
    }

    @Bean
    public DeleteRoleByIdUseCase deleteRoleByIdUseCase(){
        return new DeleteRoleByIdUseCase(roleRepository);
    }

    @Bean
    public UpdateRoleByIdUseCase updateRoleUseCase(){
        return new UpdateRoleByIdUseCase(roleRepository);
    }

    //TIENDAS USECASES

    @Bean
    public CreateTiendaUseCase createTiendaUseCase(){
        return new CreateTiendaUseCase(tiendaRepository);
    }

    @Bean
    public ConsultTiendaUseCase consultTiendaUseCase(){
        return new ConsultTiendaUseCase(tiendaRepository);
    }

    @Bean
    public DeleteTiendaUseCase deleteTiendaUseCase(){
        return new DeleteTiendaUseCase(tiendaRepository);
    }

    @Bean
    public UpdateTiendaUseCase updateTiendaUseCase(){
        return new UpdateTiendaUseCase(tiendaRepository);
    }


}

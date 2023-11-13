package co.edu.jdc.TiendasDeBarrio.app.rest;

import co.edu.jdc.TiendasDeBarrio.domain.dto.RoleDto;
import co.edu.jdc.TiendasDeBarrio.domain.dto.TiendaDto;
import co.edu.jdc.TiendasDeBarrio.domain.dto.UserDto;
import co.edu.jdc.TiendasDeBarrio.domain.entities.User;
import co.edu.jdc.TiendasDeBarrio.usecase.role.ConsultAllRolesUseCase;
import co.edu.jdc.TiendasDeBarrio.usecase.role.DeleteRoleByIdUseCase;
import co.edu.jdc.TiendasDeBarrio.usecase.role.UpdateRoleByIdUseCase;
import co.edu.jdc.TiendasDeBarrio.usecase.tienda.ConsultTiendaUseCase;
import co.edu.jdc.TiendasDeBarrio.usecase.tienda.CreateTiendaUseCase;
import co.edu.jdc.TiendasDeBarrio.usecase.tienda.DeleteTiendaUseCase;
import co.edu.jdc.TiendasDeBarrio.usecase.tienda.UpdateTiendaUseCase;
import co.edu.jdc.TiendasDeBarrio.usecase.user.*;
import co.edu.jdc.TiendasDeBarrio.usecase.role.CreateRoleUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class TiendaController {

    //USERS USECASES

    @Autowired
    private CreateUserUseCase createUserUseCase;

    @PostMapping(value = "/user/create", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void createUser(@RequestBody UserDto userDto) {
        this.createUserUseCase.execute(userDto);
    }

    @Autowired
    private ConsultAllUserUseCase consultAllUserUseCase;

    @GetMapping(value = "/user/consult", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<UserDto> consultAllUserUseCase() {
        return consultAllUserUseCase.execute();
    }

    @Autowired
    private ConsultByRoleAndAge consultByRoleAndAge;

    @GetMapping(value = "/user/consult/{role}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<User> consultAll(@PathVariable(value = "role") String role) {
        return consultByRoleAndAge.execute(role);
    }

    @Autowired
    private DeleteUserByIdUseCase deleteUserByIdUseCase;

    @DeleteMapping(value = "/user/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void deleteUserById(@PathVariable(value = "id") Long id) {
        this.deleteUserByIdUseCase.execute(id);
    }

    @Autowired
    private UpdateUserUseCase updateUserUseCase;

    @PutMapping(value = "/user/update/{id}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void updateUser(@PathVariable(value = "id") Long id, @RequestBody UserDto userDto) {
        this.updateUserUseCase.execute(userDto, id);
    }

    //ROLES USECASES

    @Autowired
    private CreateRoleUseCase createRoleUseCase;

    @PostMapping(value = "/role/create", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void createRole(@RequestBody RoleDto roleDto) {
        this.createRoleUseCase.execute(roleDto);
    }

    @Autowired
    private ConsultAllRolesUseCase consultAllRolesUseCase;

    @GetMapping(value = "/role/consult", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<RoleDto> consultAllRolesUseCase() {
        return consultAllRolesUseCase.execute();
    }

    @Autowired
    private DeleteRoleByIdUseCase deleteRoleByIdUseCase;

    @DeleteMapping(value = "/role/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void deleteRoleById(@PathVariable(value = "id") Long id) {
        this.deleteRoleByIdUseCase.execute(id);
    }

    @Autowired
    private UpdateRoleByIdUseCase updateRoleByIdUseCase;

    @PutMapping(value = "/role/update/{id}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void updateRole(@PathVariable(value = "id") Long id, @RequestBody RoleDto roleDto) {
        this.updateRoleByIdUseCase.execute(roleDto, id);
    }


    //TIENDAS USECASES

    @Autowired
    private CreateTiendaUseCase createTiendaUseCase;

    @PostMapping(value = "/tienda/create", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void createUser(@RequestBody TiendaDto tiendaDto) {
        this.createTiendaUseCase.execute(tiendaDto);
    }

    @Autowired
    private ConsultTiendaUseCase consultTiendaUseCase;

    @GetMapping(value = "/tienda/consult", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<TiendaDto> consultAllTiendasUseCase() {
        return consultTiendaUseCase.execute();
    }

    @Autowired
    private DeleteTiendaUseCase deleteTiendaUseCase;

    @DeleteMapping(value = "/tienda/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void deleteTiendaById(@PathVariable(value = "id") Long id) {
        this.deleteTiendaUseCase.execute(id);
    }

    @Autowired
    private UpdateTiendaUseCase updateTiendaUseCase;

    @PutMapping(value = "/tienda/update/{id}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void updateTienda(@PathVariable(value = "id") Long id, @RequestBody TiendaDto tiendaDto) {
        this.updateTiendaUseCase.execute(tiendaDto, id);
    }
}
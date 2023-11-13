package co.edu.jdc.TiendasDeBarrio.adapter.repository;

import co.edu.jdc.TiendasDeBarrio.domain.entities.Role;
import co.edu.jdc.TiendasDeBarrio.domain.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long>{

    @Query(value = "SELECT r FROM Role r")
    List<Role> findAll();

    @Query(value = "SELECT COUNT (r) FROM Role r WHERE r.role = :role")
    Long existsRole(String role);

    @Query(value = "SELECT COUNT (r) FROM Role r WHERE r.id = :id")
    Long existRole(Long id);

    //Consulta de usuarios por usuario con join

    @Query("SELECT u FROM User u JOIN UserRole ur ON u.id = ur.user.id JOIN Role r ON ur.role.id = r.id WHERE r.role = :role AND u.age > 19 AND u.age < 41")
    List<User> findUsersByRoleName(@Param("role") String role);

}



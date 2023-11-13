package co.edu.jdc.TiendasDeBarrio.adapter.repository;

import co.edu.jdc.TiendasDeBarrio.domain.dto.UserDto;
import co.edu.jdc.TiendasDeBarrio.domain.entities.User;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query(value = "SELECT u FROM User u")
    List<User> findAll();

    @Query(value = "SELECT COUNT (u) FROM User u WHERE u.username = :username")
    Long existsUser(String username);

    @Query(value = "SELECT COUNT (u) FROM User u WHERE u.id = :id")
    Long existUser(Long id);

    @Query(value = "SELECT u.password FROM User u WHERE u.id = :id")
    String findPasswordByUsername(Long id);

    @Query(value = "SELECT u FROM User u WHERE u.id = :id")
    List<User> findUserById(Long id);


    @Modifying
    @Transactional
    @Query("UPDATE User u SET u.firstName = :firstName, u.secondName = :secondName, u.firstLastName = :firstLastName, u.secondLastName = :secondLastName, u.age = :age, u.email = :email, u.username = :username WHERE u.id = :id")
    void update(
            @Param("firstName") String firstName,
            @Param("secondName") String secondName,
            @Param("firstLastName") String firstLastName,
            @Param("secondLastName") String secondLastName,
            @Param("age") int age,
            @Param("email") String email,
            @Param("username") String username,
            @Param("id") Long id
    );

}
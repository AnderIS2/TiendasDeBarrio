package co.edu.jdc.TiendasDeBarrio.domain.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "user")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "usu_first_name", length = 50, nullable = false)
    private String firstName;
    @Column(name = "usu_second_name", length = 50)
    private String secondName;
    @Column(name = "usu_first_last_name", length = 50, nullable = false)
    private String firstLastName;
    @Column(name = "usu_second_last_name", length = 50)
    private String secondLastName;
    @Column(name = "usu_age", length = 3, nullable = false)
    private int age;
    @Column(name = "usu_email", length = 100, nullable = false, unique = true)
    private String email;
    @Column(name = "usu_password", length = 255, nullable = false)
    private String password;
    @Column(name = "usu_username", length = 50, nullable = false, unique = true)
    private String username;
}


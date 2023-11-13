package co.edu.jdc.TiendasDeBarrio.domain.dto;

import lombok.Data;

@Data
public class UserDto {
    private Long id;
    private String firstName;
    private String secondName;
    private String firstLastName;
    private String secondLastName;
    private int age;
    private String email;
    private String password;
    private String username;
}

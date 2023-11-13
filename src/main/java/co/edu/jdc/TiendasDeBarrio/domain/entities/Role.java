package co.edu.jdc.TiendasDeBarrio.domain.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "role")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "rol_name", length = 50, nullable = false, unique = true)
    private String role;
    @Column(name = "rol_description", length = 255)
    private String description;
}
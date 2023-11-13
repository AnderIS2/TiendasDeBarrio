package co.edu.jdc.TiendasDeBarrio.domain.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "tiendas")
@Data
public class Tienda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="tienda_name", length = 50,  nullable = false)
    private String name;
    @Column(name="tienda_address", length = 50,  nullable = false)
    private String address;
    @Column(name="tienda_phone",length = 10,  nullable = false, unique = true)
    private String phone;
    @Column(name= "tienda_email",length = 100, nullable = false, unique = true)
    private String email;
}
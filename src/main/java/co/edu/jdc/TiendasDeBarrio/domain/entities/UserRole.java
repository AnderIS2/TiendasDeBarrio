package co.edu.jdc.TiendasDeBarrio.domain.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "user_role")
public class UserRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(optional = false)
    @JoinColumn(name = "usr_user_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_user_role_user"))
    private User user;
    @ManyToOne(optional = false)
    @JoinColumn(name = "usr_role_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_user_role_role"))
    private Role role;
}

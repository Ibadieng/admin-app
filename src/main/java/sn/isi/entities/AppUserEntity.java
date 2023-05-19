package sn.isi.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "user")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AppUserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private int id;
    @Column(nullable = false, length = 150, name = "user_last_name")
    private String lastName;
    @Column(nullable = false, length = 200, name = "user_first_name")
    private String firstName;
    @Column(nullable = false, length = 200, name = "user_email")
    private String email;
    @Column(nullable = false, length = 200, name = "user_password")
    private String password;
    private int etat;

    @ManyToMany
    @JoinTable(
            name = "users_roles",
            joinColumns = @JoinColumn(name = "roles_id"),
            inverseJoinColumns = @JoinColumn(name = "users_id"))
    private List<AppRolesEntity> appRoleEntities;

    @OneToMany(mappedBy = "appUserEntity", fetch = FetchType.LAZY)
    private List<ProduitEntity> produitEntities;
}

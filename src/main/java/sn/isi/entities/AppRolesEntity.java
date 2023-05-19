package sn.isi.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "roles")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AppRolesEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "roles_id")
    private int id;
    @Column(unique = true, nullable = false, length = 100, name = "roles_name")
    private String name;
    @ManyToMany(mappedBy = "appRoleEntities",fetch =FetchType.LAZY)
    private List<AppUserEntity> appUserEntity;
}

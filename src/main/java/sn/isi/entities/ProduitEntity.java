package sn.isi.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "products")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProduitEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "products_id")
    private int id;
    @Column(unique = true, nullable = false, length = 200, name = "products_nom" )
    private String nom;
    @Column(nullable = false , name = "products_qtStock")
    private double qtStock;
    @ManyToOne
    @JoinColumn( name="id_user", nullable=false )
    private AppUserEntity appUserEntity;
}

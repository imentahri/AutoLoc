package tn.esprit.autoloc.domain;

import jakarta.persistence.*;
import lombok.*;
import java.util.Set;
@Entity
@Getter
@Setter
@AllArgsConstructor
@ToString
@NoArgsConstructor
public class Agence {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idAgence;

    @OneToMany(mappedBy = "agence", cascade = CascadeType.ALL)
    private Set<Employe> employes;

    @OneToMany(mappedBy = "agence", cascade = CascadeType.ALL)
    private Set<Vehicule> vehicules;

    @Column(nullable = false, length = 100)//contraintes sur la colonne ds la bd
    private String nom;

    @Column(nullable = false, length = 50)
    private String ville;

    @Column(length = 255)
    private String adresse;

    @Column(length = 20)
    private String telephone;
}

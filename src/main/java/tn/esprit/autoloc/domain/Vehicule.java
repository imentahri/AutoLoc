package tn.esprit.autoloc.domain;

import lombok.*;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@ToString
@NoArgsConstructor
public class Vehicule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idVehicule;


    @Column(nullable = false, unique = true, length = 20)
    private String immatriculation;

    @Column(nullable = false, length = 50)
    private String marque;

    @Column(nullable = false, length = 50)
    private String modele;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private CategorieVehicule categorie;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal tarifJournalier;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private StatutVehicule statut;

    @ManyToOne
    Agence agence;

    @OneToMany(mappedBy = "vehicule", cascade = CascadeType.ALL)
    private Set<Maintenance> maintenances;

    @OneToMany(mappedBy = "vehicule")
    private Set<Reservation> reservations;

    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Equipement> equipements;

}

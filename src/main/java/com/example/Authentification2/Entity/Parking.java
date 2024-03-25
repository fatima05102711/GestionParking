package com.example.Authentification2.Entity;

import jakarta.persistence.*;
import lombok.*;


import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Parking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "etat_parking")
    private String etat;
    @Column(name = "emplacement")
    private String emplacement;
    @Column(name = "nombre_Place")
    private int nombrePlace =10;
    private boolean isAuthorize;
    @Column(name = "prix")
    private String prix;

    @ManyToOne
    @JoinColumn(name = "id_voiture")
    private Vehicule vehicule;

    @OneToMany(mappedBy = "parking")
    private List<Reservation> reservations;
}

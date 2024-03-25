package com.example.Authentification2.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Vehicule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "marque")
    private String marque ;
    @Column(name = "modele")
    private String modele;
    @Column(name = "couleur")
    private String couleur ;
    @Column(name = "immat")
    private String immatriculation;
    @CreationTimestamp
    private LocalDateTime dateCreation;


    @OneToMany(mappedBy = "vehicule")
    private List<User> users;

    @OneToMany(mappedBy = "vehicule")
    private List<User> user ;
}

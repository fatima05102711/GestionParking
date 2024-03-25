package com.example.Authentification2.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.management.relation.Role;
import java.util.Collection;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nom_user")
    private String nom;
    @Column(name = "prenom_user")
    private String prenom;
    @Column(name = "password")
    private String password;
    @Column(name = "email")
    private String email;
    //    private Role role;
    private String username;
    private Role role;


    @OneToMany(mappedBy = "user")
    private List<Reservation> reservations;


    @ManyToOne
    @JoinColumn(name = "id_voiture")
    private Vehicule vehicule;

}
package com.example.Authentification2.Dto;

import com.example.Authentification2.Entity.User;
import com.example.Authentification2.Entity.Vehicule;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class VehiculeDto {
    private Long id;
    private String marque ;
    private String modele;
    private String couleur ;
    private String immatriculation;
    private LocalDateTime dateCreation;

    public static VehiculeDto fromEntity(Vehicule vehicule )
    {
        return VehiculeDto.builder()
                .id(vehicule.getId())
                .marque(vehicule.getMarque())
                .modele(vehicule.getModele())
                .couleur(vehicule.getCouleur())
                .dateCreation(vehicule.getDateCreation())
                .immatriculation(vehicule.getImmatriculation()).build();

    }
    public static Vehicule toEntity(VehiculeDto vehiculeDto)
    {
        Vehicule vehicule = new Vehicule();
        vehicule.setMarque(vehiculeDto.getMarque());
        vehicule.setId(vehiculeDto.getId());
        vehicule.setModele(vehiculeDto.getModele());
        vehicule.setCouleur(vehiculeDto.getCouleur());
        vehicule.setImmatriculation(vehiculeDto.getImmatriculation());
        vehicule.setDateCreation(vehicule.getDateCreation());
        return vehicule;

    }
}

package com.example.Authentification2.Dto;

import com.example.Authentification2.Entity.Parking;
import com.example.Authentification2.Entity.User;
import com.example.Authentification2.Entity.Vehicule;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ParkingDto {
    private Long id;
    private String etat;
    private String emplacement;
    private String taille;
    private int  nombrePlace;
    private boolean isAuthorize;
    private Vehicule vehicule;

    private String prix;

    public static ParkingDto fromEntity(Parking parking)
    {
        return ParkingDto.builder()
                .id(parking.getId())
                .etat(parking.getEtat())
                .emplacement(parking.getEmplacement())
                .nombrePlace(parking.getNombrePlace())
                .prix(parking.getPrix())
                .vehicule(parking.getVehicule())
                .build();
    }
  public static Parking toEntity(ParkingDto parkingDto)
  {
      Parking parking = new Parking();
      parking.setId(parkingDto.getId());
      parking.setEtat(parkingDto.getEtat());
      parking.setEmplacement(parkingDto.getEmplacement());
      parking.setPrix(parkingDto.getPrix());
      parking.setNombrePlace(parkingDto.getNombrePlace());
      parking.setVehicule(parkingDto.getVehicule());
      return parking;

  }
}

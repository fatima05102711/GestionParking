package com.example.Authentification2.Service;

import com.example.Authentification2.Dto.VehiculeDto;
import com.example.Authentification2.Entity.Vehicule;

import java.util.List;
import java.util.Optional;

public interface VehiculeService {
    List<VehiculeDto> getAllVehicules();
    Optional<Vehicule> getVehiculeById(Long id );
    VehiculeDto createVehicule(VehiculeDto vehiculeDto);
    VehiculeDto updateVehicule(Long idVehicule, VehiculeDto vehiculeDto );
    void deleteVehiculeById(Long id);

}

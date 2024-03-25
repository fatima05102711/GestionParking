package com.example.Authentification2.Controller;

import com.example.Authentification2.Dto.VehiculeDto;
import com.example.Authentification2.Entity.Vehicule;
import com.example.Authentification2.Service.VehiculeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/vehicule")
@Tag(name = "Vehicule Controller ",description = "Gestion des Vehicules")
public class VehiculeController {
    @Autowired
  private VehiculeService vehiculeService;
    @Operation(summary = "creer un vehicule",description = "creation")
    @PostMapping("/createVehicule")
    public VehiculeDto createVehicule(@RequestBody VehiculeDto vehiculeDto)
    {
        return vehiculeService.createVehicule(vehiculeDto);
    }
    @Operation(summary = "renvois une liste de Vehicule",description = "liste")
    @GetMapping("/getAllVehicules")
    public List <VehiculeDto> getAllVehicules()
    {
        return vehiculeService.getAllVehicules();
    }
    @Operation(summary = "renvois par id ",description = "id")
    @GetMapping("/getVehiculeById/{id}")
    Optional<Vehicule> getVehiculeById(@PathVariable Long id )
    {
        return vehiculeService.getVehiculeById(id );
    }
    @Operation(summary = "mise a jour des infos ",description = "modification")
    @PutMapping("/updateVehicule/{id}")
    public VehiculeDto updateVehicule(@PathVariable Long idVehicule ,@RequestBody VehiculeDto vehiculeDto)
    {
        return vehiculeService.updateVehicule(idVehicule ,vehiculeDto);
    }
    @Operation(summary = "supprimer par id",description = "suppression")
    @DeleteMapping("/{id}")
    public void deleteVehiculeById(@PathVariable Long id )
    {
        vehiculeService.deleteVehiculeById(id);
    }
}

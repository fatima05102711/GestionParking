package com.example.Authentification2.Controller;

import com.example.Authentification2.Dto.ParkingDto;
import com.example.Authentification2.Entity.Parking;
import com.example.Authentification2.Service.ParkingService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableMBeanExport;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/parking")
@Tag(name = "Parking Controller",description = "gestion du parking")
public class ParkingController {
    @Autowired
    private ParkingService parkingService;
    @Operation(summary ="Creer un employer",description = "creation")
    @PostMapping("/createParking")
    public ParkingDto createParking(@RequestBody ParkingDto parkingDto)
    {
        return parkingService.createParking(parkingDto);
    }
    @Operation(summary = "renvoyer une liste de parking",description = "liste")
    @GetMapping("/getAllParkings")
    public List<Parking> getAllParkings()
    {
        return parkingService.getAllParkings();
    }
    @Operation(summary = "renvois par id",description = "id")
    @GetMapping("/getParkingById")
    public Optional<Parking> getParkingById(@PathVariable Long id)
    {
        return parkingService.getParkingById(id);
    }
    @Operation(summary = "mise a jour des infos ",description = "mofication")
    @PutMapping("/updateParking/{idParking}")
    public ParkingDto updateParking(Long idParking, ParkingDto parkingDto)
    {
        return parkingService.updateParking(idParking,parkingDto);
    }
    @Operation(summary = "supprimer par id",description = "suppression")
    @DeleteMapping("/deleteById/{id}")
    public void deleteById(Long id) {
        parkingService.deleteById(id);
    }



}

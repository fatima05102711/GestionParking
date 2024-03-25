package com.example.Authentification2.Controller;

import com.example.Authentification2.Dto.ReservationDto;
import com.example.Authentification2.Dto.VehiculeDto;
import com.example.Authentification2.Entity.Reservation;
import com.example.Authentification2.Entity.Vehicule;
import com.example.Authentification2.Service.ReservationService;
import com.example.Authentification2.Service.VehiculeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/reservation")
@Tag(name = "Reservation  Controller",description="gestion des reservations")
public class ReservationController {
    @Autowired
    private ReservationService reservationService;
    @Operation(summary = "create une reservation",description = "insertion")
    @PostMapping("/createReservation")
    public ReservationDto createReservation(@RequestBody ReservationDto reservationDto)
    {
        return reservationService.createReservation(reservationDto);
    }
    @Operation(summary = "Renvoyer une liste de reservation",description = "liste")
    @GetMapping("/getAllReservation")
    public List<ReservationDto> getAllReservations()
    {
        return reservationService.getAllReservations();
    }
    @Operation(summary = "trouver une reservation par id",description = "id")
    @GetMapping("/getReservationById/{id}")
    public Optional<Reservation> getReservationById(@PathVariable Long id )
    {
        return reservationService.getReservationById(id );
    }
    @Operation(summary = "mise a jour des infos",description = "modifier les infos")
    @PutMapping("/updateReservation/{id}")
    public ReservationDto updateReservation(Long idReservation, ReservationDto reservationDto){
        return reservationService.updateReservation(idReservation,reservationDto);

    }
    @Operation(summary = "supprimer par id",description = "suppression")
    @DeleteMapping("/deleteReservationByID/{id}")
    public void deleteReservationByID(@PathVariable Long id )
    {
        reservationService.deleteById(id);
    }
}

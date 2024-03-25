package com.example.Authentification2.Service;

import com.example.Authentification2.Dto.ParkingDto;
import com.example.Authentification2.Dto.ReservationDto;
import com.example.Authentification2.Entity.Parking;
import com.example.Authentification2.Entity.Reservation;

import java.util.List;
import java.util.Optional;

public interface ReservationService {
    List<ReservationDto> getAllReservations();
    Optional<Reservation> getReservationById(Long id );
    ReservationDto createReservation(ReservationDto reservationDto);
    ReservationDto updateReservation(Long idReservation,ReservationDto reservationDto );
    void deleteById(Long id );
}

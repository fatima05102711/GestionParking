package com.example.Authentification2.Dto;

import com.example.Authentification2.Entity.Parking;
import com.example.Authentification2.Entity.Reservation;
import com.example.Authentification2.Entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ReservationDto {
    private Long id;
    private LocalDate dateCreation;
    private LocalDate dateFin;
    private User user;
    private int nombreJours;
    private int montantPayer;
    private Parking parking;
    private int montantTotal;

    public static ReservationDto fromEntity(Reservation reservation)
    {
        return ReservationDto.builder()
                .id(reservation.getId())
                .dateFin(reservation.getDateFin())
                .dateCreation(reservation.getDateCreation())
                .user(reservation.getUser())
                .montantPayer(reservation.getMontantPayer())
                .nombreJours(reservation.getNombreJours())
                .parking(reservation.getParking())
                .montantTotal(reservation.getMontantTotal())
                .build();
    }
    public static Reservation toEntity(ReservationDto reservationDto)
    {
        Reservation reservation = new Reservation();
        reservation.setId(reservationDto.getId());
        reservation.setDateFin(reservationDto.getDateFin());
        reservation.setUser(reservationDto.getUser());
        reservation.setMontantPayer(reservationDto.getMontantPayer());
        reservation.setNombreJours(reservationDto.getNombreJours());
        reservation.setParking(reservationDto.getParking());
        return reservation;
    }
}

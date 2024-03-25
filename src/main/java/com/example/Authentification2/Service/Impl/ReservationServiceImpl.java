package com.example.Authentification2.Service.Impl;

import com.example.Authentification2.Dto.ReservationDto;
import com.example.Authentification2.Entity.Parking;
import com.example.Authentification2.Entity.Reservation;
import com.example.Authentification2.Exceptions.EntityNotFoundException;
import com.example.Authentification2.Exceptions.ErreurCodes;
import com.example.Authentification2.Exceptions.InvalidEntityException;
import com.example.Authentification2.Repository.ParkingRepository;
import com.example.Authentification2.Repository.ReservationRepository;
import com.example.Authentification2.Service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ReservationServiceImpl implements ReservationService {
    @Autowired
    private ReservationRepository reservationRepository;
    @Autowired
    private ParkingRepository parkingRepository;

    @Override
    public List<ReservationDto> getAllReservations() {
        List<Reservation> reservations =reservationRepository.findAll();
        if (reservations.isEmpty())
        {
            throw new InvalidEntityException("Ya aucune reservation"+ ErreurCodes.RESERVATION_NOT_FOUND);
        }
        return  reservations.stream().map(ReservationDto::fromEntity)
                .collect(Collectors.toList());

    }
    @Override
    public Optional<Reservation> getReservationById(Long id) {
       Optional <Reservation> reservationOptional = reservationRepository.findById(id);
       if (reservationOptional.isPresent()){
           return reservationOptional;
       }else
       {
           throw new EntityNotFoundException("la reservation avec cet "+id+"n'existe pas",ErreurCodes.RESERVATION_NOT_FOUND);
       }

    }



    @Override
    public ReservationDto createReservation(ReservationDto reservationDto) {


        // Récupérer les détails de la réservation depuis le DTO
        LocalDate dateCreation =LocalDate.now();
        LocalDate dateFin = reservationDto.getDateFin();
        int nombreJours = reservationDto.getNombreJours();
        int montantPayer = reservationDto.getMontantPayer();
        int montantTotal = nombreJours * montantPayer;


        // Récupérer le parking depuis la base de données
        Parking parking = parkingRepository.findById(reservationDto.getParking().getId())
                .orElseThrow(() -> new EntityNotFoundException("parking not found"));


        // Vérifier s'il y a des places disponibles dans le parking
        if (parking.getNombrePlace() > 0) {
            // Créer une nouvelle réservation
            Reservation reservation = new Reservation();
         //   reservation.setDateCreation(dateCreation);
            reservation.setDateFin(dateFin);
            reservation.setNombreJours(nombreJours);
            reservation.setMontantPayer(montantPayer);
            reservation.setParking(parking);
            reservation.setMontantTotal(montantTotal);



            // Décrémenter le nombre de places disponibles dans le parking
            parking.setNombrePlace(parking.getNombrePlace() - 1);

            // Enregistrer la réservation dans la base de données
            reservation = reservationRepository.save(reservation);

            // Mettre à jour le parking dans la base de données
            parkingRepository.save(parking);

            // Convertir l'entité Reservation en DTO et la renvoyer
            return ReservationDto.fromEntity(reservation);
        } else {
            throw new InvalidEntityException("Nombre de place atteint impossible de "+ErreurCodes.PARKING_NOT_FOUND);
        }
    }


    @Override
    public ReservationDto updateReservation(Long idReservation, ReservationDto reservationDto) {
        Optional <Reservation> optionalReservation = reservationRepository.findById(idReservation);
        if (optionalReservation.isPresent())
        {
            //Mettre a jour les champs existant avec les donnees du Dto
            Reservation existingReservation = optionalReservation.get();
            existingReservation.setMontantPayer(reservationDto.getMontantPayer());
            existingReservation.setDateCreation(reservationDto.getDateCreation());
            existingReservation.setNombreJours(reservationDto.getNombreJours());
            existingReservation.setDateFin(reservationDto.getDateFin());
            reservationRepository.save(existingReservation);

        }
        else
        {
            throw new EntityNotFoundException("Cet id n'existe pas "+ErreurCodes.RESERVATION_NOT_FOUND);
        }
        return reservationDto;
    }

    @Override
    public void deleteById(Long id) {
        reservationRepository.deleteById(id);

    }
}

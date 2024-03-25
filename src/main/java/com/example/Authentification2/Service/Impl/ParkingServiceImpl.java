package com.example.Authentification2.Service.Impl;

import com.example.Authentification2.Dto.ParkingDto;
import com.example.Authentification2.Dto.UserDto;
import com.example.Authentification2.Entity.Parking;
import com.example.Authentification2.Entity.Vehicule;
import com.example.Authentification2.Repository.ParkingRepository;
import com.example.Authentification2.Repository.VehiculeRepository;
import com.example.Authentification2.Service.ParkingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;
@Service
public class ParkingServiceImpl implements ParkingService {

    private final ParkingRepository parkingRepository;
    private VehiculeRepository vehiculeRepository;

    public ParkingServiceImpl(ParkingRepository parkingRepository) {
        this.parkingRepository = parkingRepository;

    }

    @Override
    public List<Parking> getAllParkings() {

        return parkingRepository.findAll();
    }

    @Override
    public Optional<Parking> getParkingById(Long id) {
        Optional<Parking> parkingOptional = parkingRepository.findById(id);
        if (parkingOptional.isPresent()) {
            return parkingRepository.findById(id);
        }
        return null;
    }
    @Override
    public ParkingDto createParking(ParkingDto parkingDto) {
        //Verifie si l'id de la voiture existe
        Optional <Vehicule> optionalVehicule = vehiculeRepository.findById(parkingDto.getId());
        if(optionalVehicule.isPresent())
        {
             parkingDto.setVehicule(optionalVehicule.get());
        }
        parkingDto.setAuthorize(true);
        //initialisation du parking a 10
        if (StringUtils.isEmpty(parkingDto.getEmplacement())
                || StringUtils.isEmpty(parkingDto.getEtat())
                || StringUtils.isEmpty(parkingDto.getPrix())) {
            throw new IllegalArgumentException("Tous les champs doivent être remplis.");
        }
        else {
           return ParkingDto.fromEntity(parkingRepository.save(ParkingDto.toEntity(parkingDto)));
        }
        // Vérifier si le parking a encore des places disponibles
//
//        else if ((nombreplace == 0)) {
//            throw new IllegalArgumentException("Le parking est complet, impossible d'enregistrer.");
//        } else {
//            Parking parking = ParkingDto.toEntity(parkingDto);
//            Parking savedParking = parkingRepository.save(parking);
//           // nombreplace--;
//            return ParkingDto.fromEntity(savedParking);
//        }

    }

    @Override
    public ParkingDto updateParking(Long idParking, ParkingDto parkingDto) {
        Optional<Parking>  optionalParking = parkingRepository.findById(idParking) ;
        if(optionalParking.isPresent())
        {
            Parking existingParking = optionalParking.get();
            existingParking.setEtat(parkingDto.getEtat());
            existingParking.setEmplacement(parkingDto.getEmplacement());
            existingParking.setPrix(parkingDto.getPrix());
            parkingRepository.save(existingParking);
        }
        return parkingDto;
    }


    @Override
    public void deleteById(Long id) {
        Optional<Parking> optionalParking = parkingRepository.findById(id);
        if(optionalParking.isPresent())
        {
             parkingRepository.deleteById(id);
        }

    }




}

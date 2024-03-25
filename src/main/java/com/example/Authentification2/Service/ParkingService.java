package com.example.Authentification2.Service;

import com.example.Authentification2.Dto.ParkingDto;
import com.example.Authentification2.Dto.UserDto;
import com.example.Authentification2.Entity.Parking;
import com.example.Authentification2.Entity.User;

import java.util.List;
import java.util.Optional;

public interface ParkingService {
        List<Parking> getAllParkings();
       Optional<Parking> getParkingById(Long id );
       ParkingDto updateParking(Long idParking,ParkingDto parkingDto );
       void deleteById(Long id );
        ParkingDto createParking(ParkingDto parkingDto);
}

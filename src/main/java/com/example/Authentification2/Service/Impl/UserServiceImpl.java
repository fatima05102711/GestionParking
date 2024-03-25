package com.example.Authentification2.Service.Impl;

import com.example.Authentification2.Dto.UserDto;
import com.example.Authentification2.Entity.Reservation;
import com.example.Authentification2.Entity.User;
import com.example.Authentification2.Exceptions.EntityNotFoundException;
import com.example.Authentification2.Exceptions.ErreurCodes;
import com.example.Authentification2.Exceptions.InvalidEntityException;
import com.example.Authentification2.Repository.ReservationRepository;
import com.example.Authentification2.Repository.UserRepository;
import com.example.Authentification2.Service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private final UserRepository userRepository;
    //private final ReservationRepository reservationRepository;

    public UserServiceImpl(UserRepository userRepository ) {
        this.userRepository = userRepository;
    }


    @Override
    public List<UserDto> getAllUsers() {
          List<User> users =  userRepository.findAll();
          if(users.isEmpty())
          {
              throw new EntityNotFoundException("Aucun User trouver trouver dans la BD");
          }
        return users.stream().map(UserDto::fromEntity).collect(Collectors.toList());
    }

    //cette methode permet de rechercher un id user dans la table reservation
//    @Override
//    public List<User> findUserByReservationId(Long id) {
//        Optional<Reservation> reservationOptional = reservationRepository.findById(id);
//        if (reservationOptional.isPresent()) {
//            return userRepository.findUserByReservationId(reservationOptional.get().getId());
//        } else {
//            throw new IllegalArgumentException("la réservation avec cet id n'existe pas");
//        }
//    }

    @Override
    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public UserDto createUser(UserDto userDto) {
        if (StringUtils.isEmpty(userDto.getNom())
                || StringUtils.isEmpty(userDto.getPrenom())
                || StringUtils.isEmpty(userDto.getPassword())
                || StringUtils.isEmpty(userDto.getEmail())
                || StringUtils.isEmpty(userDto.getUsername()== null)
                 )
        {
            throw new InvalidEntityException("tous les champs doivent etre renseigne");

        } else if (userRepository.existsByEmail(userDto.getEmail())) {
            throw new EntityNotFoundException("Cet utilisateur exite dejà dans la Db");
        }
        else
        {
            return UserDto.fromEntity(userRepository.save(UserDto.toEntity(userDto)));
        }
    }

    @Override
    public UserDto updateUser(Long idUser, UserDto userDto) {
        Optional<User> optionalUser = userRepository.findById(idUser);
        if(optionalUser.isPresent())
        {
            User existingUser =optionalUser.get();
            existingUser.setUsername(userDto.getUsername());
            existingUser.setNom(userDto.getNom());
            existingUser.setEmail(userDto.getEmail());
            existingUser.setPassword(userDto.getPassword());
            existingUser.setPrenom(userDto.getPrenom());
         //  existingUser.setId(userDto.getId());
            userRepository.save(existingUser);
            return UserDto.fromEntity(existingUser);
        }

        else
        {
            throw new InvalidEntityException("le user avec cet id"+idUser+"n'existe pas", ErreurCodes.USER_NOT_FOUND);
        }

    }

    @Override
    public void deleteUserById(Long id) {
        Optional<User> optionalUser = userRepository.findById( id);
        if (optionalUser.isPresent())
        {
            userRepository.deleteById(id);
        }

    }
}

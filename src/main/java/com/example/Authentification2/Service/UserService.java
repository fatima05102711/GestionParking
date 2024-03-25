package com.example.Authentification2.Service;

import com.example.Authentification2.Dto.UserDto;
import com.example.Authentification2.Entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
     List<UserDto> getAllUsers();

//    List< User> findUserByReservationId(Long id);
     Optional<User> getUserById(Long id);
     UserDto createUser(UserDto userDto);
     UserDto updateUser(Long idUser,UserDto userDto);
     void deleteUserById(Long id );
}

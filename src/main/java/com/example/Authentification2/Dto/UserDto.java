package com.example.Authentification2.Dto;

import com.example.Authentification2.Entity.Reservation;
import com.example.Authentification2.Entity.User;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class UserDto {
    private Long id;
    private String nom ;
    private String prenom;
    private String password ;
    private String email;
//    private Reservation reservation;
    private String username;





    public static UserDto fromEntity(User user )
    {
        return UserDto.builder()
                .id(user.getId())
                .nom(user.getNom())
                .prenom(user.getPrenom())
                .email(user.getEmail())
                .username(user.getUsername()).build();
//                .reservation(user.getReservation()).build();

    }
    public static User toEntity(UserDto userDto)
    {
        User user = new User();
        user.setNom(userDto.getNom());
        user.setPrenom(userDto.getPrenom());
        user.setPassword(userDto.getPassword());
        user.setEmail(userDto.getEmail());
//        user.setReservation(userDto.getReservation());
        user.setUsername(userDto.getUsername());
        return user;

    }
}

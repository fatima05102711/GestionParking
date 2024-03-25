package com.example.Authentification2.Controller;

import com.example.Authentification2.Dto.UserDto;
import com.example.Authentification2.Entity.User;
import com.example.Authentification2.Service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/utilisateur")
@Tag(name = "Utilisateur Controller",description = "gestion des Users")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }
    @Operation(summary = "creer un User",description = "creation")
    @PostMapping("/createUser")
        public UserDto createUser(@RequestBody UserDto userDto)
        {
            return userService.createUser(userDto);
        }
        @Operation(summary = "renvois tous les User",description = "liste")
        @GetMapping("/getAllUsers")
        public List<UserDto> getAllUsers()
        {
            return userService.getAllUsers();
        }
      @GetMapping("/getUserById/{id}")
       public Optional<User> getUserById(@PathVariable Long id )
        {
           return userService.getUserById(id);
        }
//     @GetMapping("/findUserByReservationId/{id}")
//         public List<User> findUserByReservationId(@PathVariable Long id)
//         {
//             return userService.findUserByReservationId(id);
//        }
    @Operation(summary = "mofication des infos",description = "modification")
        @PutMapping("/updateUser/{idUser}")
        public UserDto updateUser(@PathVariable Long idUser, @RequestBody UserDto userDto)
        {
            return userService.updateUser(idUser,userDto);
        }
        @Operation(summary = "supprimer par id",description = "suppression")
        @DeleteMapping("/deleteUserById/{id}")
      public void deeteUserById(@PathVariable Long id)
        {
           userService.deleteUserById(id);
        }
}

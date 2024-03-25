package com.example.Authentification2.Repository;

import com.example.Authentification2.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    boolean existsByEmail(String email);
//    List<User> findUserByReservationId(Long reservations);
}

package com.example.Authentification2.Repository;

import com.example.Authentification2.Entity.Vehicule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehiculeRepository extends JpaRepository <Vehicule,Long> {
}

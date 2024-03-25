package com.example.Authentification2.Service.Impl;

import com.example.Authentification2.Dto.VehiculeDto;
import com.example.Authentification2.Entity.Vehicule;
import com.example.Authentification2.Exceptions.ErreurCodes;
import com.example.Authentification2.Repository.VehiculeRepository;
import com.example.Authentification2.Service.VehiculeService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class VehiculeServiceImpl implements VehiculeService {
    @Autowired
    private VehiculeRepository vehiculeRepository;
    @Override
    public List<VehiculeDto> getAllVehicules()
    {
        List<Vehicule> vehicules = vehiculeRepository.findAll();
        return vehicules.stream().map(VehiculeDto::fromEntity).collect(Collectors.toList()) ;
    }

    @Override
    public Optional<Vehicule> getVehiculeById(Long id) {
        Optional <Vehicule> optionalvehicule = vehiculeRepository.findById(id);

        return   vehiculeRepository.findById(id);
    }



    @Override
    public VehiculeDto createVehicule(VehiculeDto vehiculeDto) {
        if(StringUtils.isEmpty(vehiculeDto.getModele())
        || StringUtils.isEmpty(vehiculeDto.getImmatriculation())
        ||StringUtils.isEmpty(vehiculeDto.getMarque())
        ||StringUtils.isEmpty(vehiculeDto.getCouleur()))
        {
            throw new RuntimeException("tous les champs doivent etre remplis  ");
        }
        else {
            return VehiculeDto.fromEntity(vehiculeRepository.save(VehiculeDto.toEntity(vehiculeDto)));
        }
    }

    @Override
    public VehiculeDto updateVehicule(Long idVehicule, VehiculeDto vehiculeDto)
    {
        Optional <Vehicule> optionalVehicule = vehiculeRepository.findById(idVehicule);
        if(optionalVehicule.isPresent()){
            Vehicule extingVehicule = optionalVehicule.get();
            extingVehicule.setImmatriculation(vehiculeDto.getImmatriculation());
            extingVehicule.setMarque(vehiculeDto.getMarque());
            extingVehicule.setCouleur(vehiculeDto.getCouleur());
            extingVehicule.setModele(vehiculeDto.getModele());
            vehiculeRepository.save(extingVehicule);
        }
        else
        {
            throw  new EntityNotFoundException("cet id n'existe pas"+ ErreurCodes.VEHICULE_NOT_FOUND);
        }
        return null;
    }

    @Override
    public void deleteVehiculeById(Long id)
    {
        Optional <Vehicule> optionalVehicule = vehiculeRepository.findById(id);
        if (optionalVehicule.isPresent())
        {
            vehiculeRepository.findById(id);
        }
        else {
            throw  new EntityNotFoundException("impossible de supprimer un id"+ErreurCodes.VEHICULE_NOT_FOUND.getCode());
        }

    }
}

package com.project.bodega.service;

import com.project.bodega.model.RolEntity;
import com.project.bodega.repository.RolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RolServiceImpl implements  RolService{

    @Autowired
    private RolRepository rolRepository;

    @Override
    public List<RolEntity> getAllRoles() {
        return rolRepository.findAll();
    }

    @Override
    public RolEntity getRolById(Long id) {
        return rolRepository.findById(id).orElse(null);
    }

    @Override
    public RolEntity saveRol(RolEntity rol) {
        return rolRepository.save(rol);
    }

    @Override
    public RolEntity updateRol(Long id, RolEntity rol) {
        Optional<RolEntity> existingRol = rolRepository.findById(id);
        if(existingRol.isPresent()){
            RolEntity updatedRol = existingRol.get();
            updatedRol.setNombre(rol.getNombre());
            return rolRepository.save(updatedRol);
        }
        return null;
    }

    @Override
    public void deleteRol(Long id) {
        rolRepository.deleteById(id);
    }
}

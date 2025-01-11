package com.project.bodega.service;

import com.project.bodega.model.RolEntity;

import java.util.List;

public interface RolService {

    List<RolEntity> getAllRoles();
    RolEntity getRolById(Long id);
    RolEntity saveRol(RolEntity rol);
    RolEntity updateRol(Long id, RolEntity rol);
    void deleteRol(Long id);

}

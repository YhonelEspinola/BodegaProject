package com.project.bodega.service;

import com.project.bodega.model.UsuarioEntity;

import java.util.List;

public interface UsuarioService {

    List<UsuarioEntity> getAllUsuarios();
    UsuarioEntity getUsuarioById(Long id);
    UsuarioEntity saveUsuario(UsuarioEntity usuario);
    UsuarioEntity updateUsuario(Long id, UsuarioEntity usuario);
    void deleteUsuario(Long id);
    UsuarioEntity getUsuarioByCorreo(String correo);
}

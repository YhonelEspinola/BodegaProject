package com.project.bodega.service;

import com.project.bodega.model.UsuarioEntity;
import com.project.bodega.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServiceImpl implements  UsuarioService{

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public List<UsuarioEntity> getAllUsuarios() {
        return usuarioRepository.findAll();
    }

    @Override
    public UsuarioEntity getUsuarioById(Long id) {
        return usuarioRepository.findById(id).orElse(null);
    }

    @Override
    public UsuarioEntity saveUsuario(UsuarioEntity usuario) {
        return usuarioRepository.save(usuario);
    }

    @Override
    public UsuarioEntity updateUsuario(Long id, UsuarioEntity usuario) {
        Optional<UsuarioEntity> existingUsuario = usuarioRepository.findById(id);
        if (existingUsuario.isPresent()){
            UsuarioEntity updatedUsuario = existingUsuario.get();
            updatedUsuario.setNombre(usuario.getNombre());
            updatedUsuario.setCorreo(usuario.getCorreo());
            updatedUsuario.setDireccion(usuario.getDireccion());
            updatedUsuario.setTelefono(usuario.getTelefono());
            updatedUsuario.setRol(usuario.getRol());
            return usuarioRepository.save(updatedUsuario);
        }
        return null;
    }

    @Override
    public void deleteUsuario(Long id) {
        usuarioRepository.deleteById(id);

    }

    @Override
    public UsuarioEntity getUsuarioByCorreo(String correo) {
        return usuarioRepository.findByCorreo(correo);
    }
}

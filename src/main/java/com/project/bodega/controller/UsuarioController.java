package com.project.bodega.controller;

import com.project.bodega.Dto.UsuarioDto;
import com.project.bodega.model.UsuarioEntity;
import com.project.bodega.service.RolService;
import com.project.bodega.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private RolService rolService;

    @GetMapping("/listar")
    public ResponseEntity<List<UsuarioDto>> getAllUsuarios(){
        List<UsuarioDto> usuario = usuarioService.getAllUsuarios().stream().map(this::convertToDto).collect(Collectors.toList());
        return new ResponseEntity<>(usuario, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioDto> getUsuarioById(@PathVariable Long id){
        UsuarioEntity usuario = usuarioService.getUsuarioById(id);
        if(usuario != null){
            return new ResponseEntity<>(convertToDto(usuario), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<UsuarioDto> createUsuario(@RequestBody UsuarioDto usuarioDto){
        UsuarioEntity usuario = convertToEntity(usuarioDto);
        UsuarioEntity newUsuario = usuarioService.saveUsuario(usuario);
        return new ResponseEntity<>(convertToDto(newUsuario), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UsuarioDto> updateUsuario(@PathVariable Long id, @RequestBody UsuarioDto usuarioDto){
        UsuarioEntity usuario = convertToEntity(usuarioDto);
       UsuarioEntity updatedUsuario = usuarioService.updateUsuario(id, usuario);
       if(updatedUsuario != null){
           return new ResponseEntity<>(convertToDto(updatedUsuario), HttpStatus.OK);
       }
       return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUsuario(@PathVariable Long id){
        usuarioService.deleteUsuario(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }



    // Métodos auxiliares para conversión
    private UsuarioDto convertToDto(UsuarioEntity usuario) {
        UsuarioDto dto = new UsuarioDto();
        dto.setIdUsuario(usuario.getIdUsuario());
        dto.setNombre(usuario.getNombre());
        dto.setCorreo(usuario.getCorreo());
        dto.setTelefono(usuario.getTelefono());
        dto.setDireccion(usuario.getDireccion());
        dto.setIdRol(usuario.getRol().getIdRol());
        return dto;
    }

    private UsuarioEntity convertToEntity(UsuarioDto dto) {
        UsuarioEntity usuario = new UsuarioEntity();
        usuario.setNombre(dto.getNombre());
        usuario.setCorreo(dto.getCorreo());
        usuario.setTelefono(dto.getTelefono());
        usuario.setDireccion(dto.getDireccion());
        usuario.setRol(rolService.getRolById(dto.getIdRol())); // Obtener rol por ID
        return usuario;
    }

}

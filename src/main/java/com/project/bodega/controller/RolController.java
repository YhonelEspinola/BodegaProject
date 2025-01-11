package com.project.bodega.controller;

import com.project.bodega.model.RolEntity;
import com.project.bodega.service.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rol")
public class RolController {

    @Autowired
    private RolService rolService;

    @GetMapping
    public ResponseEntity<List<RolEntity>> getAllRoles(){
        List<RolEntity> roles = rolService.getAllRoles();
        return new ResponseEntity<>(roles, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<RolEntity> getRolById(@PathVariable Long id){
        RolEntity rol = rolService.getRolById(id);
        return new ResponseEntity<>(rol, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<RolEntity> createRol(@RequestBody RolEntity rol){
        RolEntity newRol = rolService.saveRol(rol);
        return new ResponseEntity<>(newRol, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RolEntity> updateRol(@PathVariable Long id, @RequestBody RolEntity rol){
        RolEntity updatedRol = rolService.updateRol(id, rol);
        if (updatedRol != null){
            return new ResponseEntity<>(updatedRol, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRol(@PathVariable Long id){
        rolService.deleteRol(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}

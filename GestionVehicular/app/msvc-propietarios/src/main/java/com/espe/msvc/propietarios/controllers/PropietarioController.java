/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author USER
 */
/*public class UsuarioController {

    @Autowired

    private UsuarioService service;

    @Autowired
    private List<Usuario> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")

    public ResponseEntity<?> detalle(@PathVariable Long id) {
        Optional<Usuario> usuarioOptional = service.porId(id);
        if (usuarioOptional.isPresent()) {
            return ResponseEntity.ok().body(usuarioOptional.get());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<?> crear(Usuario usuario) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.guardar(usuario));
    }

    @PostMapping("/{id}")
    public ResponseEntity<?> editar(@RequestBody Usuario usuario, @PathVariable Long id) {
        Optional<Usuario> usuarioOptional = service.porId(id);
        if (usuarioOptional.isPresent()) {
            Usuario usuarioDB = usuarioOptional.get();
            usuarioDB.setNombre(usuario.getNombre());
            usuarioDB.setEmail(usuario.getEmail());
            usuarioDB.setPassword(usuario.getPassword());
            return ResponseEntity.status(HttpStatus.CREATED).body(service.guardar(usuarioDB));
        }
        return ResponseEntity.notFound().build();
    }
}*/

package com.espe.msvc.propietarios.controllers;

import com.espe.msvc.propietarios.models.entity.Propietario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;
import com.espe.msvc.propietarios.services.PropietarioService;

@RestController
//@RequestMapping("/usuarios")
public class PropietarioController {

    @Autowired
    private PropietarioService service;
    

    @GetMapping
    public List<Propietario> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Propietario> detalle(@PathVariable Long id) {
        Optional<Propietario> usuarioOptional = service.porId(id);
        return usuarioOptional.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Propietario> crear(@RequestBody Propietario usuario) {
        Propietario nuevoUsuario = service.guardar(usuario);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoUsuario);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Propietario> editar(@RequestBody Propietario usuario, @PathVariable Long id) {
        Optional<Propietario> usuarioOptional = service.porId(id);
        if (usuarioOptional.isPresent()) {
            Propietario usuarioDB = usuarioOptional.get();
            usuarioDB.setNumeroIdentificacion(usuario.getNumeroIdentificacion());
            usuarioDB.setNombre(usuario.getNombre());
            usuarioDB.setDireccion(usuario.getDireccion());
            
            return ResponseEntity.ok().body(service.guardar(usuarioDB));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        Optional<Propietario> usuarioOptional = service.porId(id);
        if (usuarioOptional.isPresent()) {
            service.eliminar(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
    
}

    




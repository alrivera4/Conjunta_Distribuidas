package com.espe.msvc.vehiculos.controllers;

import com.espe.msvc.vehiculos.models.entity.Vehiculo;
import com.espe.msvc.vehiculos.models.entity.Propietario;
import feign.FeignException;
import java.util.Collections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import org.springframework.http.HttpStatus;
import com.espe.msvc.vehiculos.services.VehiculoService;


@RestController
//@RequestMapping("cursos")
public class VehiculoController {

    @Autowired
    private VehiculoService cursoService;


    @GetMapping
    public List<Vehiculo> listar() {
        return cursoService.listar();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Vehiculo> porId(@PathVariable Long id) {
        Optional<Vehiculo> cursoOptional = cursoService.porId(id);
        return cursoOptional.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Vehiculo guardar(@RequestBody Vehiculo curso) {
        return cursoService.guardar(curso);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Vehiculo> actualizar(@PathVariable Long id, @RequestBody Vehiculo curso) {
        Optional<Vehiculo> cursoOptional = cursoService.porId(id);
        if (cursoOptional.isPresent()) {
            Vehiculo cursoDb = cursoOptional.get();
            cursoDb.setModelo(curso.getModelo());
            return ResponseEntity.ok(cursoService.guardar(cursoDb));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        Optional<Vehiculo> cursoOptional = cursoService.porId(id);
        if (cursoOptional.isPresent()) {
            cursoService.eliminar(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
    
    
    @PutMapping("/asignar-propietario/{idvehiculo}")
    public ResponseEntity<?> asignarUsuario(@RequestBody Propietario usuario, @PathVariable Long idvehiculo){
        Optional<Propietario> o;
        try{
            o=cursoService.agregarUsuario(usuario, idvehiculo);
        }
        catch(FeignException e){
           return ResponseEntity.status(HttpStatus.NOT_FOUND)
                   .body(Collections.singletonMap("mensaje","Error: "+ e.getMessage()));
           
        }
        
        if(o.isPresent()){
            return ResponseEntity.status(HttpStatus.CREATED).body(o.get());
            
        }
        return ResponseEntity.notFound().build();
    }
    
   
}
